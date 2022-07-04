package controller;

import app.MainApp;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.stage.Stage;
import view.SecondView;

public class NovaIsplataController implements EventHandler<ActionEvent> {

    @Override
    public void handle(ActionEvent event) {
        MainApp.sw = new Stage();
        MainApp.sw.setScene(new Scene(new SecondView()));
        MainApp.sw.show();
    }
}
