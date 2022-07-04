package model;

import java.util.ArrayList;

public class Classroom {
	private String name;
	private String type;
	private ArrayList<Integer> leftSeats;
	
	
	public Classroom(String name, String type) {
		this.name = name;
		this.type = type;
		leftSeats = new ArrayList<Integer>();
	}
	
	public String getName() {
		return name;
	}
	
	public String getType() {
		return type;
	}
	
	public ArrayList<Integer> getLeftSeats() {
		return leftSeats;
	}
	
	@Override
	public String toString() {
		if (type.equals("R"))
			return name + "(" + type + ") - " + leftSeats.get(Database.getInstance().getSelectedTerm());
		return name + " - " + leftSeats.get(Database.getInstance().getSelectedTerm());

	}
}
