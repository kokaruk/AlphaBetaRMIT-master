package alphabeta.mvc.systemDAL;

import alphabeta.mvc.model.CourseException;
import alphabeta.mvc.model.Student;

import java.util.Set;

/**
 * @author dimz
 * @since 18/5/17.
 */
public class StudentDAO implements IStudentDAO {
    // singleton instance
    private static IStudentDAO instance;
    // private constructor
    private StudentDAO() {
    }
    // lazy instantiation
    public static IStudentDAO getInstance() {
        if (instance == null) {
            instance = new StudentDAO();
        }
        return instance;
    }

    @Override
    public Set<Student> getStudentSet() {
        return null;
    }

    @Override
    public Student getNewStudent(String name, String username) {
        return null;
    }

    @Override
    public Student lookupStudentByID(String s) throws CourseException {
        return null;
    }

    @Override
    public Student lookupStudentByName(String s) throws CourseException {
        return null;
    }
}
