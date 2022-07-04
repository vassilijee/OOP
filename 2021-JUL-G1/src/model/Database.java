package model;

import javafx.collections.ObservableList;

import java.util.ArrayList;

public class Database {
    private static Database instance;
    private ArrayList<Transakcija> transakcije;

    private Database() {
        transakcije = new ArrayList<Transakcija>();
    }

    public ArrayList<Transakcija> getTransakcije() {
        return transakcije;
    }

    public void addIsplata(Isplatilac i){
        transakcije.add(i);
    }

    public void addUplata(Uplatilac u){
        transakcije.add(u);
    }

    public static Database getInstance() {
        if (instance == null)
            instance = new Database();
        return instance;
    }

    public int getMinVrednost() {
        return minVrednost;
    }


    public void setMinVrednost(int minVrednost) {
        this.minVrednost = minVrednost;
    }

    public int minVrednost = 0;

    public int getMaxVrednost() {
        return maxVrednost;
    }

    public void setMaxVrednost(int maxVrednost) {
        this.maxVrednost = maxVrednost;
    }

    public int maxVrednost = 0;
}
