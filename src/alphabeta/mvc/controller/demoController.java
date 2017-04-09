package alphabeta.mvc.controller;

import alphabeta.mvc.model.*;
import alphabeta.mvc.view.demoView;

import java.util.*;


/**
 * Created by dimz on 9/4/17.
 */
public class demoController {

    static Scanner input = new Scanner(System.in);

    public void startSystem(demoView view) {

        // view.clearScreen();
        //Print main menu
        view.outputMainMenu();

        // get user input

        int option = getUserIntInput(2);
        switch (option) {
            case 1:
                System.out.println("Enter the student's name: ");
                String name = input.nextLine().replaceAll(" +", "");
                createStudent(name);
                break;
            case 2:
                System.out.println("Not yet developed!");
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
        Staff lecturer = new Lecturer("Test Name", "testname2");
        List<String> testList = new ArrayList<>();
        testList.add("Course: Test Course, Result: High Distinction");
        CourseOffering courseOffering = new CourseOffering();
        courseOffering.setName("Test Course");
        Enrollment enrollment = new Enrollment();
        enrollment.result = Result.hd;
        enrollment.courseOffering = courseOffering;
        Set<Enrollment> enrolList = new HashSet<>();
        enrolList.add(enrollment);
        student.setEnrollment(enrolList);
        Set<String> results = lecturer.viewAllResults(student);
        System.out.println("Student: " + student.getName());
        results.forEach(System.out::println);
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
