package com.example.kenkina.pc2programadores.models;

public class Ability {

    private String name, level;

    public Ability() {
    }

    public Ability(String name, String level) {
        this.name = name;
        this.level = level;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = level;
    }
}
