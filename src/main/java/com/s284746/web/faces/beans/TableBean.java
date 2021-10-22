package com.s284746.web.faces.beans;

import com.s284746.web.faces.event.DataDeleter;
import com.s284746.web.faces.struct.Result;
import com.s284746.web.faces.util.SQLProcessor;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import java.io.*;
import java.sql.SQLException;
import java.util.List;

/**
 * Class for table visualization.
 */
@SuppressWarnings("deprecation") // deprecated classes are required for this task
@ManagedBean(name = "store")
@SessionScoped
public class TableBean implements Serializable {
	@Serial
	private static final long serialVersionUID = 1L;
	/**
	 * Currently logging user's name.
	 */
	private String userName;
	/**
	 * Currently logging user's ID.
	 */
	private int userID;

	/**
	 * Getter for parameter userID.
	 * @return value of userID
	 */
	public int getUserID() {
		return userID;
	}

	/**
	 * Getter for parameter userName.
	 * @return value of userName
	 */
	public String getUserName() {
		return userName;
	}

	/**
	 * Setter for parameters userName and userID.
	 * Assigns <code>name</code> to <code>username</code> field.
	 * Retrieves ID of the user from database (if the user doesn't exist, creates new ID).
	 * Assigns retrieved user ID to <code>userID</code> field.
	 * @param name username entered by user
	 * @throws SQLException if database reading fails
	 */
	public void setUserName(String name) throws SQLException {
		userName = name;
		userID = SQLProcessor.getUserID(name);
		DataDeleter.userid = userID;
	}

	/**
	 * Loads results from database and saves them as list.
	 * Thrown exceptions are caught and printed to <code>System.out</code>.
	 * @return list of structured results
	 */
	public List<Result> getData() {
		try {
			return SQLProcessor.loadDataFromDatabase(userID);
		} catch (Exception exception) {
			exception.printStackTrace();
			return null;
		}
	}
}
