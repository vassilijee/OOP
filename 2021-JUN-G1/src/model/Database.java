package model;

import java.util.ArrayList;

public class Database {
	private static Database instance;
	private ArrayList<Classroom> classrooms;
	private ArrayList<Student> students;
	private Integer numberOfTerms;
	private Integer selectedTerm = 0;
	private Boolean computers;

	private Database(){
		classrooms = new ArrayList<Classroom>();
		students = new ArrayList<Student>();
	}

	public static Database getInstance(){
		if(instance == null)
			instance = new Database();
		return instance;
	}



	public void addClassroom(Classroom classroom){
		if(!classrooms.contains(classroom))
			classrooms.add(classroom);
	}

	public void addStudent(Student  student){
		if(!students.contains(student))
			students.add(student);
	}

	public static void setInstance(Database instance) {
		Database.instance = instance;
	}

	public ArrayList<Classroom> getClassrooms() {
		return classrooms;
	}

	public void setClassrooms(ArrayList<Classroom> classrooms) {
		this.classrooms = classrooms;
	}

	public ArrayList<Student> getStudents() {
		return students;
	}

	public void setStudents(ArrayList<Student> students) {
		this.students = students;
	}

	public Integer getNumberOfTerms() {
		return numberOfTerms;
	}

	public void setNumberOfTerms(Integer numberOfTerms) {
		this.numberOfTerms = numberOfTerms;
	}

	public Integer getSelectedTerm() {
		return selectedTerm;
	}

	public void setSelectedTerm(Integer selectedTerm) {
		this.selectedTerm = selectedTerm;
	}

	public Boolean getComputers() {
		return computers;
	}

	public void setComputers(Boolean computers) {
		this.computers = computers;
	}
}
