/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import connection.DatabaseConnection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import model.Entity.PatientEntity;

/**
 *
 * @author codexhaq
 */
public class DoctorModel {
    private DatabaseConnection dbConn;
    private String query;
    private boolean hasil;
    private ResultSet rsDoctor;
    
    public DoctorModel(){
        dbConn = new DatabaseConnection();
        dbConn.getConn();
    }
    
    private int id;
    private String fullName, numberPhone, address, email, password;

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

    public String getNumberPhone() {
        return numberPhone;
    }

    public void setNumberPhone(String numberPhone) {
        this.numberPhone = numberPhone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
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
    
    public boolean insertDoctor(){
        query = "INSERT INTO doctor(name_doctor, number_phone, address, email) VALUES ("
                + "'"+fullName+"',"
                + "'"+numberPhone+"',"
                + "'"+address+"',"
                + "'"+email+"'"
                + ")";
        hasil = dbConn.executeQuery(query, false);
        return hasil;
    }
    
    public ArrayList<DoctorModel> getAllDoctor() throws SQLException{
        query = "SELECT * FROM doctor";
        hasil = dbConn.executeQuery(query, true);
        ArrayList<DoctorModel> record = new ArrayList<DoctorModel>();
        if(hasil){
            rsDoctor = dbConn.getRs();
            while(rsDoctor.next()){
                DoctorModel doctor = new DoctorModel();
                doctor.setId(rsDoctor.getInt("id_doctor"));
                doctor.setFullName(rsDoctor.getString("name_doctor"));
                doctor.setNumberPhone(rsDoctor.getString("number_phone"));
                doctor.setAddress(rsDoctor.getString("address"));
                doctor.setEmail(rsDoctor.getString("email"));  
                record.add(doctor);
            }
        }
        return record;
    }
    
    public DoctorModel getOnePatient(String id) throws SQLException{
        query = "SELECT * FROM doctor where id_doctor='"+id+"'";
        hasil = dbConn.executeQuery(query, true);
        DoctorModel doctor = new DoctorModel();
        if(hasil){
            rsDoctor = dbConn.getRs();
            rsDoctor.next();
            
            doctor.setId(rsDoctor.getInt("id_doctor"));
            doctor.setFullName(rsDoctor.getString("name_doctor"));
            doctor.setAddress(rsDoctor.getString("address"));
            doctor.setNumberPhone(rsDoctor.getString("number_phone"));
            doctor.setEmail(rsDoctor.getString("email"));
            
        }
        
        return doctor;
    }
    
    public boolean updateDoctor(){
        query = "UPDATE doctor SET "
                + "name_doctor='"+fullName+"',"
                + "address='"+address+"',"
                + "number_phone='"+numberPhone+"',"
                + "email='"+email+"'"
                + "WHERE id_doctor='"+id+"'";
        hasil = dbConn.executeQuery(query, false);
        return hasil;
    }
    
    public boolean deleteDoctor(){
        query = "DELETE FROM doctor WHERE id_doctor='"+id+"'";
        hasil = dbConn.executeQuery(query, false);
        return hasil;
    }
}
