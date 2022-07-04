package model;

public class Student implements Comparable<Student>{
	private String department;
	private String index;
	private String year;
	private String lastName;
	private String firstName;
	private String term;
	private String classroom;
	
	public Student(String department, String index, String year, String lastName, String firstName) {
		this.department = department;
		this.index = index;
		this.year = year;
		this.lastName = lastName;
		this.firstName = firstName;
	}
	
	@Override
	public String toString() {
		return firstName + " " + lastName + " " + index + "/" + department + "-" + year;
	}
	
	public String getStudent() {
		return toString();
	}
	
	public void setTerm(String term) {
		this.term = term;
	}
	
	public String getTerm() {
		return term;
	}
	
	public String getClassroom() {
		return classroom;
	}
	
	public void setClassroom(String classroom) {
		this.classroom = classroom;
	}

	public String getFirstName() {
		return firstName;
	}
	
	public String getLastName() {
		return lastName;
	}
	
	public String getIndex() {
		return index;
	}
	
	public String getYear() {
		return year;
	}
	
	public String getDepartment() {
		return department;
	}
	
	
	@Override
	public int compareTo(Student s) {
		int compare = term.compareTo(s.term);
		if (compare == 0)
			return classroom.compareTo(s.classroom);
		return compare;
	}
}
