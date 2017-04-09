package alphabeta.mvc.view;

/**
 * Created by dimz on 9/4/17.
 */
public class demoView {

    public void outputMainMenu() {
        System.out.println( "Welcome to the Course Management System" + "\r\n" +
                "Select an option:" + "\r\n" +
                "1. View a student's courses and results" + "\r\n" +
                "2. View upcoming course offerings" + "\r\n" +
                "0. Quit"
        );
    }

    // method to clear terminal screen
    public void clearScreen() {
        final String ANSI_CLS = "\u001b[2J";
        final String ANSI_HOME = "\u001b[H";
        System.out.print(ANSI_CLS + ANSI_HOME);
        System.out.flush();
    }

}
