package alphabeta.mvc.systemDAL;

import alphabeta.mvc.model.CourseException;
import alphabeta.mvc.model.Lecturer;

import java.util.Set;

/**
 * @author dimz
 * @since 18/5/17.
 */
public interface ILecturerDAO {
    Set<Lecturer> getLecturerSet();
    Lecturer getNewLecturer(String name, String username);
    Lecturer lookupLectByID(String s) throws CourseException;
    Lecturer lookupLectByName(String s) throws CourseException;
}
