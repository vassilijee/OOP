package view;

import controller.NovaIsplataController;
import controller.PregledIsplataController;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import model.Database;
import model.Isplatilac;
import model.Transakcija;
import model.Uplatilac;

public class FirstView extends BorderPane {
    private Label lblStanje = new Label();
    private Label getLblStanjeVrednost = new Label();
    private TableView<Transakcija> tvTransakcije = new TableView<>();
    private Button btnNovaIsplata = new Button();
    private Button btnPregledIsplata = new Button();

    ObservableList<Transakcija> transakcijas = FXCollections.observableArrayList(Database.getInstance().getTransakcije());

    public FirstView() {
        initElements();
        createTable();
        addElements();
        addActions();
    }

    private void initElements() {
        lblStanje.setText("Trenutno stanje: ");
        getLblStanjeVrednost.setText("" + (Uplatilac.zbirSvihUplata() - Isplatilac.zbirSvihIsplata()));
        btnNovaIsplata.setText("Nova isplata");
        btnPregledIsplata.setText("Pregled isplata");
    }

    private void createTable() {
        TableColumn<Transakcija, String> colIznos = new TableColumn<Transakcija, String>("Iznos");
        TableColumn<Transakcija, String> colUplatilacPrimalac = new TableColumn<Transakcija, String>("Uplatilac/Primalac");
        TableColumn<Transakcija, String> colDatum = new TableColumn<Transakcija, String>("Datum");
        TableColumn<Transakcija, String> colTip = new TableColumn<Transakcija, String>("Tip");

        colIznos.setCellValueFactory(new PropertyValueFactory<Transakcija, String>("iznos"));
        colUplatilacPrimalac.setCellValueFactory(new PropertyValueFactory<Transakcija, String>("naziv"));
        colDatum.setCellValueFactory(new PropertyValueFactory<Transakcija, String>("datum"));
        colTip.setCellValueFactory(new PropertyValueFactory<Transakcija, String>("tip"));

        colUplatilacPrimalac.setPrefWidth(200);
        colDatum.setPrefWidth(100);

        tvTransakcije.getColumns().addAll(colIznos, colUplatilacPrimalac, colDatum, colTip);

        tvTransakcije.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);
        getTvTransakcije().getItems().addAll(transakcijas);
    }

    private void addElements() {
        HBox hbTop = new HBox();
        hbTop.getChildren().addAll(lblStanje, getLblStanjeVrednost);
        hbTop.setSpacing(10);
        hbTop.setAlignment(Pos.CENTER);
        hbTop.setPadding(new Insets(5));
        setTop(hbTop);

        setCenter(tvTransakcije);

        HBox hbBottom = new HBox();
        hbBottom.getChildren().addAll(btnNovaIsplata, btnPregledIsplata);
        hbBottom.setSpacing(10);
        hbBottom.setAlignment(Pos.CENTER);
        hbBottom.setAlignment(Pos.CENTER);
        hbBottom.setPadding(new Insets(10));
        setBottom(hbBottom);
    }

    private void addActions() {
        btnNovaIsplata.setOnAction(new NovaIsplataController());
        btnPregledIsplata.setOnAction(new PregledIsplataController(this));
    }

    public ObservableList<Transakcija> getTransakcijas() {
        return transakcijas;
    }

    public void setTransakcijas(ObservableList<Transakcija> transakcijas) {
        this.transakcijas = transakcijas;
    }

    public Label getLblStanje() {
        return lblStanje;
    }

    public void setLblStanje(Label lblStanje) {
        this.lblStanje = lblStanje;
    }

    public Label getGetLblStanjeVrednost() {
        return getLblStanjeVrednost;
    }

    public void setGetLblStanjeVrednost(Label getLblStanjeVrednost) {
        this.getLblStanjeVrednost = getLblStanjeVrednost;
    }

    public TableView<Transakcija> getTvTransakcije() {
        return tvTransakcije;
    }

    public void setTvTransakcije(TableView<Transakcija> tvTransakcije) {
        this.tvTransakcije = tvTransakcije;
    }

    public Button getBtnNovaIsplata() {
        return btnNovaIsplata;
    }

    public void setBtnNovaIsplata(Button btnNovaIsplata) {
        this.btnNovaIsplata = btnNovaIsplata;
    }

    public Button getBtnPregledIsplata() {
        return btnPregledIsplata;
    }

    public void setBtnPregledIsplata(Button btnPregledIsplata) {
        this.btnPregledIsplata = btnPregledIsplata;
    }
}
