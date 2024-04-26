package org.fest.fest;

public class OrganizerFactory extends Organizer{
    String email;
    String password;

    public OrganizerFactory(String email, String password) {
        super(email, password);
    }

    public Organizer getInstance(String str) {
        if(str.equals("Club"))
            return new Club(email, password);

        else if(str.equals("Pesu"))
            return new PesuManagement(email, password);

        else if(str.equals("External"))
            return new ExtOrganization(email, password);

        else
            return null;
    }
}
