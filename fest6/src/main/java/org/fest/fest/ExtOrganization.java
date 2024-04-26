package org.fest.fest;

public class ExtOrganization extends Organizer{
    public String name;
    public String contactPerson;
    public String contactPhone;
    public String department;


    public ExtOrganization(String password, String email){
        super(email, password);
    }


    public void ExtOrganization(String mail, String password, String name, String contactPerson, String contactPhone, String department) {
        this.name = name;
        this.contactPerson = contactPerson;
        this.contactPhone = contactPhone;
        this.department = department;
    }
}
