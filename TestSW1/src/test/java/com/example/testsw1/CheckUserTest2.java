package com.example.testsw1;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.sql.*;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class CheckUserTest2 {

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
    public void testUserExistence() throws SQLException {
        // имя пользователя для проверки
        String username = "testuser";

        // выполнение запроса на выборку пользователя из базы данных
        PreparedStatement statement = connection.prepareStatement("SELECT * FROM users WHERE login = ?");
        statement.setString(1, username);
        ResultSet result = statement.executeQuery();

        // проверка, что хотя бы один пользователь с указанным именем существует
        assertTrue(result.next());
    }

    @Test
    public void testUserNonExistence() throws SQLException {
        // имя несуществующего пользователя для проверки
        String username = "nonexistinguser";

        // выполнение запроса на выборку пользователя из базы данных
        PreparedStatement statement = connection.prepareStatement("SELECT * FROM users WHERE login = ?");
        statement.setString(1, username);
        ResultSet result = statement.executeQuery();

        // проверка, что пользователь не найден
        assertFalse(result.next());
    }
    @After
    public void tearDown() throws SQLException {
        // закрытие соединения с базой данных
        connection.close();
    }

}
