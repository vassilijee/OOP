package app;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;
import model.Database;
import utils.FileUtil;
import view.FirstView;

public class MainApp extends Application {

    public static Stage fw;
    public static Stage sw;
    public static Stage tw;
    public static void main(String[] args) {
        //Ucitavanje ->
        FileUtil.ucitajTransakcije("uplate.txt");
        FileUtil.ucitajTransakcije("isplate.txt");

        launch(args);
    }


    @Override
    public void start(Stage primaryStage) throws Exception {
        fw = primaryStage;
        fw.setScene(new Scene(new FirstView(),500,300));
        fw.show();
    }
}
