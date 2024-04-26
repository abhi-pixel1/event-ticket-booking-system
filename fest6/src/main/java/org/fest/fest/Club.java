package org.fest.fest;

import org.fest.fest.Model.ClubRegistrationModel;

public class Club extends Organizer {
    private ClubRegistrationModel clubRegistrationModel;
    public String name;
    public String clubName;
    public String department;
    public String faculty;
    public String email;
    public String password;

    public Club(String password, String email){
        super(email, password);
    }

    public void setClub(String password, String email, String name, String clubName, String department, String faculty) {
        this.email = email;
        this.password = password;
        this.name = name;
        this.clubName = clubName;
        this.department = department;
        this.faculty = faculty;
        clubRegistrationModel = new ClubRegistrationModel();
    }

    public void register(){
        System.out.println("Registering " + name + " " + clubName + " " + department + " " + email);
        clubRegistrationModel.saveOrgToDb(email, password, name, clubName, department, faculty);
    }


}
