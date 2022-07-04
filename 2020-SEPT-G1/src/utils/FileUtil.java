package utils;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import model.Database;
import model.Izdavac;
import model.Knjiga;

import java.io.*;
import java.util.ArrayList;

public class FileUtil {
    public static void ucitaj(String filename) {
        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(filename), "UTF8"));
            String line = "";

//            public Knjiga(
//            int id,
//            int razred,
//            String izdavac,
//            String predmet,
//            String naslov,
//            ArrayList<String> autori,
//            int brojPrimeraka,
//            double cena )

            // 0         1           2       3        4                                    5                                 6      7
            // 18, Matematika 3, 3. razred, KLETT, MATEMATIKA, Branislav Popović,Mirjana Kandić,Nenad Vulović,Petar Anokić, 443.0, 171
            while ((line = br.readLine()) != null) {
                String[] tokens = line.split(",");
                Izdavac i = new Izdavac(tokens[3]);
                if (!Database.getInstance().getIzdavacs().contains(i)) Database.getInstance().getIzdavacs().add(i);
                else {
                    for (Izdavac izdavacIzServera : Database.getInstance().getIzdavacs()) {
                        i = izdavacIzServera;
                    }
                }
                int razred = tokens[2].charAt(0) - '0';
                Knjiga k = new Knjiga(Integer.parseInt(tokens[0]), tokens[2].charAt(0) - '0', i.getNaziv(), tokens[4], tokens[1], Integer.parseInt(tokens[tokens.length - 1]), Double.parseDouble(tokens[tokens.length - 2]));
                for (int j = 5; j < tokens.length - 2; j++) {
                    k.getAutori().add(tokens[j]);
                }
                i.getKnjige().add(k);
                System.out.println(k);
                Database.getInstance().getKnjige().add(k);
            }
            br.close();
            System.out.println(Database.getInstance().getKnjige().size());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static ObservableList<String> generateRazrede(){
        ArrayList<String> razredi = new ArrayList<String>();
        razredi.add("Svi razredi");
        for (Knjiga k :
                Database.getInstance().getKnjige()) {
            String razred = k.getRazred() + ".";
            if(!razredi.contains(razred))
                razredi.add(razred);
        }
        return FXCollections.observableArrayList(razredi);
    }
}
