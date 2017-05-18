package alphabeta.mvc.systemDAL;

import alphabeta.mvc.model.*;

import java.util.HashSet;
import java.util.NoSuchElementException;
import java.util.Set;

/**
 * @author dimz
 * @since 17/5/17.
 */
public class CourseOfferingDAO_fake implements ICourseOfferingDAO {

    private Set<CourseOffering> courseOfferingSet = new HashSet<>();
    private ILecturerDAO lecturerDAO = FactoryDAO.lecturerDAO();
    private ISemesterDAO semesterDAO = FactoryDAO.semesterDAO();
    // singleton instance
    private static ICourseOfferingDAO instance;
    // private constructor
    private CourseOfferingDAO_fake() {
        makeTestOffering();
    }
    // lazy instantiation
    public static ICourseOfferingDAO getInstance() {
        if (instance == null) {
            instance = new CourseOfferingDAO_fake();
        }
        return instance;
    }

    @Override
    public Set<CourseOffering> getCurrentOfferings(Semester currentSemester) {
        return courseOfferingSet;
    }

    @Override
    public CourseOffering getCourseOffering(Semester semester, int maxStudents, Lecturer lecturer, Course course) {
        CourseOffering offering = new CourseOffering(semester, maxStudents, lecturer, course);
        offering.setMyLecturer(lecturer);
        courseOfferingSet.add(offering);
        return offering;
    }

    @Override
    public CourseOffering lookupCourseOffering(String name) throws NoSuchElementException {
        return courseOfferingSet.stream()
                .filter(co -> co.getName().contains(name))
                .findAny()
                .orElseThrow(NoSuchElementException::new);
    }

    private void makeTestOffering(){
        Lecturer lecturer = lecturerDAO.getNewLecturer("Foo Bar", "foobar");
        Course testCourse1 = new Course("Programming 1");
        CourseOffering testOffering = new CourseOffering(semesterDAO.getCurrentSemester(), 50, lecturer, testCourse1);
        courseOfferingSet.add(testOffering);
    }
}
