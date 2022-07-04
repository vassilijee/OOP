package model;

import java.util.ArrayList;

public class Izdavac {
    private ArrayList<Knjiga> knjige = new ArrayList<>();
    private String naziv;

    public Izdavac(String naziv) {
        this.naziv = naziv;
    }


    public ArrayList<Knjiga> getKnjige() {
        return knjige;
    }

    public void setKnjige(ArrayList<Knjiga> knjige) {
        this.knjige = knjige;
    }

    public String getNaziv() {
        return naziv;
    }

    public void setNaziv(String naziv) {
        this.naziv = naziv;
    }

    public ArrayList<Integer> getRazredi() {
        ArrayList<Integer> razredi = new ArrayList<>();
        for (Knjiga k : knjige) {
            if (!razredi.contains(k.getRazred())) razredi.add(k.getRazred());
        }
        return razredi;
    }

    public int getBrojPrimeraka() {
        int brojPrimeraka = 0;
        for (Knjiga k : knjige) {
            brojPrimeraka += k.getBrojPrimeraka();
        }
        return brojPrimeraka;
    }

    public double getProsecnaCena(){
        double brojJedinstvenihUdzbenika = knjige.size();
        double ukupno = 0;

        for (Knjiga k :
                knjige) {
            ukupno += k.getCena();
        }
        return ukupno/brojJedinstvenihUdzbenika;
    }
}
