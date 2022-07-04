package model;

import java.util.ArrayList;

public class Knjiga {
    private int id;
    private int razred;
    private String izdavac;
    private String predmet;
    private String naslov;
    private ArrayList<String> autori = new ArrayList<>();
    private int brojPrimeraka;
    private double cena;

    public Knjiga(int id, int razred, String izdavac, String predmet, String naslov , int brojPrimeraka, double cena) {
        this.id = id;
        this.razred = razred;
        this.izdavac = izdavac;
        this.predmet = predmet;
        this.naslov = naslov;
        this.brojPrimeraka = brojPrimeraka;
        this.cena = cena;
    }

    @Override
    public String toString() {
        return "Knjiga{" +
                "id=" + id +
                ", razred=" + razred +
                ", izdavac='" + izdavac + '\'' +
                ", predmet='" + predmet + '\'' +
                ", naslov='" + naslov + '\'' +
                ", autori=" + autori +
                ", brojPrimeraka=" + brojPrimeraka +
                ", cena=" + cena +
                '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getRazred() {
        return razred;
    }

    public void setRazred(int razred) {
        this.razred = razred;
    }

    public String getIzdavac() {
        return izdavac;
    }

    public void setIzdavac(String izdavac) {
        this.izdavac = izdavac;
    }

    public String getPredmet() {
        return predmet;
    }

    public void setPredmet(String predmet) {
        this.predmet = predmet;
    }

    public String getNaslov() {
        return naslov;
    }

    public void setNaslov(String naslov) {
        this.naslov = naslov;
    }

    public ArrayList<String> getAutori() {
        return autori;
    }

    public void setAutori(ArrayList<String> autori) {
        this.autori = autori;
    }

    public int getBrojPrimeraka() {
        return brojPrimeraka;
    }

    public void setBrojPrimeraka(int brojPrimeraka) {
        this.brojPrimeraka = brojPrimeraka;
    }

    public double getCena() {
        return cena;
    }

    public void setCena(double cena) {
        this.cena = cena;
    }
}
