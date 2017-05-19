package alphabeta.mvc.controller;

import alphabeta.mvc.model.Course;
import alphabeta.mvc.model.CourseDirectory;
import alphabeta.mvc.model.Lecturer;
import alphabeta.mvc.model.Result;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Kristin on 19/05/2017.
 */
public class lecturerController {

    private CourseDirectory courseDirectory = CourseDirectory.getInstance();
    private Lecturer lecturer = new Lecturer("Kate", "k125", 12);

    @FXML
    private TextField uploadStudentID; // Upload Results tab
    @FXML
    private ComboBox<String> uploadCourse; // Upload Results tab
    @FXML
    private ComboBox<String> uploadResult; // Upload Results tab
    @FXML
    private TextField viewStudentID; // View Results tab
    @FXML
    private ListView<String> resultsList; // View Results tab

    @FXML
    public void initialize() {

        // Populate course field in Upload Course Tab
        List<String> courseList = new ArrayList<>();
        for (Course c : courseDirectory.getCourseSet()) {
            courseList.add(c.getName());
        }
        uploadCourse.getItems().addAll(courseList);

        //Populate view results field in Upload Results tab
        uploadResult.getItems().addAll("High Distinction", "Distinction", "Pass", "Fail");
    }

    public void saveResultClick() {
        // Save a student's results in the Upload Results tab
        // TODO - this method throws an exception
        try {
            lecturer.upLoadResults(courseDirectory.lookupStudentByID(uploadStudentID.getText()), Result.valueOf(uploadResult.getValue()), courseDirectory.lookupCourse(uploadCourse.getValue()));
        }
        catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public void showResultsClick() {
        //Show a student's results for all course offerings by inputting student ID in View Results tab
        // TODO - this method throws an exception
       resultsList.getItems().clear();
        try {
            resultsList.getItems().addAll(lecturer.viewAllResults(courseDirectory.lookupStudentByID(viewStudentID.getText())));
        }
        catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }


}
