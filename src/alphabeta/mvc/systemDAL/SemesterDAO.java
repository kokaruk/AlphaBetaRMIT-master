package alphabeta.mvc.systemDAL;

import alphabeta.mvc.model.Semester;

/**
 * @author dimz
 * @since 18/5/17.
 */
public class SemesterDAO implements ISemesterDAO {

    // singleton instance
    private static ISemesterDAO instance;
    // private constructor
    private SemesterDAO() {
    }
    // lazy instantiation
    public static ISemesterDAO getInstance() {
        if (instance == null) {
            instance = new SemesterDAO();
        }
        return instance;
    }

    @Override
    public Semester getCurrentSemester() {
        return null;
    }

    @Override
    public void incrementWeek() {

    }

    @Override
    public void incrementSemester(int semNUmber, int year) {

    }
}
