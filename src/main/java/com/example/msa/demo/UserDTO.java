package com.example.msa.demo;

import com.fasterxml.jackson.annotation.JsonIgnore;

public class UserDTO {
    private String name;
    private int id;

    public boolean isAdmin() {
        return isAdmin;
    }

    public void setAdmin(boolean admin) {
        isAdmin = admin;
    }

    private boolean isAdmin;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    private  String fullName;

    private String password;

    @Override
    public boolean equals(Object obj) {
        return name.equals(((UserDTO) obj).getName()) && password.equals(((UserDTO) obj).getPassword());
    }
}
