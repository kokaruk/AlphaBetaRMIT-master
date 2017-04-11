package alphabeta.mvc.model;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;

import javax.swing.text.html.parser.Entity;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

import static org.junit.Assert.assertTrue;

/**
 * Created by dimz on 7/4/17.
 * Test Class. Testing Public Methods for Student Class
 */
@RunWith(MockitoJUnitRunner.class)
public class StudentTest {

    private final Integer MAX_CURRENT_COURSE_LOAD = 1;

    @Mock
    Degree myDegreeMock;
    @Mock
    Enrollment enrollmentMock1;
    @Mock
    Enrollment enrollmentMock2;
    @Mock
    Semester semester1;
    @Mock
    Semester semester2;
    @InjectMocks
    Student myStudent;

    CourseOffering offering1;
    CourseOffering offering2;

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
        myStudent = getStudent();
        offering1 = new CourseOffering();
        offering1.name = "Offering 1";
        offering1.offerSemester = semester1;

        offering2 = new CourseOffering();
        offering2.name = "Offering 2";
        offering2.offerSemester = semester2;
        myDegreeMock.currentSemester = semester1;
        myStudent.setDegree(myDegreeMock);

    }

    @Test
    public void viewMyResults_NotEnrolledInAnyCourses_ThrowsIllegalStateException() {
        Exception myException = null;
        try {
            System.out.print(myStudent.viewMyResults());
        } catch (Exception e) {
            myException = e;
            System.out.println(myException.getMessage());
        }
        finally {
            assertTrue(myException instanceof IllegalStateException);
        }

    }

    @Test
    public void viewMyResults_EnrolledInMockEnrollment_ExpectAString() {
        enrollmentMock1.student = myStudent;
        enrollmentMock1.courseOffering = offering1;
        enrollmentMock2.student = myStudent;
        enrollmentMock2.courseOffering = offering2;
        enrollmentMock2.result = Result.d;
        enrollmentMock2.passed = true;

        Set<Enrollment> course = new HashSet<>();
        course.add(enrollmentMock1);
        course.add(enrollmentMock2);

        System.out.println("Student Name = " + enrollmentMock1.student.getName());
        System.out.println("Enrolled Count = " + course.size());
        myStudent.setEnrollment(course);
        System.out.println(myStudent.viewMyResults());
        assertTrue(myStudent.viewMyResults().getClass().equals(String.class)) ;
    }

    @Test
    public void enrol_reachedMaximumLoading_ThrowsIndexOutOfBoundsException() {
        Exception myException = null;
        try {
            Student myStudent = getStudent();
            myStudent.setMaxCurrentCourseLoad(0);
            myStudent.enrol(enrollmentMock1);
            myStudent.enrol(enrollmentMock2);
        } catch (Exception e) {
            myException = e;
        } finally {
            System.out.println(myException.getClass().toString());
            System.out.println(myException.getMessage());
            assertTrue(myException instanceof IndexOutOfBoundsException);
        }
    }

    @Test
    public void enrol_reachedMaximumLoading_ThrowsPrerequisitesNotMetException() {

        Exception myException = null;
        try {
            myStudent.enrol(getEnrollment());
        } catch (Exception e) {
            myException = e;
        } finally {
            System.out.println(myException.getClass().toString());
            System.out.println(myException.getMessage());
            assertTrue(myException instanceof PrerequisitesNotMetException);
        }
    }

    // create a student instance
    private Student getStudent(){
        Student myStudent = new Student("Alex Foo", "alexfoo");
        myStudent.setMaxCurrentCourseLoad(MAX_CURRENT_COURSE_LOAD);
        return myStudent;
    }

    // create an enrollment instance
    private Enrollment getEnrollment() {

        Course myCourse = new Course();
        myCourse.name = "Course 1";
        myCourse.topics = new ArrayList<>();
        myCourse.topics.add(new Topic("Topic 1"));

        Course myPrerequisiteCourse = new Course();
        myPrerequisiteCourse.name = "Course 2 prerequisite to 1";
        myPrerequisiteCourse.topics = new ArrayList<>();
        myCourse.prerequisiteList = new ArrayList<>();
        myCourse.prerequisiteList.add(myPrerequisiteCourse);

        Enrollment myEnrollment = new Enrollment();
        myEnrollment.courseOffering = new CourseOffering("Offering Name", 1, 4, "Peter", myCourse);

        return myEnrollment;
    }


}