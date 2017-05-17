package alphabeta.mvc.systemDAL;

import alphabeta.mvc.model.Course;
import alphabeta.mvc.model.CourseOffering;
import alphabeta.mvc.model.Lecturer;
import alphabeta.mvc.model.Semester;

import java.util.Set;

/**
 * @author dimz
 * @since 17/5/17.
 */
public class CourseOfferingDAO implements ICourseOfferingDAO {

    // singleton instance
    private static ICourseOfferingDAO instance;
    // private constructor
    private CourseOfferingDAO() {
    }
    // lazy instantiation
    public static ICourseOfferingDAO getInstance() {
        if (instance == null) {
            instance = new CourseOfferingDAO();
        }
        return instance;
    }

    @Override
    public Set<CourseOffering> getCurrentOfferings(Semester currentSemester) {
        return null;
    }

    @Override
    public CourseOffering getNewCourseOffering(Semester semester, int maxStudents, Lecturer lecturer, Course course) {
        return null;
    }
}
