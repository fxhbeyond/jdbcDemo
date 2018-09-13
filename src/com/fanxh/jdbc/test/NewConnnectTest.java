package com.fanxh.jdbc.test;

import com.fanxh.jdbc.utils.NewConnnect;
import org.junit.Test;

import java.sql.Connection;
import java.sql.Statement;

/**
 * Created by user on 2018/9/13.
 */
public class NewConnnectTest {
    NewConnnect nc = new NewConnnect();
    @org.junit.Test
    public void getConnect() throws Exception {
        System.out.println(nc.getConnect());
    }
    @org.junit.Test
    public void getConnect2() throws Exception {
        System.out.println(nc.getConnect1());
    }

    @Test
    public void testStatement() throws Exception {
        Connection conn = nc.getConnect1();
        String sql = "insert into customer(NAME,email,birth) VALUES('xyz','xyz@sina.com','1990-12-10')";
        Statement statement = conn.createStatement();
        statement.executeUpdate(sql);
        statement.close();

        conn.close();
    }

}