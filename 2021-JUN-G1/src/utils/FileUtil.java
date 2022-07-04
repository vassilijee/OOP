package utils;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import model.Classroom;
import model.Database;
import model.Student;

public class FileUtil {
	
	public static void loadStudents(String fileName) {
		try {
			BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(fileName), "UTF8"));
			
			String line = "";
			while((line = br.readLine()) != null) {
				String[] tokens = line.split(",");
				Student s = new Student(tokens[0], tokens[1], tokens[2], tokens[3], tokens[4]);
				Database.getInstance().addStudent(s);
			}
			
			br.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static void loadClassroom(String fileName) {
		try {
			BufferedReader br = new BufferedReader(new FileReader(fileName));
			
			String line = "";
			while((line = br.readLine()) != null) {
				String name = "";
				String type = "N";
				if (line.contains("-")) {
					String[] tokens = line.split("-");
					name = tokens[0];
					type = tokens[1];
				}
				else {
					name = line;
				}
				
				Classroom c = new Classroom(name, type);
				Database.getInstance().addClassroom(c);
			}
			
			br.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
