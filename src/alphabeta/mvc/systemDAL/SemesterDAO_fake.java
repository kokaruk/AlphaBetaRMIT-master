package alphabeta.mvc.systemDAL;

import alphabeta.mvc.model.Semester;

import java.util.Calendar;

/**
 * @author dimz
 * @since 18/5/17.
 */
public class SemesterDAO_fake implements ISemesterDAO {

    private Semester currentSemester;

    // singleton instance
    private static ISemesterDAO instance;
    // private constructor
    private SemesterDAO_fake() {
    }
    // lazy instantiation
    public static ISemesterDAO getInstance() {
        if (instance == null) {
            instance = new SemesterDAO_fake();
        }
        return instance;
    }



    @Override
    public Semester getCurrentSemester() {
        if(currentSemester == null){
            Calendar now = Calendar.getInstance();
            int year = now.get(Calendar.YEAR);
            currentSemester = new Semester(01, year, 1);
        }
        return currentSemester;
    }

    @Override
    public void incrementWeek() {
        currentSemester.incrementWeek();
    }

    @Override
    public void incrementSemester(int semNUmber, int year) {
        currentSemester = new Semester(semNUmber, year, 1);
    }
}
