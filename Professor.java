/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package internships.management.system;

/**
 *
 * @author catal
 */
public class Professor extends User{

    public Professor(String username, String password, String mail) {
        super.setUsername(username);
        super.setPassword(password);
        super.setMail(mail);
        super.setType(UserType.Professor);
    }
    
    @Override
    public void signConvention(Internship i) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
}
