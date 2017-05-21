package alphabeta.mvc.controller;


import alphabeta.mvc.model.*;
import javafx.fxml.FXML;
import javafx.scene.Scene;
import javafx.scene.control.ComboBox;
import javafx.scene.control.ListView;
import javafx.scene.layout.StackPane;
import javafx.scene.text.Text;
import javafx.stage.Stage;

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
            courseOffsStrings.add(co.getName()); // + " Semester 0" + co.getMySemester().getSemesterNumber() + " " + co.getMySemester().getYear());
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

        // set student course load;
        student.setMaxCurrentCourseLoad(100);
    }

    public void enrolClicked() {
        Enrollment enrollment = new Enrollment();
        CourseOffering forEnrol = courseDirectory.lookupCourseOffering(enrolCourseBox.getValue());
        enrollment.setCourseOffering(forEnrol);
        try {
            student.enrol(enrollment);
            newMessage(student.getName() + " now enrolled in " + enrollment.getCourseOffering().getName());
        }
        catch (PrerequisitesNotMetException e) {
            newMessage("Prerequisite not met");
        }
    }

    public void withdrawButtonClicked() {
        // TODO - withdraw method in Student not yet built
    }

    public void newMessage(String message) {
        // call this to create a new pop-up message
        Text text = new Text(50, 50, message);
        StackPane pane = new StackPane();
        pane.setPrefSize(350, 100);
        pane.getChildren().add(text);
        Scene scene = new Scene(pane);
        Stage stage = new Stage();
        stage.setTitle("Enrol");
        stage.setScene(scene);
        stage.show();
    }



}
