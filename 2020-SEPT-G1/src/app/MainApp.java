package app;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;
import utils.FileUtil;
import view.MainView;

public class MainApp extends Application {
	
	public static Stage window;
	
	public static void main(String[] args) {
		FileUtil.ucitaj("udzbenici-prvitermin.txt");
		launch(args);
	}
	
	@Override
	public void start(Stage primaryStage) throws Exception {
		window = primaryStage;
		window.setScene(new Scene(new MainView(),1350, 800));
		window.show();

	}

}
