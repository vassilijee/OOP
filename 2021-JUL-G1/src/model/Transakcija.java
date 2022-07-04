package model;

public abstract class Transakcija {
    private int iznos;
    private String datum;
    private String tip;

    public Transakcija(int iznos, String datum, String tip) {
        this.iznos = iznos;
        this.datum = datum;
        this.tip = tip;
    }

    @Override
    public String toString() {
        return "Transakcija{" +
                "iznos=" + iznos +
                ", datum='" + datum + '\'' +
                ", tip='" + tip + '\'' +
                '}';
    }

    public int getIznos() {
        return iznos;
    }

    public void setIznos(int iznos) {
        this.iznos = iznos;
    }

    public String getDatum() {
        return datum;
    }

    public void setDatum(String datum) {
        this.datum = datum;
    }
}
