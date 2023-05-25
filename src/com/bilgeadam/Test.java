package com.bilgeadam;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Test {

	public static void main(String[] args) {

		String url = "jdbc:postgresql://localhost:5858/northwind";
		String password = "root";
		String username = "postgres";
		Connection connection = null;
		try {
			connection = DriverManager.getConnection(url, username, password);
			System.out.println("Bağlantı başarılı");
			String sql = "insert into categories (category_name) values(?)";
			PreparedStatement ps = connection.prepareStatement(sql);
			ps.setString(1, "JAVA");
			int count = ps.executeUpdate();
			System.out.println(count);

		} catch (SQLException e) {
			System.out.println("Bağlantı başarısız!!!!");
			e.printStackTrace();
		}
	}
}
