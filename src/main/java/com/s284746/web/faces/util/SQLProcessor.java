package com.s284746.web.faces.util;

import com.s284746.web.faces.struct.Result;
import org.postgresql.Driver;

import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class SQLProcessor {
	private static final String HOSTNAME = "localhost";
	private static final int PORT = 5432;
	private static final String USERNAME = "postgres";
	private static final String PASSWORD = "boxapp";
	private static final String DATABASE = "webapp3";
	private static Statement statement;

	static {
		try {
			String url = "jdbc:postgresql://" + HOSTNAME + ':' + PORT + '/' + DATABASE;
			DriverManager.registerDriver(new Driver());
			Connection connection = DriverManager.getConnection(url, USERNAME, PASSWORD);
			statement = connection.createStatement();
		} catch (Exception exception) {
			exception.printStackTrace();
		}
	}

	public static void initDB() throws SQLException, IOException {
		statement.execute(readFile("resources/init-ddl.sql"));
	}

	public static void dropDB() throws SQLException {
		statement.execute("DROP TABLE RESULT_SHEET");
		statement.execute("DROP TABLE USERS");
	}

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

	public static void saveResult(int userid, double x, double y, double r, boolean included) throws SQLException {
		statement.execute(
				"INSERT INTO RESULT_SHEET VALUES (" + userid + ", " + x + ", " + y + ", " + r + ", " + included + ")");
	}

	public static void deleteData(int userid) throws SQLException {
		statement.execute("DELETE FROM RESULT_SHEET WHERE USER_ID = " + userid);
	}
}
