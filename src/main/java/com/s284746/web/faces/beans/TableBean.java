package com.s284746.web.faces.beans;

import com.s284746.web.faces.event.DataDeleter;
import com.s284746.web.faces.struct.Result;
import com.s284746.web.faces.util.SQLProcessor;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import java.io.*;
import java.sql.SQLException;
import java.util.List;

@SuppressWarnings("deprecation") // deprecated classes are required for this task
@ManagedBean(name = "store")
@SessionScoped
public class TableBean implements Serializable {
	@Serial
	private static final long serialVersionUID = 1L;

	private String userName;
	private int userID;

	public int getUserID() {
		return userID;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String name) throws SQLException {
		userName = name;
		userID = SQLProcessor.getUserID(name);
		DataDeleter.userid = userID;
	}

	public List<Result> getData() {
		try {
			return SQLProcessor.loadDataFromDatabase(userID);
		} catch (Exception exception) {
			exception.printStackTrace();
			return null;
		}
	}
}
