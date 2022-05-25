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
public class Student extends User{

    private ArrayList<Internship> internships;

    public Student(String username, String password, String mail) {
        super.setUsername(username);
        super.setPassword(password);
        super.setMail(mail);
        super.setType(UserType.Student);
        internships = new ArrayList<>();
    }

    public Student(String username, String password, String mail, String description, String specialization, String group) {
        super.setUsername(username);
        super.setPassword(password);
        super.setMail(mail);
        super.setDescription(description);
        super.setGroup(group);
        super.setSpecialization(specialization);
        super.setType(UserType.Student);
        internships = new ArrayList<>();
    }
    
    public void applyToInternship(Internship i){
        internships.add(i);
        i.addCandidate(this);
    }
    
    @Override
    public void signConvention(Internship i) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
}
