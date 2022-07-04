package utils;

import model.Database;
import model.Isplatilac;
import model.Transakcija;
import model.Uplatilac;

import java.io.*;

public class FileUtil {
    public static void ucitajTransakcije(String fileName) {
        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(fileName), "UTF8"));
            String line = "";

            while ((line = br.readLine()) != null) {
                String[] tokens = line.split(";");
                // 30000;Agencija za nekretnine;01.04.2021.;STANOVANJE
                if (fileName.equals("isplate.txt")) {
                    Isplatilac i = new Isplatilac(Integer.parseInt(tokens[0]), tokens[2], "ISPLATA", tokens[1], tokens[3]);
                    Database.getInstance().addIsplata(i);
                    System.out.println(i + " isplata");
                }
                // 3000;Vlada RS;16.04.2021.
                else if (fileName.equals("uplate.txt")) {
                    Uplatilac u = new Uplatilac(Integer.parseInt(tokens[0]),"UPLATA" ,tokens[2], tokens[1]);
                    Database.getInstance().addUplata(u);
                    System.out.println(u + " uplata");
                }

            }


        } catch (UnsupportedEncodingException | FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
