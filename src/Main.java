import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;


/**
 * Created by dimz on 9/4/17.
 */
public class Main extends Application {

/**
    public static void main(String[] args) {
        demoView view = new demoView();
        view.clearScreen();
        System.out.println("\033[34mLoading...");

        demoController controller = new demoController();
        controller.startSystem(view);


    }
*/


    @Override
    public void start(Stage primaryStage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("/alphabeta/mvc/view/main.fxml"));
        Scene scene = new Scene(root, 600, 400);
        primaryStage.setTitle("Course Management System");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

}
