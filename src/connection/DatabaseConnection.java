/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author codexhaq
 */
public class DatabaseConnection {

    public Connection conn;
    public ResultSet rs;
    public PreparedStatement ps;

    public Connection getConn() {
        if (conn == null) {
            try {
                Class.forName("com.mysql.jdbc.Driver");

                try {
                    String url = "jdbc:mysql://35.185.177.67:3306/zubi_clinic";
                    conn = DriverManager.getConnection(url, "develop", "develop");
                    System.out.println("Koneksi Sukses");
                } catch (SQLException ex) {
                    System.out.println("Koneksi gagal" + ex);
                    System.exit(0);
                }

            } catch (ClassNotFoundException ex) {
                Logger.getLogger(DatabaseConnection.class.getName()).log(Level.SEVERE, null, ex);
            }

        }
        return conn;
    }

    public ResultSet getRs() {
        return rs;
    }

    public boolean executeQuery(String query, boolean type) {
        try {
            ps = conn.prepareStatement(query);
            if (type) {
                rs = ps.executeQuery();
            } else {
                ps.executeUpdate();
            }
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(DatabaseConnection.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }

    }

    public static void main(String[] args) {
        new DatabaseConnection().getConn();
    }
}
