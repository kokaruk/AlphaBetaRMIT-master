package alphabeta.mvc.controller;

import alphabeta.mvc.model.*;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.Scene;
import javafx.scene.control.ComboBox;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.layout.StackPane;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Set;

/**
 * Created by Kristin on 19/05/2017.
 */
public class adminController {

    private CourseDirectory courseDirectory = CourseDirectory.getInstance();
    private Admin admin = new Admin("Bob", "b123", 10);

    @FXML
    private ComboBox<String> courseName;
    @FXML
    private ComboBox<String> lecturer;
    @FXML
    private TextField maxStudents;
    @FXML
    private TextField studentID;
    @FXML
    private ListView resultsList;
    @FXML
    private ListView courseOfferingsList;
    @FXML
    private TextField currentWeek;
    @FXML
    private TextField currentSemester;

    @FXML
    public void initialize() {
        // used to prepopulate fields and drop downs

        //create course offering tab
        Set<Course> co = courseDirectory.getCourseSet();
        Set<Lecturer> le = courseDirectory.getLecturerSet();
        List<String> courseStrings = new ArrayList<>();
        List<String> lecturerStrings = new ArrayList<>();
        for (Course c : co) {
            courseStrings.add(c.getName());
        }
        Collections.sort(courseStrings);
        ObservableList<String> displayCourseNames = FXCollections.observableArrayList(courseStrings);
        courseName.getItems().addAll(displayCourseNames);
        for (Lecturer l : le) {
            lecturerStrings.add(l.getName());
        }
        Collections.sort(lecturerStrings);
        ObservableList<String> displayLecturerNames = FXCollections.observableArrayList(lecturerStrings);
        lecturer.getItems().addAll(displayLecturerNames);

        //advance semester tab
        currentWeek.setText("0" + courseDirectory.getSemester().getWeek());
        currentSemester.setText("0" + courseDirectory.getSemester().getSemesterNumber() + " " + courseDirectory.getSemester().getYear());

    }

    public void saveButtonClick()  {
        // on button click allows an admin to save a new course offering
        // TODO - need to be able to select a semester in the future
        admin.addNewCourseOffering(courseDirectory.getSemester(), Integer.parseInt(maxStudents.getText()), lecturer.getValue(), courseName.getValue());
        System.out.println("success");
        newMessage("New course offering for " + courseName.getValue() + " created");
    }

    public void getResultsButtonClick() {
        // on button click shows a student's results when their student id is entered
        // TODO - this throws an exception when run
        resultsList.getItems().clear();
        try {
            Student student = courseDirectory.lookupStudentByID(studentID.getText());
            Set<String> results = admin.viewAllResults(student);
            resultsList.getItems().addAll(results);
        }
        catch (SQLException e) {
            System.out.println("SQL Exception derp");
        }
    }

    public void showCourseOfferingsButtonClick() {
        // on button click shows all course offerings in the directory
        courseOfferingsList.getItems().clear();
        Set<CourseOffering> courseOffs = courseDirectory.getCourseOfferingSet();
        List<String> courseOffsStrings = new ArrayList<>();
        for (CourseOffering co : courseOffs) {
            courseOffsStrings.add(co.getName() + ": Semester 0" + co.getMySemester().getSemesterNumber() + " " +co.getMySemester().getYear());
        }
        Collections.sort(courseOffsStrings);
        courseOfferingsList.getItems().addAll(courseOffsStrings);
    }

    public void advanceButtonClick() {
        // on button click allows an admin to advance the semester
        //TODO - increment week doesn't work, it needs to increment the semester when week>12
        courseDirectory.incrementWeek();
        currentWeek.setText("0" + courseDirectory.getSemester().getWeek());
        currentSemester.setText("0" + courseDirectory.getSemester().getSemesterNumber() + " " + courseDirectory.getSemester().getYear());
    }


    public void newMessage(String message) {
        // call this to create a new pop-up message
        Text text = new Text(50, 50, message);
        StackPane pane = new StackPane();
        pane.setPrefSize(350, 100);
        pane.getChildren().add(text);
        Scene scene = new Scene(pane);
        Stage stage = new Stage();
        stage.setTitle("Success!");
        stage.setScene(scene);
        stage.show();
    }

}
