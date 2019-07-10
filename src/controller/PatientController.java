/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import model.PatientModel;
import views.patient.PatientRegister;

/**
 *
 * @author codexhaq
 */
public class PatientController {
    
    PatientModel patientModel;
    PatientRegister registerView;
    
    public PatientController(PatientRegister registerView){
        patientModel = new PatientModel();
        this.registerView = registerView;
        
    }
    
    public boolean insertPatient(String fullName, String address, String identityId, String birthDate, String email){
        patientModel.setFullName(fullName);
        patientModel.setAddress(address);
        patientModel.setIdentityId(identityId);
        patientModel.setBirthDate(birthDate);
        patientModel.setEmail(email);
        return patientModel.insertPatient();
    }
    
}
