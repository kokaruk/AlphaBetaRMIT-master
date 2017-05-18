package alphabeta.mvc.controller;

import alphabeta.mvc.model.CourseDirectory;
import alphabeta.mvc.model.CourseOffering;
import alphabeta.mvc.model.Lecturer;
import javafx.collections.FXCollections;
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
 * Controller for the view that allows a Admin to select a new lecturer for a course offering.
 */
public class addLecturerController {

    private CourseDirectory courseDirectory = CourseDirectory.getInstance();

    @FXML
    private ComboBox<String> courseName;
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
        Set<CourseOffering> co = courseDirectory.getCourseOfferingSet();
        List<String> courseStrings = new ArrayList<>();
        for (CourseOffering c : co) {
            courseStrings.add(c.getName() + ": Semester 0" + c.getMySemester().getSemesterNumber() + " " + c.getMySemester().getYear());
        }
        ObservableList<String> displayCourseNames = FXCollections.observableArrayList(courseStrings);
        courseName.getItems().addAll(displayCourseNames);
    }

    public void saveButtonClick(ActionEvent event) {

    }

    public void cancelButtonClick(ActionEvent event) {

    }

}
