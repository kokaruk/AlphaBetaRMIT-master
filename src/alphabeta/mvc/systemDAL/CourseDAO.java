package alphabeta.mvc.systemDAL;

import alphabeta.mvc.model.Course;
import alphabeta.mvc.model.Topic;

import java.util.List;
import java.util.Set;

/**
 * @author dimz
 * @since 18/5/17.
 */
public class CourseDAO implements ICourseDAO {

    // singleton instance
    private static ICourseDAO instance;
    // private constructor
    private CourseDAO() {
    }
    // lazy instantiation
    public static ICourseDAO getInstance() {
        if (instance == null) {
            instance = new CourseDAO();
        }
        return instance;
    }

    @Override
    public Course getNewCourse(String name) {
        return null;
    }

    @Override
    public Course getNewCourse(String name, List<Course> prerequisiteList, List<Topic> topics) {
        return null;
    }

    @Override
    public Set<Course> getCourseSet() {
        return null;
    }

    @Override
    public Course lookupCourse(String s) {
        return null;
    }
}
