package com.s284746.web.faces.util;

import com.s284746.web.faces.struct.Result;
import org.hsqldb.jdbc.JDBCDriver;

import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Class with database utilities
 */
public class SQLProcessor {
	private static final String DATABASE = "webapp3";
	private static Statement statement;

	static {
		try {
			String url = "jdbc:hsqldb:file:" + DATABASE + ";hsqldb.lock_file=false";
			DriverManager.registerDriver(new JDBCDriver());
			Connection connection = DriverManager.getConnection(url);
			statement = connection.createStatement();
		} catch (Exception exception) {
			exception.printStackTrace();
		}
	}

	/**
	 * Creates new database if it doesn't exist
	 * Reads instructions from the <code>init-ddl.sql</code> resource file and then executes them
	 * @throws SQLException if commands execution fails
	 * @throws IOException if commands reading fails
	 */
	public static void initDB() throws SQLException, IOException {
		statement.execute(readFile("src/main/resources/init-ddl.sql"));
	}

	/**
	 * Deletes existing database
	 * @throws SQLException if commands execution fails
	 */
	public static void dropDB() throws SQLException {
		statement.execute("DROP TABLE RESULT_SHEET");
		statement.execute("DROP TABLE USERS");
	}

	/**
	 * Finds a user that has a specified username
	 * If there isn't a user having this username, new ID is created
	 * @param username username
	 * @return user ID
	 * @throws SQLException if database reading fails
	 */
	public static int getUserID(String username) throws SQLException {
		ResultSet resultSet = statement.executeQuery("SELECT ID FROM USERS WHERE NICKNAME = '" + username + "'");
		if (resultSet.next())
			return resultSet.getInt("id");
		resultSet = statement.executeQuery("SELECT COUNT(ID) FROM USERS");
		resultSet.next();
		int quant = resultSet.getInt(1);
		++quant;
		statement.execute("INSERT INTO USERS VALUES (" + quant + ", '" + username + "')");
		return quant;
	}

	/**
	 * Retrieves checking results from the database
	 * @param userid ID of user whose results we need
	 * @return list of results
	 * @throws SQLException if database reading fails
	 */
	public static List<Result> loadDataFromDatabase(int userid) throws SQLException {
		ResultSet resultSet = statement
				.executeQuery("SELECT X, Y, R, INCLUDED FROM RESULT_SHEET WHERE USER_ID = " + userid);
		List<Result> results = new ArrayList<>();
		while (resultSet.next()) {
			double x = resultSet.getDouble("x");
			double y = resultSet.getDouble("y");
			double r = resultSet.getDouble("r");
			boolean included = resultSet.getBoolean("included");
			results.add(new Result(x, y, r, included));
		}
		return results;
	}

	/**
	 * Reads all characters from a file
	 * @param filename full relative or absolute path to the file
	 * @return file contents
	 * @throws IOException if file reading fails
	 */
	public static String readFile(String filename) throws IOException {
		Reader reader = new FileReader(filename);
		StringBuilder b = new StringBuilder();
		int c = reader.read();
		while (c >= 0) {
			b.append((char) c);
			c = reader.read();
		}
		reader.close();
		return b.toString();
	}

	/**
	 * Saving checking result to the database
	 * @param userid ID of user who checked the point
	 * @param x point coordinate X
	 * @param y point coordinate Y
	 * @param r area parameter R
	 * @param included is the point included in the area or not
	 * @throws SQLException if result saving fails
	 */
	public static void saveResult(int userid, double x, double y, double r, boolean included) throws SQLException {
		statement.execute(
				"INSERT INTO RESULT_SHEET VALUES (" + userid + ", " + x + ", " + y + ", " + r + ", " + included + ")");
	}

	/**
	 * Removes data of checks made by specified user
	 * Does NOT remove a user
	 * @param userid ID of user whose data we want to delete
	 * @throws SQLException if data deletion fails
	 */
	public static void deleteData(int userid) throws SQLException {
		statement.execute("DELETE FROM RESULT_SHEET WHERE USER_ID = " + userid);
	}
}
