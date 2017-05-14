package alphabeta.mvc.controller;

import alphabeta.mvc.model.*;
import alphabeta.mvc.view.demoView;

import java.util.*;


/**
 * Created by dimz on 9/4/17.
 * Last edited by kristin on 14/5/17
 */
public class demoController {

    private static Scanner input = new Scanner(System.in);
    private static demoView view = new demoView();
    //just inventing a coordinator for now
    private static ProgramCoordinator progCoord = new ProgramCoordinator("Bob", "bob123");
    //just inventing an admin for now
    private static Admin admin = new Admin("Mary", "mary123");
    //just inventing a lecturer for now
    private static Lecturer lecturer = new Lecturer("Jane", "jane123");


    

    public void startSystem(demoView view) {

        int option = 0;
        do {
            //Print main menu
            view.outputMainMenu();
            // get user input
            option = getUserIntInput(10);

            switch (option) {
                case 1:
                    //System.out.println("Enter the student's name: ");
                    //String name = input.nextLine().replaceAll(" +", "");
                    createStudent();
                    break;
                case 2:
                    viewCourseOfferings();
                    break;
                case 3:
                    createCourse();
                    break;
                case 4:
                    newCourseLoad();
                    break;
                case 5:
                    addWaiver();
                    break;
                case 6:
                    createCourseOffering();
                    break;
                case 7:
                    changeMaxStudents();
                    break;
                case 8:
                    advanceSystem();
                    break;
                case 9:
                    viewResults();
                    break;
                case 0:
                    System.out.println("Good bye!");
                    System.exit(0);
                    break;
                default:
                    System.out.println("Invalid Option");
            }
        }
        while (option != 0);

    }

    public void createStudent() {
        //Creates a new Student object for the purposes of demonstration
        //needs an edit so that username is unique!
        Student student = new Student(view.getStudentName(), "DemoUsername");
        System.out.println("New student created: " + student.getName() + ", student ID: " + student.getStudentID());
    }

    /**
    public static void printResults(Student student) {
        //Prints hard coded results for a student for the purpose of demonstration
        Semester mySemester = CourseDirectory.getSemester();
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
     */

     
    public static void createCourse() {
    	//hardcode some topics and courses to test
        Topic testTopic1 = new Topic("Agile");
        Topic testTopic2 = new Topic("UML");
        Course testCourse1 = new Course("Programming 1");
        Course testCourse2 = new Course("Database Concepts");
    	
    	try {
    		//get input from view and create the course
    		Course newCourse = progCoord.addNewCourse(view.getCourseName(), view.getPrereq(), view.getTopics(),
                    CourseDirectory.getSemester().getWeek());
    		System.out.println();
    		System.out.println("New course " + newCourse.getName() + " created.");
            //feedback prereqs
            System.out.println();
    		if (newCourse.getPrerequisiteList().size()>0) {
                System.out.print(newCourse.getName() + " prerequisites are: ");
                for (Course c : newCourse.getPrerequisiteList()) {
                    System.out.print(c.getName() +  " ");
                }
                System.out.println();
            }
            //feedback topics
            if (newCourse.getTopics().size()>0) {
                System.out.print(newCourse.getName() + " topics are: ");
    		    for (Topic t : newCourse.getTopics()) {
                    System.out.print(t.getNameOfTopic() + " ");
                }
    		}
    	}
    	catch (CourseException e) {
    		System.out.println(e.getReason());
    	}
    }

    public void newCourseLoad() {
        String studentID = view.getStudentID();
        int courseLoad = view.getNewCourseLoad();
        System.out.println();
        progCoord.increaseLoad(studentID, courseLoad);
    }

    public void addWaiver() {
        Course testCourse1 = new Course("Programming 1");
        progCoord.grantWaivers(view.getStudentID(), view.getCourseName());
    }

    public void createCourseOffering() {
        Course testCourse1 = new Course("Programming 1");
        Semester semester = new Semester(view.getSemesterNumber(), view.getYear(), 1);
        admin.addNewCourseOffering(semester, view.getMaxStudents(),
                view.getLecturer(), view.getCourseName());
    }

    public void changeMaxStudents() {
        admin.setMaxStudents(view.getMaxStudents(), view.getCourseName());
    }

    public void advanceSystem() {
        admin.advanceSystem();
    }

    public void viewResults() {
        String s = view.getStudentID();
        try {
            Student st = CourseDirectory.lookupStudent(s);
            Set<String> results = lecturer.viewAllResults(st);
            System.out.println("Student: " + st.getName());
            results.forEach(System.out::println);
        }
        catch (CourseException e) {
            System.out.println(e.getReason());
        }
    }

    public void viewCourseOfferings() {
        //Prints all course offerings for the current year
        Set<CourseOffering> courseOffering = admin.viewCourseOfferings();
        Course testCourse1 = new Course("Programming 1");
        CourseOffering testOffering = new CourseOffering(CourseDirectory.getSemester(), 50, lecturer,
                testCourse1);
        System.out.println("All courses offerings for year " + CourseDirectory.getSemester().getYear() + " are: ");
        for (CourseOffering co : courseOffering) {
            if ((co.getMySemester().getYear() == CourseDirectory.getSemester().getYear())) {
                System.out.println("Course Name: " + co.getName() + ", Semester: " + co.getMySemester().getSemesterNumber());
            }
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
