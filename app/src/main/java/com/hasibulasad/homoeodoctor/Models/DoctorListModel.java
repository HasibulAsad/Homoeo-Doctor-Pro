package com.hasibulasad.homoeodoctor.Models;

import android.widget.Button;

public class DoctorListModel {
    int image;
    String name;
    String degree;
    String location;
    String phone;
//    Button button;

    public DoctorListModel(int image, String name, String degree, String location, String phone) {
        this.image = image;
        this.name = name;
        this.degree = degree;
        this.location = location;
        this.phone = phone;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDegree() {
        return degree;
    }

    public void setDegree(String degree) {
        this.degree = degree;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
}
