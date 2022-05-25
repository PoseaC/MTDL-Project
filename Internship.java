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
public class Internship {
    private String description;
    private String name;
    private double salary;
    private Domain domain;
    private Company publisher;
    private ArrayList<Student> candidates;

    public Internship(String name, String description, double salary, Domain domain, Company publisher) {
        this.description = description;
        this.name = name;
        this.salary = salary;
        this.domain = domain;
        this.publisher = publisher;
        candidates = new ArrayList<>();
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public Domain getDomain() {
        return domain;
    }

    public void setDomain(Domain domain) {
        this.domain = domain;
    }

    public ArrayList<Student> getCandidates() {
        return candidates;
    }
    
    public void addCandidate(Student s){
        candidates.add(s);
    }
    
    public void removeCandidate(Student s){
        candidates.remove(s);
    }

    public Company getPublisher() {
        return publisher;
    }

    public void setPublisher(Company publisher) {
        this.publisher = publisher;
    }
}
