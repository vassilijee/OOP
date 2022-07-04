package app;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;
import utils.FileUtil;
import view.FirstView;

public class MainApp extends Application {
	
	public static Stage window;
	
	public static void main(String[] args) {
		FileUtil.loadClassroom("ucionice1.txt");
		FileUtil.loadStudents("studenti1.txt");
		launch(args);
	}
	
	@Override
	public void start(Stage primaryStage) throws Exception {
		window = primaryStage;
		window.setScene(new Scene(new FirstView(), 500, 300));
		window.show();
	}

}
