package alphabeta.mvc.systemDAL;

import alphabeta.mvc.model.CourseException;
import alphabeta.mvc.model.Student;

import java.util.Set;

/**
 * @author dimz
 * @since 18/5/17.
 */
public interface IStudentDAO {
    Set<Student> getStudentSet();
    Student getNewStudent(String name, String username);
    Student lookupStudentByID(String s) throws CourseException;
    Student lookupStudentByName(String s) throws CourseException;
}
