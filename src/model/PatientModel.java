/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import connection.DatabaseConnection;
import java.sql.ResultSet;

/**
 *
 * @author codexhaq
 */
public class PatientModel {
    private DatabaseConnection dbConn;
    private String query;
    private boolean hasil;
    private ResultSet rsPatient;
    
    public PatientModel(){
        dbConn = new DatabaseConnection();
        dbConn.getConn();
    }
    
    private int id;
    private String fullName, email, password, birthDate, identityId, address;

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(String birthDate) {
        this.birthDate = birthDate;
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

    public String getIdentityId() {
        return identityId;
    }

    public void setIdentityId(String identityId) {
        this.identityId = identityId;
    }
    
    public boolean insertPatient(){
        query = "INSERT INTO patients (patient_name, address, identity_id, birth_date, email, password) VALUES "+""
                + "('"+ fullName + "', '" + address + "', '"+ identityId +"','"+ birthDate+"', '"+ email + "', '123456789')";
        hasil = dbConn.executeQuery(query, false);
        return hasil;
    }
    
    public boolean getAllPatient(){
        query = "SELECT * FROM patients";
        hasil = dbConn.executeQuery(query, false);
        return hasil;
    }
}
