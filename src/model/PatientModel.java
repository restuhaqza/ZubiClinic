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
import java.util.HashSet;
import java.util.List;
import model.Entity.PatientEntity;

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
    
    public ArrayList<PatientEntity> getAllPatient() throws Exception{
        query = "SELECT * FROM patients";
        hasil = dbConn.executeQuery(query, true);
        ArrayList<PatientEntity> record = new ArrayList<PatientEntity>();
        if(hasil){
            rsPatient = dbConn.getRs();
            while(rsPatient.next()){
                PatientEntity patient = new PatientEntity();
                patient.setId(rsPatient.getInt("id"));
                patient.setName(rsPatient.getString("patient_name"));
                patient.setAddress(rsPatient.getString("address"));
                patient.setIdNumber(rsPatient.getString("identity_id"));
                patient.setBirth_date(rsPatient.getString("birth_date"));
                patient.setEmail(rsPatient.getString("email"));
                record.add(patient);
            }
        }
        return record;
    }
    
    /**
     *
     * @param id
     * @throws SQLException
     */
    public PatientEntity getOnePatient(String id) throws SQLException{
        query = "SELECT * FROM patients where id='"+id+"'";
        hasil = dbConn.executeQuery(query, true);
        PatientEntity patient = new PatientEntity();
        if(hasil){
            rsPatient = dbConn.getRs();
            rsPatient.next();
            
            patient.setId(rsPatient.getInt("id"));
            patient.setName(rsPatient.getString("patient_name"));
            patient.setAddress(rsPatient.getString("address"));
            patient.setIdNumber(rsPatient.getString("identity_id"));
            patient.setBirth_date(rsPatient.getString("birth_date"));
            patient.setEmail(rsPatient.getString("email"));
        }
        
        return patient;
    }
    
    public boolean updatePatient(){
        query = "UPDATE patients SET patient_name='"+fullName+"', "
                + "address='"+address+"',"
                + "identity_id='"+identityId+"',"
                + "birth_date='"+birthDate+"',"
                + "email='"+email+"'"
                + "WHERE id='"+id+"'";
        hasil = dbConn.executeQuery(query, false);
        return hasil;
    }
    
    public boolean deletePatient(){
        query = "DELETE FROM patients WHERE id='"+id+"'";
        hasil = dbConn.executeQuery(query, false);
        return hasil;
    }
}
