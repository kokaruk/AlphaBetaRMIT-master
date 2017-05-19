package alphabeta.mvc.systemDAL;

import alphabeta.mvc.model.Semester;

import java.util.Calendar;
import java.util.Set;

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
        //makeTestSemesters();
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

    /**
    public void makeTestSemesters() {
        Semester semester1 = new Semester(02, 2017, 01);
        Semester semester2 = new Semester(01, 2018, 01);
        Semester semester3 = new Semester(02, 2018, 01);
        semesterSet.add(semester1);
        semesterSet.add(semester2);
        semesterSet.add(semester3);

    }
*/
}
