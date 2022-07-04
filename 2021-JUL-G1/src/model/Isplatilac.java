package model;

public class Isplatilac extends Transakcija {
    private String primalac;
    private String kategorija;

    public Isplatilac(int iznos, String datum,String tip, String primalac, String kategorija) {
        super(iznos, datum, tip);
        this.primalac = primalac;
        this.kategorija = kategorija;
    }

    public static int zbirSvihIsplata() {
        int zbir = 0;
        for (Transakcija t : Database.getInstance().getTransakcije()) {
            if (t instanceof Isplatilac) zbir += t.getIznos();
        }
        return zbir;
    }

    public String getNaziv(){
        return primalac;
    }

    @Override
    public String toString() {
        return "Isplatilac{" +
                "primalac='" + primalac + '\'' +
                ", kategorija='" + kategorija + '\'' +
                '}';
    }



    public String getPrimalac() {
        return primalac;
    }

    public void setPrimalac(String primalac) {
        this.primalac = primalac;
    }

    public String getKategorija() {
        return kategorija;
    }

    public void setKategorija(String kategorija) {
        this.kategorija = kategorija;
    }

    public String getTip() {
        return "ISPLATA";
    }

}
