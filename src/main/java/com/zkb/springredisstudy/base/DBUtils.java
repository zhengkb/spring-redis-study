package com.zkb.springredisstudy.base;

import lombok.SneakyThrows;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBUtils {

    private static ThreadLocal<Connection> connectionThreadLocal = new ThreadLocal<Connection>() {
        @Override
        @SneakyThrows
        protected Connection initialValue() {
            return DriverManager.getConnection(
                    "jdbc:mysql:127.0.0.1:3306/test?user=root£¦password=root");
        }
    };

    public static Connection getConnection() {
        return connectionThreadLocal.get();
    }
}
