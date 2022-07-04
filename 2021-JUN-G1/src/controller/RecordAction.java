package controller;

import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;

import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import model.Student;

public class RecordAction implements EventHandler<ActionEvent> {
	
	private ObservableList<Student> students;
	
	public RecordAction(ObservableList<Student> students) {
		this.students = students;
	}
	
	@Override
	public void handle(ActionEvent event) {
		try {
			PrintWriter writer = new PrintWriter("rasporedjeni1.txt", "UTF8");
			
			students.sort(null);
			for (Student student : students) {
				writer.write(student.getDepartment() + " " + student.getIndex() + "/" + student.getYear() +
							" " + student.getFirstName() + " " + student.getLastName() + " " + student.getClassroom() + " " + student.getTerm() + "\n");
			}
			
			writer.close();
		} catch (FileNotFoundException | UnsupportedEncodingException e) {
			e.printStackTrace();
		}
	}

}
