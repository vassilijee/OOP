package model;

public class Uplatilac extends Transakcija {

    private String uplatilac;

    public String getUplatilac() {
        return uplatilac;
    }

    public String getTip() {

        return "UPLATA";

    }

    public String getNaziv(){
        return uplatilac;
    }

    @Override
    public String toString() {
        return "Uplatilac{" +
                "uplatilac='" + uplatilac + '\'' +
                '}';
    }

    public static int zbirSvihUplata() {
        int zbir = 0;

        for (Transakcija t : Database.getInstance().getTransakcije()) {
            if (t instanceof Uplatilac) zbir += t.getIznos();
        }
        return zbir;
    }

    public void setUplatilac(String uplatilac) {
        this.uplatilac = uplatilac;
    }

    public Uplatilac(int iznos, String tip, String datum, String uplatilac) {
        super(iznos, datum, tip);
        this.uplatilac = uplatilac;
    }


}
