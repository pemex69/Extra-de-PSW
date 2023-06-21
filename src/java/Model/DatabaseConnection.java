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
            Connection conn = DriverManager.getConnection(
                    "jdbc:mysql://aws.connect.psdb.cloud/veterinaria?sslMode=VERIFY_IDENTITY",
                    "6hr8nng41i9wdv9h3nxf",
                    "pscale_pw_8LAjKjIRFca2fTO1ckj3a9mkMFNC8pnnZK4WA83Eipk");
            System.out.println("DB connected . . .");
            return conn;

        } catch (ClassNotFoundException | SQLException e) {
            System.out.println("Error while trying to connect to DB: " + e.getMessage());
        }
        return con;
    }
}
