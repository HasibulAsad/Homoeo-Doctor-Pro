package com.hasibulasad.homoeodoctor.Models;

/**
 * Created by NgocTri on 11/7/2015.
 */
public class Product {
    String medicineName;
    String gosol;
    String gham;
    String khabar;
    String pipasa;
    String paikhana;
    String prosab;
    String manosikota;
    String srab;
    String boisisto;


    public Product(String medicineName, String gosol, String gham, String khabar, String pipasa, String paikhana, String prosab, String manosikota, String srab, String boisisto) {
        this.medicineName = medicineName;
        this.gosol = gosol;
        this.gham = gham;
        this.khabar = khabar;
        this.pipasa = pipasa;
        this.paikhana = paikhana;
        this.prosab = prosab;
        this.manosikota = manosikota;
        this.srab = srab;
        this.boisisto = boisisto;
    }

    public String getMedicineName() {
        return medicineName;
    }

    public void setMedicineName(String medicineName) {
        this.medicineName = medicineName;
    }

    public String getGosol() {
        return gosol;
    }

    public void setGosol(String gosol) {
        this.gosol = gosol;
    }

    public String getGham() {
        return gham;
    }

    public void setGham(String gham) {
        this.gham = gham;
    }

    public String getKhabar() {
        return khabar;
    }

    public void setKhabar(String khabar) {
        this.khabar = khabar;
    }

    public String getPipasa() {
        return pipasa;
    }

    public void setPipasa(String pipasa) {
        this.pipasa = pipasa;
    }

    public String getPaikhana() {
        return paikhana;
    }

    public void setPaikhana(String paikhana) {
        this.paikhana = paikhana;
    }

    public String getProsab() {
        return prosab;
    }

    public void setProsab(String prosab) {
        this.prosab = prosab;
    }

    public String getManosikota() {
        return manosikota;
    }

    public void setManosikota(String manosikota) {
        this.manosikota = manosikota;
    }

    public String getSrab() {
        return srab;
    }

    public void setSrab(String srab) {
        this.srab = srab;
    }

    public String getBoisisto() {
        return boisisto;
    }

    public void setBoisisto(String boisisto) {
        this.boisisto = boisisto;
    }
}
