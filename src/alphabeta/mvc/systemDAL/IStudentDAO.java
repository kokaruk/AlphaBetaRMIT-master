package alphabeta.mvc.systemDAL;

import alphabeta.mvc.model.Student;

import java.sql.SQLException;
import java.util.Set;

/**
 * @author dimz
 * @since 18/5/17.
 */
public interface IStudentDAO {
    Set<Student> getStudentSet() throws SQLException;
    Student getNewStudent(String name, String username) throws SQLException;
    Student lookupStudentByID(String s) throws SQLException, NumberFormatException ;
    Student lookupStudentByName(String s) throws SQLException ;
}
