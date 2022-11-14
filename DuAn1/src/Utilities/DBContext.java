/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Utilities;

import com.microsoft.sqlserver.jdbc.SQLServerDriver;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author levan
 */
public class DBContext {
    private static final String USERNAME = "sa";
    private static final String PASSWORD = "100314";
    private static final String SERVER_NAME = "LAPTOP-T7QI4P5F\\HIEP";
    private static final String PORT = "1433";
    private static final String DATABASE_NAME = "DuAn1_Nhom6";
    private static final boolean USING_SSL = true;
    
    private static String CONNECT_STRING;
    
    static {
        try {
            DriverManager.registerDriver(new SQLServerDriver());
            
            StringBuilder connectStringBuilder = new StringBuilder();
            connectStringBuilder.append("jdbc:sqlserver://")
                    .append(SERVER_NAME).append(":").append(PORT).append(";")
                    .append("databaseName=").append(DATABASE_NAME).append(";")
                    .append("user=").append(USERNAME).append(";")
                    .append("password=").append(PASSWORD).append(";")
                    ;
            if (USING_SSL) {
                connectStringBuilder.append("encrypt=true;trustServerCertificate=true;");
            }
            CONNECT_STRING = connectStringBuilder.toString();
            System.out.println("Connect String có dạng: " + CONNECT_STRING);
        } catch (Exception ex) {
        }
    }
    
    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(CONNECT_STRING);
    }
    
    public static void main(String[] args) throws SQLException {
        Connection conn = getConnection();
        String dbpn = conn.getMetaData().getDatabaseProductName();
        System.out.println(dbpn);
    }
}
