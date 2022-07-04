package view;

import controller.StartAction;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;

public class FirstView extends BorderPane {
    private TextField tfTerm;
    private TextField tfNumerOfStudents;
    private CheckBox cbComputers;
    private Button btnStart;
    private Label lblMessage;

    public FirstView() {
        initElements();
        addElements();
        addActions();
    }

    private void initElements() {
        tfTerm = new TextField();
        tfNumerOfStudents = new TextField();
        cbComputers = new CheckBox();
        cbComputers.setText("samo ucionice sa racunarima");
        btnStart = new Button("Pokreni");
        lblMessage = new Label("Poruka");
    }

    private void addElements() {
        setPadding(new Insets(40));

        setTop(new Label("Unesite potrebne podatke za raspodelu"));
        setAlignment(getTop(), Pos.CENTER);

        GridPane gp = new GridPane();
        gp.add(new Label("Broj termina"), 0, 0);
        gp.add(new Label("Broj studenata po ucionici"), 0, 1);
        gp.add(tfTerm, 1, 0);
        gp.add(tfNumerOfStudents, 1, 1);
        gp.setVgap(10);
        gp.setHgap(10);
        setCenter(gp);
        gp.setAlignment(Pos.CENTER);

        VBox vbBottom = new VBox();
        vbBottom.getChildren().addAll(cbComputers, btnStart, lblMessage);
        vbBottom.setAlignment(Pos.CENTER);
        vbBottom.setSpacing(10);
        setBottom(vbBottom);
    }

    private void addActions() {
        btnStart.setOnAction(new StartAction(this));
    }

    public TextField getTfTerm() {
        return tfTerm;
    }

    public TextField getTfNumerOfStudents() {
        return tfNumerOfStudents;
    }

    public CheckBox getCbComputers() {
        return cbComputers;
    }

    public Label getLblMessage() {
        return lblMessage;
    }

}
