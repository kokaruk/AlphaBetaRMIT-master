package systemDAL;

import alphabeta.mvc.model.Course;
import alphabeta.mvc.model.CourseOffering;
import alphabeta.mvc.model.Lecturer;
import alphabeta.mvc.model.Semester;

import java.util.Set;

/**
 * @author dimz
 * @since 17/5/17.
 */
public interface ICourseOfferingDAO {
    Set<CourseOffering> getCurrentOfferings(Semester currentSemester);
    CourseOffering getNewCourseOffering(Semester semester, int maxStudents, Lecturer lecturer,  Course course);

}
