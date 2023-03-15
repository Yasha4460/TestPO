package com.example.testsw1;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.sql.*;

import static junit.framework.TestCase.assertEquals;
import static junit.framework.TestCase.assertTrue;
import static org.junit.Assert.assertNotNull;

public class DataBaseConnectionCheck3 {
    private Connection connection;

    @Before
    public void setUp() throws SQLException {
        // установление соединения с базой данных
        String url = "jdbc:postgresql://localhost/TestyUnit";
        String user = "postgres";
        String password = "Yasha4460";
        connection = DriverManager.getConnection(url, user, password);
    }

    @Test
    public void testDatabaseConnection() {
        // проверка, что соединение установлено успешно
        assertNotNull(connection);
    }

    @After
    public void tearDown() throws SQLException {
        // закрытие соединения с базой данных
        connection.close();
    }

}
