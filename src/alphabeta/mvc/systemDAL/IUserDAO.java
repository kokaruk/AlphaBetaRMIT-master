package alphabeta.mvc.systemDAL;

import alphabeta.mvc.model.CourseException;
import alphabeta.mvc.model.Lecturer;
import alphabeta.mvc.model.User;

import java.util.Set;

/**
 * @author dimz
 * @since 18/5/17.
 */

// playing with generics, not sure if it'll work as all generics are stripped on runtime
// plus the singleton! no ide yet
public interface IUserDAO<T extends User> {
    Set<T> geUserSet();
    void addLecturer(Lecturer lecturer);
    Lecturer lookupLectByID(String s) throws CourseException;
    Lecturer lookupLectByName(String s) throws CourseException;
}
