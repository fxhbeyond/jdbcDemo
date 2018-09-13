package com.fanxh.jdbc.utils;

import java.io.InputStream;
import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.util.Properties;

/**
 * Created by user on 2018/9/13.
 */
public class NewConnnect {
    public Connection getConnect() throws Exception {
        String driverClass = null;
        String url = null;
        String user = null;
        String password = null;

        InputStream in = getClass().getClassLoader().getResourceAsStream("jdbc.properties");
        Properties ps = new Properties();
        ps.load(in);

        driverClass = ps.getProperty("driverClass");//#  com.mysql.jdbc.Driver
        url = ps.getProperty("url");//#jdbc:mysql://localhost:3306/test
        user = ps.getProperty("user");
        password = ps.getProperty("password");

        Driver driver = (Driver) Class.forName(driverClass).newInstance();
        Properties info = new Properties();
        info.put("user","root");
        info.put("password","1234");
        Connection connection = driver.connect(url,info);
        return connection;
    }


    public Connection getConnect1() throws Exception {
        String driverClass = null;
        String url = null;
        String user = null;
        String password = null;

        InputStream in = getClass().getClassLoader().getResourceAsStream("jdbc.properties");
        Properties ps = new Properties();
        ps.load(in);

        driverClass = ps.getProperty("driverClass");//#  com.mysql.jdbc.Driver  jdbc:oracle:thin:@localhost:1521:orcl
        url = ps.getProperty("url");//#jdbc:mysql://localhost:3306/test
        user = ps.getProperty("user");
        password = ps.getProperty("password");

        Properties info = new Properties();
        info.put("user","root");
        info.put("password","1234");
        Class.forName(driverClass);
        Connection connection = DriverManager.getConnection(url,user,password);
        return connection;
    }
}
