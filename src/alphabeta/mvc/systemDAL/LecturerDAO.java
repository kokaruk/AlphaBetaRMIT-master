package alphabeta.mvc.systemDAL;

import alphabeta.mvc.model.CourseException;
import alphabeta.mvc.model.Lecturer;

import java.util.Set;

/**
 * @author dimz
 * @since 18/5/17.
 */
public class LecturerDAO implements ILecturerDAO {

    // singleton instance
    private static ILecturerDAO instance;
    // private constructor
    private LecturerDAO() {
    }
    // lazy instantiation
    public static ILecturerDAO getInstance() {
        if (instance == null) {
            instance = new LecturerDAO();
        }
        return instance;
    }

    @Override
    public Set<Lecturer> getLecturerSet() {
        return null;
    }

    @Override
    public Lecturer getNewLecturer(String name, String username) {
        return null;
    }

    @Override
    public Lecturer lookupLectByID(String s) throws CourseException {
        return null;
    }

    @Override
    public Lecturer lookupLectByName(String s) throws CourseException {
        return null;
    }
}
