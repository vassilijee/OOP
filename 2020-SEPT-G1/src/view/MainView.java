package view;

import controller.IzaberiAction;
import controller.IzvrsiAction;
import controller.SnimiAction;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import model.Database;
import model.Izdavac;
import model.Knjiga;
import utils.FileUtil;

public class MainView extends BorderPane {
    private TableView<Izdavac> tvIzdavaci = new TableView<Izdavac>();
    private ComboBox<String> cbRazred = new ComboBox<String>();
    private Button btnIzaberi = new Button();
    private TableView<Knjiga> tvKnjige = new TableView<Knjiga>();
    private ComboBox<String> cbDodajIzbaci = new ComboBox<String>();
    private TextField tfKolicina = new TextField();
    private Button btnIzvrsi = new Button();
    private Button btnSnimi = new Button();

    //ObservableList<Knjiga> knjigas = FXCollections.observableArrayList(Database.get
    //    ObservableList<Knjiga> knjigas = FXCollections.observableArrayList(Database.get)


    public MainView() {
        initElements();
        createTable1();
        createTable2();
        addElements();
        addActions();
    }

    private void initElements() {
        cbRazred.setItems(FileUtil.generateRazrede());
        btnIzaberi.setText("Izaberi");
        //cbdodajizbaci
        btnIzvrsi.setText("Izbrsi");
        btnSnimi.setText("Snimi");
    }

    private void createTable1() {
        TableColumn<Izdavac, String> colIzdavac = new TableColumn<>("Izdavac");
        TableColumn<Izdavac, String> colRazredi = new TableColumn<>("Razredi");
        TableColumn<Izdavac, String> colBrojPrimeraka = new TableColumn<>("Broj primeraka");
        TableColumn<Izdavac, String> colProsecnaCena = new TableColumn<>("Prosecna cena");

        colIzdavac.setCellValueFactory(new PropertyValueFactory<>("naziv"));
        colRazredi.setCellValueFactory(new PropertyValueFactory<>("razredi"));
        colBrojPrimeraka.setCellValueFactory(new PropertyValueFactory<>("brojPrimeraka"));
        colProsecnaCena.setCellValueFactory(new PropertyValueFactory<>("prosecnaCena"));

        tvIzdavaci.setMaxWidth(450);

        tvIzdavaci.getColumns().addAll(colIzdavac, colRazredi, colBrojPrimeraka, colProsecnaCena);

        tvIzdavaci.getItems().addAll(Database.getInstance().getIzdavacs());
    }

    private void createTable2() {
        TableColumn<Knjiga, String> colID = new TableColumn<>("ID");
        TableColumn<Knjiga, String> colRazred = new TableColumn<>("Razred");
        TableColumn<Knjiga, String> colIzdavac = new TableColumn<>("Izdavac");
        TableColumn<Knjiga, String> colPredmet = new TableColumn<>("Predmet");
        TableColumn<Knjiga, String> colNaslov = new TableColumn<>("Naslov");
        TableColumn<Knjiga, String> colAutori = new TableColumn<>("Autori");
        TableColumn<Knjiga, String> colBrojPrimeraka = new TableColumn<>("Broj primeraka");
        TableColumn<Knjiga, String> colCena = new TableColumn<>("Cena");

        colID.setCellValueFactory(new PropertyValueFactory<Knjiga, String>("id"));
        colRazred.setCellValueFactory(new PropertyValueFactory<>("razred"));
        colIzdavac.setCellValueFactory(new PropertyValueFactory<>("izdavac"));
        colPredmet.setCellValueFactory(new PropertyValueFactory<>("predmet"));
        colNaslov.setCellValueFactory(new PropertyValueFactory<>("naslov"));
        colAutori.setCellValueFactory(new PropertyValueFactory<>("autori"));
        colBrojPrimeraka.setCellValueFactory(new PropertyValueFactory<>("brojPrimeraka"));
        colCena.setCellValueFactory(new PropertyValueFactory<>("cena"));

        tvKnjige.getColumns().addAll(colID, colRazred, colIzdavac, colPredmet, colNaslov, colAutori, colBrojPrimeraka, colCena);

        tvKnjige.getItems().addAll(Database.getInstance().getIzabranaKnjiga());

    }

    private void addElements() {
        VBox vboxMain = new VBox();

        HBox hBox1 = new HBox();
        hBox1.getChildren().addAll(cbDodajIzbaci, tfKolicina, btnIzvrsi, btnSnimi);
        hBox1.setSpacing(10);
        hBox1.setPadding(new Insets(5));

        vboxMain.getChildren().addAll(tvIzdavaci, cbRazred, btnIzaberi, tvKnjige, hBox1);
        vboxMain.setSpacing(5);
        vboxMain.setAlignment(Pos.CENTER);

        setCenter(vboxMain);
    }

    private void addActions() {
        //btnIzvrsi.setOnAction(new IzvrsiAction(this));
        btnIzaberi.setOnAction(new IzaberiAction(tvIzdavaci, tvKnjige, cbRazred));
        //btnSnimi.setOnAction(new SnimiAction());
    }


    public TableView<Izdavac> getTvIzdavaci() {
        return tvIzdavaci;
    }

    public void setTvIzdavaci(TableView<Izdavac> tvIzdavaci) {
        this.tvIzdavaci = tvIzdavaci;
    }

    public ComboBox<String> getCbRazred() {
        return cbRazred;
    }

    public void setCbRazred(ComboBox<String> cbRazred) {
        this.cbRazred = cbRazred;
    }

    public Button getBtnIzaberi() {
        return btnIzaberi;
    }

    public void setBtnIzaberi(Button btnIzaberi) {
        this.btnIzaberi = btnIzaberi;
    }

    public TableView<Knjiga> getTvKnjige() {
        return tvKnjige;
    }

    public void setTvKnjige(TableView<Knjiga> tvKnjige) {
        this.tvKnjige = tvKnjige;
    }

    public ComboBox<String> getCbDodajIzbaci() {
        return cbDodajIzbaci;
    }

    public void setCbDodajIzbaci(ComboBox<String> cbDodajIzbaci) {
        this.cbDodajIzbaci = cbDodajIzbaci;
    }

    public TextField getTfKolicina() {
        return tfKolicina;
    }

    public void setTfKolicina(TextField tfKolicina) {
        this.tfKolicina = tfKolicina;
    }

    public Button getBtnIzvrsi() {
        return btnIzvrsi;
    }

    public void setBtnIzvrsi(Button btnIzvrsi) {
        this.btnIzvrsi = btnIzvrsi;
    }

    public Button getBtnSnimi() {
        return btnSnimi;
    }

    public void setBtnSnimi(Button btnSnimi) {
        this.btnSnimi = btnSnimi;
    }
}
