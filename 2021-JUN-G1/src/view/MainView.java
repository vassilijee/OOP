package view;

import java.util.ArrayList;
import controller.LoadAction;
import controller.MatchAction;
import controller.RecordAction;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.SelectionMode;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import model.Classroom;
import model.Database;
import model.Student;

public class MainView extends BorderPane {
	private Label lblNumberOfStudents;
	private ObservableList<Student> listStudents;
	private ListView<Student> lvStudents;
	private Button btnMatch;
	private ComboBox<String> cbTerm;
//	private Button btnLoad;
	private ObservableList<Classroom> listClassrooms;
	private ListView<Classroom> lvClassroom;
	private TableView<Student> tvStudents;
	private Button btnRecord;
	
	public MainView() {
		initElements();
		createTable();
		addElements();
		addActions();
	}
	
	private void initElements() {
		lblNumberOfStudents = new Label("Broj nerasporedjenih studenata: " + Database.getInstance().getStudents().size());
		listStudents = FXCollections.observableArrayList(Database.getInstance().getStudents());
		lvStudents = new ListView<Student>();
		lvStudents.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);
		lvStudents.setItems(listStudents);
		btnMatch = new Button("Dodeli");
		cbTerm = new ComboBox<String>();
		ArrayList<String> terms = new ArrayList<String>();
		for(int i = 1; i <= Database.getInstance().getNumberOfTerms(); i++) {
			terms.add("Termin " + (i));
		}
		cbTerm.setItems(FXCollections.observableArrayList(terms));
		cbTerm.getSelectionModel().selectFirst();
//		btnLoad = new Button("Ucitaj za termin");
		listClassrooms = FXCollections.observableArrayList(Database.getInstance().getClassrooms());
		lvClassroom = new ListView<Classroom>();
		lvClassroom.setItems(listClassrooms);
		tvStudents = new TableView<Student>();
		btnRecord = new Button("Snimi");
	}
	
	private void createTable() {
		TableColumn<Student, String> colStudent = new TableColumn<Student, String>("Student");
		TableColumn<Student, String> colTerm = new TableColumn<Student, String>("Termin");
		TableColumn<Student, String> colClassroom = new TableColumn<Student, String>("Ucionica");
		
		colStudent.setCellValueFactory(new PropertyValueFactory<Student, String>("student"));
		colTerm.setCellValueFactory(new PropertyValueFactory<Student, String>("term"));
		colClassroom.setCellValueFactory(new PropertyValueFactory<Student, String>("classroom"));
		
		tvStudents.getColumns().addAll(colStudent, colTerm, colClassroom);
	}
	
	private void addElements() {
		setPadding(new Insets(30));
		
		VBox vbLeft = new VBox();
		vbLeft.getChildren().addAll(lblNumberOfStudents, lvStudents);
		vbLeft.setSpacing(10);
		setLeft(vbLeft);
		vbLeft.setPadding(new Insets(0, 30, 30, 0));
		
		setCenter(btnMatch);
		
		VBox vbRight = new VBox();
		HBox hb = new HBox();
		//hb.getChildren().addAll(cbTerm, btnLoad);
		hb.getChildren().addAll(cbTerm);
		vbRight.getChildren().addAll(hb, lvClassroom);
		hb.setSpacing(10);
		vbRight.setSpacing(10);
		setRight(vbRight);
		vbRight.setPadding(new Insets(0, 0, 30, 30));
		
		VBox vbBottom = new VBox();
		vbBottom.getChildren().addAll(tvStudents, btnRecord);
		vbBottom.setSpacing(10);
		vbBottom.setAlignment(Pos.CENTER);
		setBottom(vbBottom);
	}
	
	private void addActions() {
		//btnLoad.setOnAction(new LoadAction(this));
		btnMatch.setOnAction(new MatchAction(this));
		cbTerm.setOnAction(new LoadAction(this));
		btnRecord.setOnAction(new RecordAction(tvStudents.getItems()));
	}
	
	public ComboBox<String> getCbTerm() {
		return cbTerm;
	}
	
	public ListView<Student> getLvStudents() {
		return lvStudents;
	}
	
	public ListView<Classroom> getLvClassroom() {
		return lvClassroom;
	}
	
	public TableView<Student> getTvStudents() {
		return tvStudents;
	}
	
	public Label getLblNumberOfStudents() {
		return lblNumberOfStudents;
	}
}
