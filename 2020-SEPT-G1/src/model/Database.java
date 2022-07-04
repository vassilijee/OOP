package model;

import java.util.ArrayList;

public class Database {
    private static Database instance;
    private ArrayList<Knjiga> knjige;
    private ArrayList<Izdavac> izdavacs;

    private ArrayList<Knjiga> izabranaKnjiga = new ArrayList<>();

    public static void setInstance(Database instance) {
        Database.instance = instance;
    }

    public ArrayList<Knjiga> getIzabranaKnjiga() {
        return izabranaKnjiga;
    }

    public void setIzabranaKnjiga(ArrayList<Knjiga> izabranaKnjiga) {
        this.izabranaKnjiga = izabranaKnjiga;
    }

    private Database() {
        knjige = new ArrayList<>();
        izdavacs = new ArrayList<>();
    }

    public static Database getInstance() {
        if (instance == null)
            instance = new Database();
        return instance;
    }

    public ArrayList<Knjiga> getKnjige() {
        return knjige;
    }

    public void setKnjige(ArrayList<Knjiga> knjige) {
        this.knjige = knjige;
    }

    public ArrayList<Izdavac> getIzdavacs() {
        return izdavacs;
    }

    public void setIzdavacs(ArrayList<Izdavac> izdavacs) {
        this.izdavacs = izdavacs;
    }
}
