package org.fest.fest;

import java.util.List;

abstract class User {
    protected String email;
    protected String password;

    // Constructor
    public User(String email, String password) {
        this.email = email;
        this.password = password;
    }

    // Abstract method for login
    public abstract List<String> login();
}