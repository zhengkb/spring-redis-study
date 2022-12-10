package com.zkb.springredisstudy.base.classloader;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ServiceLoader;

public class SpiTest {
    public static void main(String[] args) throws SQLException {
        String url = "jdbc:mysql://localhost:3306/stu";
        Connection connection = DriverManager.getConnection(url, "root", "root");
    }
}
