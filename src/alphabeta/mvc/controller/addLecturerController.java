package alphabeta.mvc.controller;

import alphabeta.mvc.model.CourseDirectory;
import alphabeta.mvc.model.CourseOffering;
import alphabeta.mvc.model.Lecturer;
import alphabeta.mvc.model.Semester;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.event.ActionEvent;
import javafx.scene.control.ComboBox;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;


/**
 * Created by Kristin on 18/05/2017.
 */
public class addLecturerController {

    private CourseDirectory courseDirectory = CourseDirectory.getInstance();

    @FXML
    private ComboBox<String> courseName;
    @FXML
    private ComboBox<Semester> semesterNumber;
    @FXML
    private ComboBox<Lecturer> lecturer;
    @FXML
    private Button saveButton;
    @FXML
    private Button cancelButton;

    @FXML
    public void initialize() {
        // create strings of all course names, semesters and lecturers from the course offerings directory
        // and display in the drop downs
        courseDirectory.getCourseOfferingSet();



    }

    public void saveButtonClick(ActionEvent event) {

    }

    public void cancelButtonClick(ActionEvent event) {

    }

    public void displayCourseOfferings(){
        CourseDirectory.getInstance().getSemester();
    }
}
