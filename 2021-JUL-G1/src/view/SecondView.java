package view;

import controller.PlatiController;
import javafx.collections.FXCollections;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.*;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import model.Database;
import model.Isplatilac;
import model.Transakcija;
import model.Uplatilac;

import java.util.ArrayList;

public class SecondView extends BorderPane {


    private Label lblIznos = new Label();
    private Label lblPrimalac = new Label();
    private Label lblKategorija = new Label();
    private TextField tfIznos = new TextField();
    private TextField tfPrimalac = new TextField();
    private ComboBox<String> cbKategorija = new ComboBox<String>();
    private Button btnPlati = new Button();

    public SecondView() {
        initElements();
        addElements();
        addActions();
    }

    private void initElements() {
        lblIznos.setText("Iznos");
        lblPrimalac.setText("Primalac");
        lblKategorija.setText("Kategorija");
        btnPlati.setText("Plati");

        ArrayList<String> kategorije = new ArrayList<>();
        for (Transakcija t : Database.getInstance().getTransakcije()) {
            if (t instanceof Isplatilac) {
                if (!kategorije.contains(((Isplatilac) t).getKategorija()))
                    kategorije.add(((Isplatilac) t).getKategorija());
            }
        }
        cbKategorija.setItems(FXCollections.observableArrayList(kategorije));
    }

    private void addElements() {
        setPadding(new Insets(40));

        GridPane gp = new GridPane();
        gp.add(lblIznos, 0, 0);
        gp.add(lblPrimalac, 0, 1);
        gp.add(lblKategorija, 0, 2);
        gp.add(btnPlati, 0, 3);

        gp.add(tfIznos, 1, 0);
        gp.add(tfPrimalac, 1, 1);
        gp.add(cbKategorija, 1, 2);
        gp.setVgap(10);
        gp.setHgap(10);
        setCenter(gp);
        gp.setAlignment(Pos.CENTER);

    }

    private void addActions() {
        btnPlati.setOnAction(new PlatiController(this));
    }


    public Label getLblIznos() {
        return lblIznos;
    }

    public void setLblIznos(Label lblIznos) {
        this.lblIznos = lblIznos;
    }

    public Label getLblPrimalac() {
        return lblPrimalac;
    }

    public void setLblPrimalac(Label lblPrimalac) {
        this.lblPrimalac = lblPrimalac;
    }

    public Label getLblKategorija() {
        return lblKategorija;
    }

    public void setLblKategorija(Label lblKategorija) {
        this.lblKategorija = lblKategorija;
    }

    public TextField getTfIznos() {
        return tfIznos;
    }

    public void setTfIznos(TextField tfIznos) {
        this.tfIznos = tfIznos;
    }

    public TextField getTfPrimalac() {
        return tfPrimalac;
    }

    public void setTfPrimalac(TextField tfPrimalac) {
        this.tfPrimalac = tfPrimalac;
    }

    public ComboBox<String> getCbKategorija() {
        return cbKategorija;
    }

    public void setCbKategorija(ComboBox<String> cbKategorija) {
        this.cbKategorija = cbKategorija;
    }

    public Button getBtnPlati() {
        return btnPlati;
    }

    public void setBtnPlati(Button btnPlati) {
        this.btnPlati = btnPlati;
    }
}
