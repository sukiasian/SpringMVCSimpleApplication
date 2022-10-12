package ru.sukiasian.secondtrialproject.config;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.DriverManager.*;
import java.util.Properties;

public class Database {
    public static Connection connect() throws java.sql.SQLException {
        String url = "jdbc:postgresql://localhost/";

        Properties props = new Properties();

        props.setProperty("port", "5432");
        props.setProperty("user", "samvelsukiasian");
        props.setProperty("password", "postgres123");
        props.setProperty("database", "spaceboo");

        return DriverManager.getConnection(url, props);
    }
}
