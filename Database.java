/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package internships.management.system;
import java.sql.*;

/**
 *
 * @author catal
 */
public class Database {
    public static final Database instance = new Database();
    Connection conn;
    
    private Database(){
        try {
            conn = DriverManager.getConnection(
                  "jdbc:mysql://localhost:3306/internships_management_system",
                  "root", "Posea");
        }
        catch(SQLException ex) {
            ex.printStackTrace();
        }  
    }
    
    public void insertUser(User u) throws Exception{
        Statement stmt = conn.createStatement();
      
        String strAdd = "insert into users (name, pass, user_type, mail) values('" + u.getUsername() + "','"
                + u.getPassword() + "','" + u.getType().toString() + "','" + u.getMail() + "')";
         
        stmt.executeUpdate(strAdd);
    }
    
    public void insertInternship(Internship i) throws Exception{
        Statement stmt = conn.createStatement();
        
        String strSelect = "select id from users where name='" + i.getPublisher().getUsername() + "'";
        ResultSet companyID = stmt.executeQuery(strSelect);
        companyID.next();
      
        String strAdd = "insert into internships (name, salary, description, domain, publisher_id) values('" + i.getName() + "','"
                + i.getSalary() + "','" + i.getDescription() + "','" + i.getDomain().toString() 
                + "'," + companyID.getInt("id") + ")";
         
        stmt.executeUpdate(strAdd);
    }
    
    public ResultSet getInternshipCandidates(int id) throws Exception{
        Statement stmt = conn.createStatement();
      
        String strSelect = "select * from users inner join internship_applications on "
                + "internship_applications.student_id = users.id where internship_applications.internship_id = " + id;
         
        return stmt.executeQuery(strSelect);
    }
    
    public ResultSet checkUser(String username) throws Exception{
        Statement stmt = conn.createStatement();
      
        String strSelect = "select * from users where name='" + username + "'";
         
        return stmt.executeQuery(strSelect);
    }
    
    public ResultSet getUsers() throws Exception{
        Statement stmt = conn.createStatement();
      
        String strSelect = "select * from users";
         
        return stmt.executeQuery(strSelect);
    }
    
    public ResultSet getInternshipPublisher(int publisherID) throws Exception{
        Statement stmt = conn.createStatement();
      
        String strSelect = "select * from users where id=" + publisherID;
         
        return stmt.executeQuery(strSelect);
    }
    
    public ResultSet getInternshipsByCompany(String username) throws Exception{
        Statement stmt = conn.createStatement();
      
        String strSelect = "select * from internships where publisher_id=(select id from users where name='" + username + "')";
         
        return stmt.executeQuery(strSelect);
    }
    
    public ResultSet getInternshipsByStudent(String username) throws Exception{
        Statement stmt = conn.createStatement();
      
        String student = "select id from users where name='" + username + "'";
        ResultSet studentID = stmt.executeQuery(student);
        studentID.next();
        
        String strSelect = "select * from internships inner join internship_applications on internship_applications.internship_id = internships.id "
                + "where internship_applications.student_id = " + studentID.getInt("id");
         
        return stmt.executeQuery(strSelect);
    }
    
    public ResultSet getInternshipsByName(String name) throws Exception{
        Statement stmt = conn.createStatement();
      
        String strSelect = "select * from internships where name like '%" + name + "%'";
         
        return stmt.executeQuery(strSelect);
    }
    
    public void deleteUser(String username) throws Exception{
        Statement stmt = conn.createStatement();
      
        String strDelete = "delete from users where name = '" + username +"'";
         
        stmt.executeUpdate(strDelete);
    }
    
    public void addApplication(String username, int internshipID) throws Exception{
        Statement stmt = conn.createStatement();
      
        String strSelect = "select id from users where name='" + username + "'";
        ResultSet studentID = stmt.executeQuery(strSelect);
        studentID.next();
        
        String strAdd = "insert into internship_applications (student_id, internship_id) values(" + studentID.getInt("id") + "," + internshipID + ")";
         
        stmt.executeUpdate(strAdd);
    }
    
    public ResultSet checkApplication(String username, int internshipID) throws Exception{
        Statement stmt = conn.createStatement();
      
        String strSelect = "select * from internship_applications where student_id = (select id from users where name = '" + username + "')"
                + "and internship_id = " + internshipID;
         
        return stmt.executeQuery(strSelect);
    }
    
    public void updateUser(int userID, User u) throws Exception{
        Statement stmt = conn.createStatement();
        
        switch(u.getType()){
            case Student:
                String studentUpdate = "update users set users.name = '" + u.getUsername() + "', users.mail = '" + u.getMail()
                        + "', users.specialization = '" + u.getSpecialization() + "', users.group = '" + u.getGroup()
                        + "', users.description = '" + u.getDescription() + "' where id = " + userID;
                stmt.executeUpdate(studentUpdate);
                break;
            case Company:
                String companyUpdate = "update users set name = '" + u.getUsername() + "', mail = '" + u.getMail()
                        + "', description = '" + u.getDescription() + "' where id = " + userID;
                stmt.executeUpdate(companyUpdate);
                break;
            default:
                System.out.println(u.getUsername() + " shouldn't be able to edit his profile");
                break;
        }
    }
    
    public ResultSet recoverPassword(String username, String mail) throws Exception{
        Statement stmt = conn.createStatement();
      
        String strSelect = "select * from users where name = '" + username + "' and mail ='" + mail + "'";
         
        return stmt.executeQuery(strSelect);
    }
}
