/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entity;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * Class này quản lý việc kết nối với cơ sở dữ liệu
 * @author nhom06
 */
public class ConnectToDB {

    public static Connection conn = null;

    /**
     * Hàm này lấy 1 kết nối tới cơ sở dữ liệu
     * @return Connection là 1 kết nối tới cơ sở dữ liệu
     */
    public static Connection getConnection() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/mxh", "root", "abcdef");
           
        } catch (ClassNotFoundException | SQLException e) {
            System.out.println("Ket noi bi loi");
        }
        return conn;
    }

    /**
     * Hàm này đóng kết nối tới cơ sở dữ liệu
     */
    public void closeDB() {
        if (conn != null) {
            try {
                if (!conn.isClosed()) {
                    conn.close();
                    conn = null;
                }
            } catch (SQLException ex) {
            }
        }

    }

}
