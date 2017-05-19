package alphabeta.mvc.systemDAL;

import alphabeta.mvc.model.CourseException;
import alphabeta.mvc.model.Lecturer;

import java.util.HashSet;
import java.util.Set;

/**
 * @author dimz
 * @since 18/5/17.
 */
public class LecturerDAO_fake implements ILecturerDAO {
    private Set<Lecturer> userSet = new HashSet<>();

    // singleton instance
    private static ILecturerDAO instance;
    // private constructor
    private LecturerDAO_fake() { makeTestLecturer();
    }
    // lazy instantiation
    public static ILecturerDAO getInstance() {
        if (instance == null) {
            instance = new LecturerDAO_fake();
        }
        return instance;
    }

    @Override
    public Set<Lecturer> getLecturerSet() {
        return userSet;
    }

    @Override
    public Lecturer getNewLecturer(String name, String username) {
        Lecturer lecturer = new Lecturer(name, username, 123);
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

    private void makeTestLecturer(){
        Lecturer lecturer1 = new Lecturer("Jane Doe", "jd123", 01);
        userSet.add(lecturer1);
        Lecturer lecturer2 = new Lecturer("Dave Smith", "ds103", 02);
        userSet.add(lecturer2);
        Lecturer lecturer3 = new Lecturer("Bill Thompson", "bt123", 03);
        userSet.add(lecturer3);

    }
}
