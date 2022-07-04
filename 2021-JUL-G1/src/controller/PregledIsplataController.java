package controller;

import app.MainApp;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.stage.Stage;
import model.Database;
import model.Isplatilac;
import model.Transakcija;
import view.FirstView;
import view.SecondView;
import view.ThirdView;

import java.util.ArrayList;

public class PregledIsplataController implements EventHandler<ActionEvent> {
    private FirstView fw;
    private ThirdView tw;

    public  int minIsplata(ObservableList<Transakcija> transakcije) {
        int min = Integer.MAX_VALUE;
        for (Transakcija transakcija : transakcije) {
            if (transakcija instanceof Isplatilac) {
                int iznos = ((Isplatilac) transakcija).getIznos();
                if (iznos < min) min = iznos;
            }
        }
        return min;
    }

    public int maxIsplata(ObservableList<Transakcija> transakcije) {
        int max = Integer.MIN_VALUE;
        for (Transakcija transakcija : transakcije) {
            if (transakcija instanceof Isplatilac) {
                int iznos = ((Isplatilac) transakcija).getIznos();
                if (iznos > max) max = iznos;
            }
        }
        return max;
    }

    public PregledIsplataController(FirstView fw) {
        this.fw = fw;
    }

    @Override
    public void handle(ActionEvent event) {


        ArrayList<Transakcija> selectovane = new ArrayList<>();
        selectovane.addAll(fw.getTvTransakcije().getSelectionModel().getSelectedItems());

        if (selectovane.size() == 0) return;

        int min = minIsplata(FXCollections.observableArrayList(selectovane));
        int max = maxIsplata(FXCollections.observableArrayList(selectovane));

        System.out.println(min+ " " + max);

        Database.getInstance().setMinVrednost(min);
        Database.getInstance().setMaxVrednost(max);

        MainApp.tw = new Stage();
        MainApp.tw.setScene(new Scene(new ThirdView()));
        MainApp.tw.show();
    }
}
