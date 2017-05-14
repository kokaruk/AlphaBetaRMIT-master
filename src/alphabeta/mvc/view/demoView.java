package alphabeta.mvc.view;

import alphabeta.mvc.model.CourseDirectory;
import alphabeta.mvc.model.CourseOffering;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;
import java.util.Set;


/**
 * Created by dimz on 9/4/17.
 * last edit by Kristin 14/5/17.
 */
public class demoView {

    private Scanner input = new Scanner(System.in);

	public void outputMainMenu() {
        System.out.println();
		System.out.println( "Welcome to the Course Management System" + "\r\n" +
                "Select an option:" + "\r\n" +
                "1. Create a new Student" + "\r\n" +
                "2. View upcoming course offerings" + "\r\n" +
                "3. Add a course" + "\r\n" +
				"4. Change a student's course load" + "\r\n" +
				"5. Add a waiver for a student" + "\r\n" +
				"6. Create a course offering" + "\r\n" +
				"7. Change maximum number of students in a course offering" + "\r\n" +
				"8. Advance the semester" + "\r\n" +
				"9. View a student's results" + "\r\n" +
                "10. Quit"
        );
    }

    // method to clear terminal screen
    public void clearScreen() {
        final String ANSI_CLS = "\u001b[2J";
        final String ANSI_HOME = "\u001b[H";
        System.out.print(ANSI_CLS + ANSI_HOME);
        System.out.flush();
    }
    
    public String getCourseName() {
    	String course;
    	System.out.print("Enter course name: ");
    	course = input.nextLine();
    	return course;
    }

	public String getStudentName() {
		String student;
		System.out.print("Enter student name: ");
		student = input.nextLine();
		return student;
	}
    
    public List<String> getPrereq() {
    	List<String> preReq = new ArrayList<String>();
    	System.out.print("How many prerequisites? ");
    	try {
    		int preReqNum = input.nextInt();
    		input.nextLine();
        	for (int i=1; i<=preReqNum; i++) {
        		System.out.print("Enter prerequisite " + i + " course name: ");
        		preReq.add(input.nextLine());
        	}
    	}
    	catch (InputMismatchException e) {
    		System.out.println("Please enter an integer number.");
    	}
    	return preReq;
    }
    
    public List<String> getTopics() {
    	List<String> topics = new ArrayList<String>();
    	System.out.print("How many topics? ");
    	try {
    		int topicNum = input.nextInt();
    		input.nextLine();
    		for (int i=1; i<=topicNum; i++) {
        		System.out.print("Enter topic " + i + " name: ");
        		topics.add(input.nextLine());
        	}
    	}
    	catch (InputMismatchException e) {
    		System.out.println("Please enter a number.");
    	}
    	return topics;
    }

    public String getStudentID() {
		System.out.println();
		System.out.print("Enter student number: ");
		String studentID = input.nextLine();
		return studentID;
	}

	public int getNewCourseLoad() {
		System.out.println();
		System.out.print("Enter new course load: ");
		int courseLoad = input.nextInt();
		input.nextLine();
		return courseLoad;
	}

	public int getMaxStudents() {
		System.out.println();
		System.out.println("Enter maximum number of students: " );
		int maxStudents = input.nextInt();
		input.nextLine();
		return maxStudents;
	}

	public String getLecturer() {
		System.out.println();
		System.out.println("Enter Lecturer's name: ");
		String lecturer = input.nextLine();
		return lecturer;
	}


	public int getSemesterNumber() {
		System.out.println();
		System.out.print("Enter semester number: ");
		int semesterNumber = input.nextInt();
		input.nextLine();
		return semesterNumber;
	}

	public int getYear() {
		System.out.println();
		System.out.print("Enter year: ");
		int year = input.nextInt();
		input.nextLine();
		return year;
	}

}
