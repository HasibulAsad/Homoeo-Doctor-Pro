package com.hasibulasad.homoeodoctor.Models;

public class SystemModel {
    int number;
    String name;
    String description;

    public SystemModel(int number, String name, String description) {
        this.number = number;
        this.name = name;
        this.description = description;
    }


    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
