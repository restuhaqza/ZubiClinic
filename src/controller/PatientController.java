/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.sql.SQLException;
import java.util.ArrayList;
import model.Entity.PatientEntity;
import model.PatientModel;
import views.patient.IntPatient;
import views.patient.PatientRegister;

/**
 *
 * @author codexhaq
 */
public class PatientController {
    
    PatientModel patientModel;
    PatientRegister registerView;
    IntPatient mainView;
    
    public PatientController(PatientRegister registerView){
        patientModel = new PatientModel();
        this.registerView = registerView;       
    }
    
    public PatientController(IntPatient mainView){
        patientModel = new PatientModel();
        this.mainView = mainView;
    }
    
    public boolean insertPatient(String fullName, String address, String identityId, String birthDate, String email){
        patientModel.setFullName(fullName);
        patientModel.setAddress(address);
        patientModel.setIdentityId(identityId);
        patientModel.setBirthDate(birthDate);
        patientModel.setEmail(email);
        return patientModel.insertPatient();
    }
    
    public  ArrayList<PatientEntity> readAll() throws Exception{
        return patientModel.getAllPatient();
    }
    
    public PatientEntity getOnePatient(String id) throws SQLException{
        return patientModel.getOnePatient(id);
    }
    
    public boolean updatePatient(int id, String fullName, String address,String identityId, String birthDate, String email){
        patientModel.setId(id);
        patientModel.setFullName(fullName);
        patientModel.setAddress(address);
        patientModel.setIdentityId(identityId);
        patientModel.setBirthDate(birthDate);
        patientModel.setEmail(email);
        return patientModel.updatePatient();
    }
    
    public boolean deletePatient(int id){
        patientModel.setId(id);
        return patientModel.deletePatient();
    }
}
