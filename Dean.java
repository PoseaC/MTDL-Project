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
public class Dean extends User{

    private ArrayList<User> users;

    public Dean(String username, String password, String mail) {
        super.setUsername(username);
        super.setPassword(password);
        super.setMail(mail);
        super.setType(UserType.Dean);
        users = new ArrayList<>();
    }

    public ArrayList<User> getUsers() {
        return users;
    }
    
    public void createAccount(String username, String password, String mail, UserType type){
        switch(type){
            case Dean:
                users.add(new Dean(username, password, mail));
                break;
            case Company:
                users.add(new Company(username, password, mail));
                break;
            case Student:
                users.add(new Student(username, password, mail));
                break;
            case Professor:
                users.add(new Professor(username, password, mail));
                break;
            default:
                break;
        }
    }
    
    @Override
    public void signConvention(Internship i) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
}
