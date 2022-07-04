package controller;

import app.MainApp;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.ComboBox;
import model.Database;
import model.Isplatilac;
import model.Transakcija;
import view.FirstView;
import view.SecondView;

import java.time.LocalDate;


//350;Pijaca "Gorski vijenac";21.06.2021.;OSTALO
public class PlatiController implements EventHandler<ActionEvent> {

    private SecondView sw;

    public PlatiController(SecondView sw) {
        this.sw = sw;
    }

    @Override
    public void handle(ActionEvent event) {
        String  iznos = sw.getTfIznos().getText();
        String primalac = sw.getTfPrimalac().getText();
        String danasnjiDatum = String.format("%02d", LocalDate.now().getDayOfMonth()) + "." + String.format("%02d", LocalDate.now().getMonthValue()) + "." + LocalDate.now().getYear() + ".";
        String kategorija = sw.getCbKategorija().getSelectionModel().getSelectedItem();

        Integer numIznos = 0;
        try {
            numIznos = Integer.parseInt(iznos);
        }
        catch (NumberFormatException e){
            return;
        }

        Isplatilac isplata = new Isplatilac(numIznos,danasnjiDatum,"ISPLATA",primalac, kategorija);

        Database.getInstance().addIsplata(isplata);


        MainApp.fw.close();
        MainApp.fw.setScene(new Scene(new FirstView(),500,300));
        MainApp.fw.show();
    }
}
