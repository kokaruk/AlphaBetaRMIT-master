package alphabeta.mvc.model;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;


/**
 * Created by dimz on 7/4/17.
 * Test Class. Testing Public Methods for Student Class
 */
public class StudentTest {

    private static final Integer MAX_CURRENT_COURSE_LOAD = 1;

    @Mock private CourseDirectory courseDirectoryMock;
    @Mock private Enrollment enrollmentMock1;
    @Mock private Enrollment enrollmentMock2;
    @Mock private Semester semester2;
    private Student myStudent;

    CourseOffering offering1;
    CourseOffering offering2;

    @BeforeEach
    void setUp() {
        int semNum = 1;
        int semYear = 2010;
        int semWeek = 6;
        MockitoAnnotations.initMocks(this);
        Semester semesterStatic;
        semesterStatic = new Semester(semNum, semYear, semWeek);
        ModelHelper.setCDMock(courseDirectoryMock);
        when(courseDirectoryMock.getSemester()).thenReturn(semesterStatic);
        myStudent = new Student("Alex Foo", "alexfoo", 123);
        myStudent.setMaxCurrentCourseLoad(MAX_CURRENT_COURSE_LOAD);

        offering1 = getCourseOffering();
        offering1.name = "Offering 1";
        offering1.mySemester = semesterStatic;

        offering2 = getCourseOffering();
        offering2.name = "Offering 2";
        offering2.mySemester = semester2;
    }

    @AfterEach
    void terDown(){
        //nullify injected seam
        ModelHelper.setCDMock(null);
    }

    @Test
    void getIdString_builder(){
        assertEquals("ST123",myStudent.getId());
    }

    @Test
    void viewMyResults_NotEnrolledInAnyCourses_IllegalArgumentException() {
        assertThrows(IllegalArgumentException.class, () -> myStudent.viewMyResults());
    }

    @Test
    void viewMyResults_EnrolledInMockEnrollment_ExpectAStringOfResults() {
        enrollmentMock1.student = myStudent;
        enrollmentMock1.courseOffering = offering1;
        enrollmentMock2.student = myStudent;
        enrollmentMock2.courseOffering = offering2;
        enrollmentMock2.result = Result.f;
        Set<Enrollment> course = new HashSet<>();
        course.add(enrollmentMock1);
        course.add(enrollmentMock2);
        myStudent.setEnrollment(course);

        assertTrue(myStudent.viewMyResults().getClass().equals(String.class));
    }

    @Test
    void enrol_reachedMaximumLoading_ThrowsIndexOutOfBoundsException() throws PrerequisitesNotMetException {

        myStudent.setMaxCurrentCourseLoad(0);

        assertThrows(IndexOutOfBoundsException.class, () -> myStudent.enrol(enrollmentMock2));
    }

    @Test
    void enrol_OfferingHasRequiredPrerequisiteWithoutWaiver_ThrowsPrerequisitesNotMetException() throws PrerequisitesNotMetException {
        assertThrows(PrerequisitesNotMetException.class, () -> myStudent.enrol(getEnrollmentWithPrerequisite()));
    }

    @Test
    void enrol_OfferingHasRequiredPrerequisiteHaveWaiver_enrolsInOffering() throws PrerequisitesNotMetException{
        Course myPrerequisiteCourse = new Course("Course 2 prerequisite to 1");
        myPrerequisiteCourse.topics = new ArrayList<>();
        myStudent.setWaivers(myPrerequisiteCourse);
        myStudent.enrol(getEnrollmentWithPrerequisite());

        assertTrue(myStudent.getEnrollment().size() == 1);
    }

    @Test
    void enrol_enrolInOfferingWithFailedPreRequisite_ThrowsPrerequisitesNotMetException() throws PrerequisitesNotMetException{
        // set max load to 2
        myStudent.setMaxCurrentCourseLoad(2);
        // enroll in no pre-requisites enrollment
        Enrollment basicEnrollment = getEnrollment();
        myStudent.enrol(basicEnrollment);

        // set mark for enrollment
        basicEnrollment.result = Result.f;
        assertThrows(PrerequisitesNotMetException.class, () -> myStudent.enrol(getEnrollmentWithPrerequisite()));
    }

    @Test
    void enrol_enrolInOfferingWithPassedPreRequisite_enrolsInOffering() throws PrerequisitesNotMetException{
        // set max load to 2
        myStudent.setMaxCurrentCourseLoad(2);
        // enroll in no pre-requisites enrollment
        Enrollment basicEnrollment = getEnrollment();
        myStudent.enrol(basicEnrollment);
        // set mark for enrollment
        basicEnrollment.result = Result.p;
        myStudent.enrol(getEnrollmentWithPrerequisite());

        assertTrue(myStudent.getEnrollment().size() == 2);
    }

    // create an enrollment instance
    private Enrollment getEnrollmentWithPrerequisite() {

        Course myCourse = new Course("Course 1");
        myCourse.topics = new ArrayList<>();
        myCourse.topics.add(new Topic("Topic 1"));

        Course myPrerequisiteCourse = new Course("Course 2 prerequisite to 1");
        myPrerequisiteCourse.topics = new ArrayList<>();

        myCourse.prerequisiteList = new ArrayList<>();
        myCourse.prerequisiteList.add(myPrerequisiteCourse);

        Enrollment myEnrollment = new Enrollment();
        myEnrollment.courseOffering = getCourseOffering();
        myEnrollment.courseOffering.setMyCourse(myCourse);

        return myEnrollment;
    }


    // make fake course offering
    private CourseOffering getCourseOffering() {
        Semester mySemester = new Semester(01, 2017, 1);
        Lecturer myLecturer = new Lecturer("Test Name", "testname2", 123);
        List<Topic> myTopics = new ArrayList<>();
        myTopics.add(new Topic("Topic Name"));
        Course myCourse = new Course("Test Course");
        myCourse.topics = myTopics;
        return new CourseOffering(mySemester, 28, myLecturer, myCourse);
    }

    private Enrollment getEnrollment() {
        Course myPrerequisiteCourse = new Course("Course 2 prerequisite to 1");
        myPrerequisiteCourse.topics = new ArrayList<>();
        Enrollment myEnrollment = new Enrollment();
        myEnrollment.courseOffering = getCourseOffering();
        myEnrollment.courseOffering.setMyCourse(myPrerequisiteCourse);
        return myEnrollment;
    }


}