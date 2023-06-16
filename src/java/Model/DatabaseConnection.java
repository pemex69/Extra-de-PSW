/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

/**
 *
 * @author que
 */
import java.sql.*;

public class DatabaseConnection {

    public static Connection getConnection() {
        String url, userName, password;

        url = "jdbc:mysql://localhost:3306/veterinaria";
        userName = "super";
        password = "F82DC03344Do!";
        Connection con = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection(url, userName, password);
            System.out.println("DB connected . . .");
        } catch (ClassNotFoundException | SQLException e) {
            System.out.println("Error while trying to connect to DB: " + e.getMessage());
        }
        return con;
    }
}
