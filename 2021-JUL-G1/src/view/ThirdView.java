package view;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import model.Database;

public class ThirdView extends BorderPane {
    private Label lblMinimalnaIsplata = new Label();
    private Label lblMaksimalnaIsplata = new Label();
    private Label lblMinimalnaIsplataVrednost = new Label();
    private Label lblMaksimalnaIsplataVrednost = new Label();
    private ListView<String> listView = new ListView<>();
    private Button btnClose = new Button();

    public ThirdView() {
        initElements();
        addElements();
        addActions();
    }

    private void initElements() {
        lblMinimalnaIsplata.setText("Minimalna isplata");
        lblMaksimalnaIsplata.setText("Minimalna isplata");
        lblMinimalnaIsplataVrednost.setText(Database.getInstance().getMinVrednost()+"");
        lblMaksimalnaIsplataVrednost.setText(Database.getInstance().getMaxVrednost()+"");
        btnClose.setText("Zatvori");
    }

    private void addElements() {
        HBox hb1 = new HBox();
        hb1.getChildren().addAll(lblMinimalnaIsplata, lblMaksimalnaIsplataVrednost);
        hb1.setAlignment(Pos.BASELINE_LEFT);
        hb1.setPadding(new Insets(10));
        hb1.setSpacing(10);

        HBox hb2 = new HBox();
        hb2.getChildren().addAll(lblMaksimalnaIsplata, lblMaksimalnaIsplataVrednost);
        hb2.setAlignment(Pos.BASELINE_LEFT);
        hb2.setPadding(new Insets(10));
        hb2.setSpacing(10);

        VBox vb3 = new VBox();
        vb3.getChildren().addAll(hb1, hb2);

        setTop(vb3);

        setCenter(listView);

        setBottom(btnClose);
    }

    public Label getLblMinimalnaIsplata() {
        return lblMinimalnaIsplata;
    }

    public void setLblMinimalnaIsplata(Label lblMinimalnaIsplata) {
        this.lblMinimalnaIsplata = lblMinimalnaIsplata;
    }

    public Label getLblMaksimalnaIsplata() {
        return lblMaksimalnaIsplata;
    }

    public void setLblMaksimalnaIsplata(Label lblMaksimalnaIsplata) {
        this.lblMaksimalnaIsplata = lblMaksimalnaIsplata;
    }

    public Label getLblMinimalnaIsplataVrednost() {
        return lblMinimalnaIsplataVrednost;
    }

    public void setLblMinimalnaIsplataVrednost(Label lblMinimalnaIsplataVrednost) {
        this.lblMinimalnaIsplataVrednost = lblMinimalnaIsplataVrednost;
    }

    public Label getLblMaksimalnaIsplataVrednost() {
        return lblMaksimalnaIsplataVrednost;
    }

    public void setLblMaksimalnaIsplataVrednost(Label lblMaksimalnaIsplataVrednost) {
        this.lblMaksimalnaIsplataVrednost = lblMaksimalnaIsplataVrednost;
    }

    public ListView<String> getListView() {
        return listView;
    }

    public void setListView(ListView<String> listView) {
        this.listView = listView;
    }

    public Button getBtnClose() {
        return btnClose;
    }

    public void setBtnClose(Button btnClose) {
        this.btnClose = btnClose;
    }

    private void addActions() {
    }
}
