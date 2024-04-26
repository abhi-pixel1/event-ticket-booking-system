package org.fest.fest;

import org.fest.fest.Model.ClubRegistrationModel;
import org.fest.fest.Model.PesuRegistrationModel;

public class PesuManagement extends Organizer{
    private PesuRegistrationModel pesuRegistrationModel;
    public String name;
    public String department;
    public String email;
    public String password;

    public PesuManagement(String password, String email){
        super(email, password);
    }

    public void setPesuManagement (String mail, String password, String name,String department){
        this.email = mail;
        this.password = password;
        this.name = name;
        this.department = department;
        pesuRegistrationModel = new PesuRegistrationModel();
    }

    public void register(){
        System.out.println("Registering " + name + " "  + " " + department + " " + email);
        pesuRegistrationModel.saveOrgToDb(email, password, name, department);
    }
}
