/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package internships.management.system;

import java.util.ArrayList;

/**
 *
 * @author catal
 */
public class Company extends User{
    
    private ArrayList<Internship> internships;

    public Company(String username, String password, String mail) {
        super.setUsername(username);
        super.setPassword(password);
        super.setMail(mail);
        super.setType(UserType.Company);
        internships = new ArrayList<>();
    }

    public Company(String username, String password, String mail, String description) {
        super.setUsername(username);
        super.setPassword(password);
        super.setMail(mail);
        super.setDescription(description);
        super.setType(UserType.Company);
        internships = new ArrayList<>();
    }
    
    public void postInternship(Internship i){
        internships.add(i);
        i.setPublisher(this);
    }

    @Override
    public void signConvention(Internship i) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
}
