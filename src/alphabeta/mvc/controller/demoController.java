package alphabeta.mvc.controller;

import alphabeta.mvc.model.*;
import alphabeta.mvc.view.demoView;

import java.util.*;


/**
 * Created by dimz on 9/4/17.
 * Last edited by kristin on 10/5/17
 */
public class demoController {

    static Scanner input = new Scanner(System.in);
    static Semester semester = new Semester();
    //static Set<Course> courses = new HashSet<>();
    static demoView view = new demoView();
    //just inventing a coordinator for now
    static ProgramCoordinator progCoord = new ProgramCoordinator("Bob", "bob123");
    static CourseDirectory courseDirectory = new CourseDirectory();
    
    //static Course testCourse = new Course(SEF, )
  
    

    public void startSystem(demoView view) {

        // view.clearScreen();
        //Print main menu
        view.outputMainMenu();

        //hard code Semester;
        semester.setSemesterNumber(1);
        semester.setWeek(1);
        semester.setYear(17);
        
        // get user input
        
        int option = getUserIntInput(3);
        switch (option) {
            case 1:
                System.out.println("Enter the student's name: ");
                String name = input.nextLine().replaceAll(" +", "");
                createStudent(name);
                break;
            case 2:
                System.out.println("Not yet developed!");
                break;
            case 3:
            	createCourse();
            	break;
            case 0:
                System.out.println("Good bye!");
                System.exit(0);
                break;
            default:
                System.out.println("Invalid Option");
        }
    }

    public static void createStudent(String studentName) {
        //Creates a new Student object for the purposes of demonstration
        Student student = new Student(studentName, "DemoUsername");
        printResults(student);
    }

    public static void printResults(Student student) {
        //Prints hard coded results for a student for the purpose of demonstration
        Semester mySemester = new Semester();
        mySemester.semesterNumber = 1;
        mySemester.year = 2017;
        mySemester.week = 1;
        Staff myLecturer = new Lecturer("Test Name", "testname2");
        List<Topic> myTopics = new ArrayList<>();
        myTopics.add( new Topic("Topic Name"));
        Course myCourse = new Course();
        myCourse.name = "Test Course";
        myCourse.topics = myTopics;
        CourseOffering courseOffering = new CourseOffering(mySemester, 28, (Lecturer)myLecturer, myCourse);
        Enrollment enrollment = new Enrollment();
        enrollment.result = Result.hd;
        enrollment.courseOffering = courseOffering;
        Set<Enrollment> enrolList = new HashSet<>();
        enrolList.add(enrollment);
        student.setEnrollment(enrolList);
        Set<String> results = myLecturer.viewAllResults(student);
        System.out.println("Student: " + student.getName());
        results.forEach(System.out::println);
    }

     
     
    public static void createCourse() {
    	//hardcode some topics and courses to test
        Topic testTopic1 = new Topic("Agile");
        Topic testTopic2 = new Topic("UML");
        Course testCourse1 = new Course("Programming 1");
        Course testCourse2 = new Course("Database Concepts");
    	
    	try {
    		//get input from view and create the course
    		Course newCourse = progCoord.addNewCourse(view.getCourseName(), view.getPrereq(), view.getTopics(), semester.getWeek());
    		System.out.println("New course " + newCourse.getName() + " created.");
            //feedback prereqs
            System.out.println();
    		if (newCourse.getPrerequisiteList().size()>0) {
                System.out.print(newCourse.getName() + " prerequisites are: ");
                for (Course c : newCourse.getPrerequisiteList()) {
                    System.out.print(c.getName() +  " ,");
                }
            }
            //feedback topics
            if (newCourse.getTopics().size()>0) {
                System.out.print(newCourse.getName() + " topics are: ");
    		    for (Topic t : newCourse.getTopics()) {
                    System.out.print(t.getNameOfTopic() + ", ");
                }
    		}
    	}
    	catch (CourseException e) {
    		System.out.println(e.getReason());
    	}
    	
    }
    

    int getUserIntInput(int maxInputInt) {
        System.out.println("");
        System.out.println("");
        System.out.print("\033[32mMake a choice: "); //green
        String menuSelectionString = input.nextLine().replaceAll(" +", "");

        int menuSelection;

        try {
            menuSelection = Integer.parseInt(menuSelectionString);
        } catch (NumberFormatException e) {
            System.out.println("\033[31mInvalid input format.\r\nNumbers Only."); //red
            return getUserIntInput(maxInputInt);
        }
        if (menuSelection > maxInputInt) {
            System.out.println("\033[31mNo such option."); //red
            return getUserIntInput(maxInputInt);
        } else {
            return menuSelection;
        }
    }


}
