package controller;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import model.Database;
import view.MainView;

public class LoadAction implements EventHandler<ActionEvent>{

	private MainView view;
	
	public LoadAction(MainView view) {
		this.view = view;
	}
	
	@Override
	public void handle(ActionEvent event) {
		Integer prevSelectedTerm = Database.getInstance().getSelectedTerm();
		String selectedTermString = view.getCbTerm().getSelectionModel().getSelectedItem();
		Integer selectedTerm = Integer.parseInt(selectedTermString.substring(selectedTermString.length()-1))-1;
		
		if (prevSelectedTerm == selectedTerm)
			return;
		
		Database.getInstance().setSelectedTerm(selectedTerm);
		view.getLvClassroom().refresh();
	}

}
