/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import connection.DatabaseConnection;
import java.sql.ResultSet;
import java.sql.SQLException;
import org.mindrot.jbcrypt.BCrypt;
import util.lib.Password;

/**
 *
 * @author codexhaq
 */
public class AdminModel {

    private DatabaseConnection dbConn;
    private String query;
    private boolean hasil;
    private ResultSet rsAdmin;

    public AdminModel() {
        dbConn = new DatabaseConnection();
        dbConn.getConn();
    }

    /**
     * Variable for Admin Table
     */
    private int id;
    private String full_name, email, password, role;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFull_name() {
        return full_name;
    }

    public void setFull_name(String full_name) {
        this.full_name = full_name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public boolean loginAdmin() {
        query = "SELECT * from administrators WHERE email = '" + email + "' ";
//                + "AND password = '" + password+ "'";
        hasil = dbConn.executeQuery(query, true);
        if (hasil) {
            rsAdmin = dbConn.getRs();
            try {
                rsAdmin.next();
                System.out.println(rsAdmin.getString("password"));
                String hash_bcrypt = "$2a" + rsAdmin.getString("password").substring(3);
                if (BCrypt.checkpw(password, hash_bcrypt)) {
                    id = rsAdmin.getInt("id");
                    full_name = rsAdmin.getString("full_name");
                    email = rsAdmin.getString("email");

                    if (full_name == null) {
                        hasil = false;
                    } else {
                        hasil = true;
                    }
                }else{
                    return false;
                }
                   

            } catch (SQLException e) {
                hasil = false;
            }
        }
        return hasil;
    }
    
}
