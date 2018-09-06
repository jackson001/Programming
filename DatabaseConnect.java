/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author King
 */
public class DatabaseConnect {

    public static Connection ConnectToDB() {
        try {

            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/attendant", "root", "");
            return con;

        } catch (ClassNotFoundException | SQLException e) {
            return null;
        }
    }
}
