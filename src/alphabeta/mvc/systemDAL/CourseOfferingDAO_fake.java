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
    private ILecturerDAO lecturerDAO = ISystemDAL.lecturerDAO();
    private ISemesterDAO semesterDAO = ISystemDAL.semesterDAO();
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
        Semester testSemester1 = new Semester(02, 2017, 01);
        Semester testSemester2 = new Semester(01, 2018, 01);
        Lecturer lecturer = lecturerDAO.getNewLecturer("Foo Bar", "foobar");
        Course testCourse1 = new Course("Programming 1");
        Course testCourse2 = new Course("Software Engineering Fundamentals");
        CourseOffering testOffering = new CourseOffering(semesterDAO.getCurrentSemester(), 50, lecturer, testCourse1);
        CourseOffering testOffering2 = new CourseOffering(testSemester1, 50, lecturer, testCourse1);
        CourseOffering testOffering3 = new CourseOffering(testSemester2, 50, lecturer, testCourse1);
        CourseOffering testOffering4 = new CourseOffering(semesterDAO.getCurrentSemester(), 50, lecturer, testCourse2);
        CourseOffering testOffering5 = new CourseOffering(testSemester1, 50, lecturer, testCourse2);
        CourseOffering testOffering6 = new CourseOffering(testSemester2, 50, lecturer, testCourse2);
        courseOfferingSet.add(testOffering);
        courseOfferingSet.add(testOffering2);
        courseOfferingSet.add(testOffering3);
        courseOfferingSet.add(testOffering4);
        courseOfferingSet.add(testOffering5);
        courseOfferingSet.add(testOffering6);
    }
}
