import alphabeta.mvc.controller.*;
import alphabeta.mvc.view.*;


/**
 * Created by dimz on 9/4/17.
 */
public class Main {

    public static void main(String[] args) {
        demoView view = new demoView();
        view.clearScreen();
        System.out.println("\033[34mLoading...");

        demoController controller = new demoController();
        controller.startSystem(view);


    }

}
