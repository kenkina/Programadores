package com.example.kenkina.pc2programadores.models;

import java.io.Serializable;
import java.util.HashMap;
import java.util.List;

public class Developer implements Serializable {

    private String email, password, uid, bio;
    private HashMap<String, Ability> abilities;

    public Developer() {
    }

    public Developer(String email, String password, String uid, String bio, HashMap<String, Ability> abilities) {
        this.email = email;
        this.password = password;
        this.uid = uid;
        this.bio = bio;
        this.abilities = abilities;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }

    public String getBio() {
        return bio;
    }

    public void setBio(String bio) {
        this.bio = bio;
    }

    public HashMap<String, Ability> getAbilities() {
        return abilities;
    }

    public void setAbilities(HashMap<String, Ability> abilities) {
        this.abilities = abilities;
    }
}
