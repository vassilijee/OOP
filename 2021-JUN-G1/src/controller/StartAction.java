package controller;

import java.util.ArrayList;
import java.util.List;

import app.MainApp;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.stage.Stage;
import model.Classroom;
import model.Database;
import view.FirstView;
import view.MainView;

public class StartAction implements EventHandler<ActionEvent>{
	private FirstView view;
	
	public StartAction(FirstView view) {
		this.view = view;
	}
	
	@Override
	public void handle(ActionEvent event) {
		String strNumberOfTerms = view.getTfTerm().getText();
		String strNumberOfStudents = view.getTfNumerOfStudents().getText();
		
		Integer numberOfTerms = 0;
		Integer numberOfStudents = 0;
		try {
			numberOfTerms = Integer.parseInt(strNumberOfTerms);
			numberOfStudents = Integer.parseInt(strNumberOfStudents);
		} catch(NumberFormatException e) {
			view.getLblMessage().setText("Pogesan format broja");
			return;
		}
		
		Boolean computers = view.getCbComputers().isSelected();
		
		Integer numberOfSeats = 0;
		if (computers) {
			for(Classroom classroom : Database.getInstance().getClassrooms()) {
				if (!classroom.getType().equals("R"))
					continue;
				numberOfSeats += numberOfStudents;
			}
		} else {
			for(Classroom classroom : Database.getInstance().getClassrooms()) {
				if (classroom.getType().equals("A"))
					numberOfSeats += numberOfStudents*2;
				else
					numberOfSeats += numberOfStudents;
			}
		}
		
		System.out.println("Broj slobodnih mesta: " + numberOfSeats);
		
		if (Database.getInstance().getStudents().size() > numberOfSeats * numberOfTerms) {
			view.getLblMessage().setText("Nije moguca raspodela");
			return;
		}
		
		Database.getInstance().setNumberOfTerms(numberOfTerms);
		Database.getInstance().setComputers(computers);
		for(Classroom classroom : Database.getInstance().getClassrooms()) {
			for (int i = 0; i < numberOfTerms; i++)
				if (classroom.getType().equals("A"))
					classroom.getLeftSeats().add(numberOfStudents*2);
				else
					classroom.getLeftSeats().add(numberOfStudents);
		}
		
		if (computers) {
			List<Classroom> classrooms = new ArrayList<>();
			for(Classroom classroom : Database.getInstance().getClassrooms()) {
				if (classroom.getType().equals("R"))
					classrooms.add(classroom);
			}
			
			Database.getInstance().getClassrooms().clear();
			Database.getInstance().getClassrooms().addAll(classrooms);
		}
		
		MainApp.window.close();
		MainApp.window = new Stage();
		MainApp.window.setScene(new Scene(new MainView(), 700, 800));
		MainApp.window.show();
	}

}
