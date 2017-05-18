package alphabeta.mvc.systemDAL;

import alphabeta.mvc.model.CourseException;
import alphabeta.mvc.model.Student;

import java.sql.SQLException;
import java.util.HashSet;
import java.util.Set;

/**
 * @author dimz
 * @since 18/5/17.
 */
public class StudentDAO_fake implements IStudentDAO {
    private Set<Student> userSet = new HashSet<>();
    // singleton instance
    private static IStudentDAO instance;
    // private constructor
    private StudentDAO_fake() {
    }
    // lazy instantiation
    public static IStudentDAO getInstance() {
        if (instance == null) {
            instance = new StudentDAO_fake();
        }
        return instance;
    }
    @Override
    public Set<Student> getStudentSet()throws SQLException {
        return userSet;
    }

    @Override
    public Student getNewStudent(String name, String username) throws SQLException {
        Student student = new Student(name, username, 123);
        userSet.add(student);
        return student;
    }

    @Override
    public Student lookupStudentByID(String s) throws SQLException, NumberFormatException {
        return userSet.stream()
                .filter(usr -> usr.getId().equals(s))
                .findAny()
                .orElseThrow(() -> new CourseException("Student could not be found. Please try again."));
    }


    @Override //Find a Student with a String
    public Student lookupStudentByName(String s) throws SQLException {
        return userSet.stream()
                .filter(usr -> usr.getName().equals(s))
                .findAny()
                .orElseThrow(() -> new CourseException("Student could not be found. Please try again."));
    }

}
