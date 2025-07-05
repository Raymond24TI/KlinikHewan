package com.mycompany.klinik_hewan.model;

public abstract class AbstractUser {
    protected int id;
    protected String username;
    protected String password;
    protected String role;

    public AbstractUser(int id, String username, String password, String role) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.role = role;
    }

    public abstract String getInfo();

    public int getId() {
        return id;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public String getRole() {
        return role;
    }
}
