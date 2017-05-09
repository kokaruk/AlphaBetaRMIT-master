package alphabeta.mvc.view;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;


/**
 * Created by dimz on 9/4/17.
 */
public class demoView {

    private Scanner input = new Scanner(System.in);

	public void outputMainMenu() {
        System.out.println( "Welcome to the Course Management System" + "\r\n" +
                "Select an option:" + "\r\n" +
                "1. View a student's courses and results" + "\r\n" +
                "2. View upcoming course offerings" + "\r\n" +
                "3. Add a course" + "\r\n" +
                "0. Quit"
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
    	System.out.println("Enter course name: ");
    	course = input.nextLine();
    	return course;
    }
    
    public List<String> getPrereq() {
    	List<String> preReq = new ArrayList<String>();
    	System.out.println("Enter number of prerequisites");
    	try {
    		int preReqNum = input.nextInt();
        	for (int i=1; i<=preReqNum; i++) {
        		System.out.println("Enter prerequisite " + i + " course name: ");
        		preReq.add(input.next());
        	}
    	}
    	catch (InputMismatchException e) {
    		System.out.println("Please enter a number.");
    	}
    	return preReq;
    }
    
    public List<String> getTopics() {
    	List<String> topics = new ArrayList<String>();
    	System.out.println("Enter number of topics");
    	try {
    		int topicNum = input.nextInt();
        	for (int i=1; i<=topicNum; i++) {
        		System.out.println("Enter topic " + i + " name: ");
        		topics.add(input.next());
        	}
    	}
    	catch (InputMismatchException e) {
    		System.out.println("Please enter a number.");
    	}
    	return topics;
    }
    	

}
