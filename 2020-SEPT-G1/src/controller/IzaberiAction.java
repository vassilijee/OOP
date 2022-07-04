package controller;

import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableView;
import model.Izdavac;
import model.Knjiga;

import java.util.ArrayList;

public class IzaberiAction implements EventHandler<ActionEvent> {

    private final TableView<Izdavac> tvIzdavaci;
    private final TableView<Knjiga> tvUdzbenici;
    private final ComboBox<String> cbRazred;

    public IzaberiAction(TableView<Izdavac> tvIzdavaci, TableView<Knjiga> tvUdzbenici, ComboBox<String> cbRazred) {
        this.tvIzdavaci = tvIzdavaci;
        this.tvUdzbenici = tvUdzbenici;
        this.cbRazred = cbRazred;
    }

    @Override
    public void handle(ActionEvent event) {
        ArrayList<Knjiga> output = new ArrayList<>();
        Izdavac izdavac = tvIzdavaci.getSelectionModel().getSelectedItem();

        if (izdavac == null) return;

        int razred;

        if (cbRazred.getValue().equals("Svi razredi")) razred = 0;
        else razred = cbRazred.getValue().charAt(0) - '0';

        if (razred == 0) {
            for (Knjiga udzbenik : izdavac.getKnjige()) {
                output.add(udzbenik);
            }
        } else {
            for (Knjiga udzbenik : izdavac.getKnjige()) {
                if (udzbenik.getRazred() == razred) output.add(udzbenik);
            }
        }
        tvUdzbenici.setItems(FXCollections.observableArrayList(output));
        tvUdzbenici.refresh();
    }
}
