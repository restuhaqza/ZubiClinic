/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;
import model.AdminModel;
import views.LoginPage;

/**
 *
 * @author codexhaq
 */
public class AdminController {
    private AdminModel adminModel;
    private LoginPage loginView;
    
    public AdminController(LoginPage loginView){
        adminModel = new AdminModel();
        this.loginView = loginView;
        
    }
    
    public boolean loginAdmin(String email, String password){
        adminModel.setEmail(email);
        adminModel.setPassword(password);
        return adminModel.loginAdmin();
    }
    
    public static void main(String[] args) {
        
    }

}
