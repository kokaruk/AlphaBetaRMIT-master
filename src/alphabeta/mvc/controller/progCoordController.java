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
import org.mockito.internal.matchers.Null;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Set;

/**
 * Created by Kristin on 19/05/2017.
 */
public class progCoordController {

    private CourseDirectory courseDirectory = CourseDirectory.getInstance();
    private ProgramCoordinator progCoord = new ProgramCoordinator("Bill", "b124", 11);

    @FXML
    private ComboBox<String> prerequisite; // Add New Topics tab
    @FXML
    private ComboBox<String> topic; // Add New Topics tab
    @FXML
    private ListView prereqList; // Add New Topics tab
    @FXML
    private ListView topicList; // Add New Topics tab
    @FXML
    private TextField courseName; // Add New Topics tab
    @FXML
    private ComboBox<String> courseWaiver; // Grant Waiver tab
    @FXML
    private TextField studentID; // Grant Waiver tab
    @FXML
    private TextField loadStudentID; // Increase Loading tab
    @FXML
    private TextField load; // Increase Loading tab
    @FXML
    private ListView courseOfferings; // View Course Offerings tab
    @FXML
    private ListView viewCourses; // View Courses tab


    @FXML
    public void initialize() {
        // populate prereqs drop down im Add New Course tab
        Set<Course> prequisites = courseDirectory.getCourseSet();
        List<String> prereqStrings = new ArrayList<>();
        for (Course c : prequisites) {
            prereqStrings.add(c.getName());
        }
        Collections.sort(prereqStrings);
        ObservableList<String> prereqPrint= FXCollections.observableArrayList(prereqStrings);
        prerequisite.getItems().addAll(prereqPrint);

        // populate topics dropdown in Add New Course tab
        Set<Topic> topics = courseDirectory.getTopicSet();
        List<String> topicStrings = new ArrayList<>();
        for (Topic t : topics) {
            topicStrings.add(t.getNameOfTopic());
        }
        Collections.sort(topicStrings);
        ObservableList<String> topicsPrint = FXCollections.observableArrayList(topicStrings);
        topic.getItems().addAll(topicsPrint);

        // populate course dropdown in grant waivers tab
        courseWaiver.getItems().addAll(prereqPrint);

        //populate Courses in View Courses
        viewCourses.getItems().addAll(prereqStrings);

    }
    public void clickAddPrereq() {
        // add prereqs to list view in Add New Course tab
        prereqList.getItems().add(prerequisite.getValue());
    }
    public void clickAddtopic() {
        // add topics to list view in Add New Course Tab
        topicList.getItems().add(topic.getValue());
    }
    public void createButtonClicked() {
        // create new course button in Add New Course Tab
        if (courseName.getText().isEmpty()) {
            newMessage("Enter a course name");
        }
        else {
            List<String> topics = new ArrayList<>();
            List<String> prereqs = new ArrayList<>();
            prereqs.addAll(prereqList.getItems());
            topics.addAll(topicList.getItems());
            Course newCourse = progCoord.addNewCourse(courseName.getText(), prereqs, topics, courseDirectory.getSemester().getWeek());
            // TODO - add newCourse to the course directory
            newMessage("New course " + courseName.getText() + " created.");
        }
    }
    public void clickWaiverButton() {
        // grant waiver button in Grant Waiver tab
        // TODO - this method throws an exception. Also shows success message no matter what happens
        try {
            progCoord.grantWaivers(studentID.getText(), courseWaiver.getValue());
            newMessage("Waiver granted for student number " + studentID.getText());
        }
        catch (NullPointerException e) {
            newMessage("Student does not exist");
        }


    }

    public void clickSaveLoad() {
        // save new student load for a student in Increase Loading tab
        // TODO - this method throws an exception. Also shows success message no matter what happens
        try {
            progCoord.increaseLoad(loadStudentID.getText(), Integer.parseInt(load.getText()));
            newMessage("New load saved for student " + loadStudentID.getText());
        }
        catch (NullPointerException e) {
            newMessage("Student does not exist");
        }
        catch (NumberFormatException e) {
            newMessage("Please enter a number");
        }

    }

    public void showCourseOfferingsClick() {
        // shows course offerings
        courseOfferings.getItems().clear();
        Set<CourseOffering> courseOffs = courseDirectory.getCourseOfferingSet();
        List<String> courseOffsStrings = new ArrayList<>();
        for (CourseOffering co : courseOffs) {
            courseOffsStrings.add(co.getName()); //+ ": Semester 0" + co.getMySemester().getSemesterNumber() + "  " +co.getMySemester().getYear());
        }
        Collections.sort(courseOffsStrings);
        courseOfferings.getItems().addAll(courseOffsStrings);
    }

    public void refreshClicked() {
        //refresh course list in view courses tab
        viewCourses.getItems().clear();
        Set<Course> prequisites = courseDirectory.getCourseSet();
        List<String> prereqStrings = new ArrayList<>();
        for (Course c : prequisites) {
            prereqStrings.add(c.getName());
        }
        Collections.sort(prereqStrings);
        viewCourses.getItems().addAll(prereqStrings);

    }

    public void newMessage(String message) {
        // call this to create a new pop-up message
        Text text = new Text(50, 50, message);
        StackPane pane = new StackPane();
        pane.setPrefSize(350, 100);
        pane.getChildren().add(text);
        Scene scene = new Scene(pane);
        Stage stage = new Stage();
        stage.setTitle("Message");
        stage.setScene(scene);
        stage.show();
    }





}
