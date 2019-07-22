/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.sql.SQLException;
import java.util.ArrayList;
import model.DoctorModel;
import views.doctor.DoctorRegister;
import views.doctor.IntDoctor;

/**
 *
 * @author codexhaq
 */
public class DoctorController {
    DoctorModel doctorModel;
    DoctorRegister doctorRegister;
    IntDoctor mainView;
    
    public DoctorController(DoctorRegister view){
        this.doctorModel = new DoctorModel();
        this.doctorRegister = view;
    }
    
    public DoctorController(IntDoctor view){
        this.doctorModel = new DoctorModel();
        this.mainView = view;
    }
    
    public boolean insertDoctor(String fullName, String numberPhone, String address, String email){
        doctorModel.setFullName(fullName);
        doctorModel.setNumberPhone(numberPhone);
        doctorModel.setAddress(address);
        doctorModel.setEmail(email);    
        return doctorModel.insertDoctor();
    }
    
    public ArrayList<DoctorModel> getAllDoctor() throws SQLException{
        return doctorModel.getAllDoctor();
    }
    
    public DoctorModel getOneDoctor(String id) throws SQLException{
        return doctorModel.getOnePatient(id);
    }
    
    public boolean updateDoctor(int id, String fullName, String numberPhone, String address, String email){
         doctorModel.setId(id);
         doctorModel.setFullName(fullName);
         doctorModel.setNumberPhone(numberPhone);
         doctorModel.setAddress(address);
         doctorModel.setEmail(email);
         
         return doctorModel.updateDoctor();
    }
    
    public boolean deleteDoctor(int id){
        doctorModel.setId(id);
        return doctorModel.deleteDoctor();
    }
}
