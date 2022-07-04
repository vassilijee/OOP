package controller;

import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import model.Classroom;
import model.Database;
import model.Student;
import view.MainView;

public class MatchAction implements EventHandler<ActionEvent>{

	private MainView view;
	
	public MatchAction(MainView view) {
		this.view = view;
	}
	
	@Override
	public void handle(ActionEvent event) {
		ObservableList<Student> students = view.getLvStudents().getSelectionModel().getSelectedItems();
		Classroom classroom = view.getLvClassroom().getSelectionModel().getSelectedItem();
		Integer selectedTerm = Database.getInstance().getSelectedTerm();
		
		if (students.size() > classroom.getLeftSeats().get(selectedTerm))
			return;
		
		classroom.getLeftSeats().set(selectedTerm, classroom.getLeftSeats().get(selectedTerm)-students.size());
		view.getLvClassroom().refresh();
		
		for(Student s : students) {
			s.setClassroom(classroom.getName());
			s.setTerm("termin" + (Database.getInstance().getSelectedTerm() + 1));
		}
		
		view.getTvStudents().getItems().addAll(students);
		view.getLvStudents().getItems().removeAll(students);
		view.getLblNumberOfStudents().setText("Broj nerasporedjenih studenata: " + view.getLvStudents().getItems().size());
	}

}
