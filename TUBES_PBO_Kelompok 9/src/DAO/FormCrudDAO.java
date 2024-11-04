/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class FormCrudDAO {
    private Connection connection;

    // Constructor accepting a connection, useful for dependency injection in tests
    public FormCrudDAO(Connection connection) {
        this.connection = connection;
    }

    // Example method to retrieve data from the database
    public String getData() throws SQLException {
        String result = null;
        String query = "SELECT column_name FROM tb_mahasiswa LIMIT 1"; // Adjust as needed

        try (Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(query)) {
            if (resultSet.next()) {
                result = resultSet.getString("column_name"); // Adjust based on actual column name
            }
        }
        return result;
    }
}
