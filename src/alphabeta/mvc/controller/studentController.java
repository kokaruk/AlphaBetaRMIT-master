package alphabeta.mvc.controller;


import alphabeta.mvc.model.CourseDirectory;
import alphabeta.mvc.model.CourseOffering;
import alphabeta.mvc.model.Student;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.ListView;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Set;

/**
 * Created by Kristin on 19/05/2017.
 */
public class studentController {

    private CourseDirectory courseDirectory = CourseDirectory.getInstance();
    private Student student = new Student("Dianne", "d333", 13);

    @FXML
    private ComboBox<String> enrolCourseBox; // Enrol tab
    @FXML
    private ListView<String> viewMyResults; // View My Results tab

    @FXML
    public void initialize() {
        //populate enrolCourseBox in Enrol tab with course offerings (all course offerings in system)
        Set<CourseOffering> courseOffs = courseDirectory.getCourseOfferingSet();
        List<String> courseOffsStrings = new ArrayList<>();
        for (CourseOffering co : courseOffs) {
            courseOffsStrings.add(co.getName() + ": Semester 0" + co.getMySemester().getSemesterNumber() + " " + co.getMySemester().getYear());
        }
        Collections.sort(courseOffsStrings);
        enrolCourseBox.getItems().addAll(courseOffsStrings);

        //populate withdrawCourse box on Withdraw tab
        // TODO - unsure how to return the courses a student is currently enrolled in

        //populate the view my results list in the view results tab
        // TODO - should this return a list of strings?
        // TODO - currently throes exception needs test data
        try {
            viewMyResults.getItems().addAll(student.viewMyResults());
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }

    public void enrolClicked() {
        // TODO - this. Unsure how to generate the enrol object to make this work.
    }

    public void withdrawButtonClicked() {
        // TODO - withdraw method in Student not yet built
    }



}
