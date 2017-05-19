package alphabeta.mvc.controller;

import com.sun.deploy.util.FXLoader;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

import java.io.IOException;

/**
 * Created by Kristin on 19/05/2017.
 */
public class mainController {

    public void loadStudent() {
        loadWindow("/alphabeta/mvc/view/student.fxml", "Student View");
    }
    public void loadLecturer() {
        loadWindow("/alphabeta/mvc/view/lecturer.fxml", "Lecturer View");

    }
    public void loadAdmin() {
        loadWindow("/alphabeta/mvc/view/admin.fxml", "Admin View");

    }
    public void loadProgCoord() {
        loadWindow("/alphabeta/mvc/view/progCoord.fxml", "Program Coordinator View");

    }

    public void loadWindow (String loc, String title) {
        try {
            Parent parent = FXMLLoader.load(getClass().getResource(loc));
            Stage stage = new Stage();
            stage.setTitle(title);
            stage.setScene(new Scene(parent));
            stage.show();
        }
        catch (IOException e) {
            System.out.println(e.getMessage());
        }

    }
}
