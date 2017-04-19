package alphabeta.mvc.model;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;

import java.lang.invoke.WrongMethodTypeException;
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
        myStudent = FactoryHelperClass.getStudent();
        offering1 = FactoryHelperClass.getCourseOffering();
        offering1.name = "Offering 1";
        offering1.mySemester = semester1;

        offering2 = FactoryHelperClass.getCourseOffering();
        offering2.name = "Offering 2";
        offering2.mySemester = semester2;
        myDegreeMock.currentSemester = semester1;
        myStudent.setDegree(myDegreeMock);

    }

    @Test(expected=IllegalStateException.class)
    public void viewMyResults_NotEnrolledInAnyCourses_ThrowsIllegalStateException() {
        try {
            System.out.print(myStudent.viewMyResults());
        } catch (Exception e) {
            System.out.println(e.getMessage());
            throw e;
        }
    }

    @Test
    public void viewMyResults_EnrolledInMockEnrollment_ExpectAStringOfResults() {
        enrollmentMock1.student = myStudent;
        enrollmentMock1.courseOffering = offering1;
        enrollmentMock2.student = myStudent;
        enrollmentMock2.courseOffering = offering2;
        enrollmentMock2.result = Result.f;

        Set<Enrollment> course = new HashSet<>();
        course.add(enrollmentMock1);
        course.add(enrollmentMock2);

        System.out.println("Student Name = " + enrollmentMock1.student.getName());
        System.out.println("Enrolled Count = " + course.size());
        myStudent.setEnrollment(course);
        System.out.println(myStudent.viewMyResults());
        assertTrue(myStudent.viewMyResults().getClass().equals(String.class));
    }

    @Test(expected=IndexOutOfBoundsException.class)
    public void enrol_reachedMaximumLoading_ThrowsIndexOutOfBoundsException() throws PrerequisitesNotMetException {
        Student myStudent = FactoryHelperClass.getStudent();
        myStudent.setMaxCurrentCourseLoad(0);
        try {

            myStudent.enrol(enrollmentMock2);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            throw e;
        }
    }

    @Test(expected = PrerequisitesNotMetException.class)
    public void enrol_OfferingHasRequiredPrerequisiteWithoutWaiver_ThrowsPrerequisitesNotMetException() throws PrerequisitesNotMetException {
        try {
            myStudent.enrol(FactoryHelperClass.getEnrollmentWithPrerequisite());
        } catch (Exception e) {
            System.out.println(e.getClass().toString());
            System.out.println(e.getMessage());
            throw e;
        }
    }

    @Test
    public void enrol_OfferingHasRequiredPrerequisiteHaveWaiver_enrolsInOffering(){
        Course myPrerequisiteCourse = new Course();
        myPrerequisiteCourse.name = "Course 2 prerequisite to 1";
        myPrerequisiteCourse.topics = new ArrayList<>();
        myStudent.setWaivers(myPrerequisiteCourse);
        try {
            myStudent.enrol(FactoryHelperClass.getEnrollmentWithPrerequisite());
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        assertTrue(myStudent.getEnrollment().size() == 1);
    }

    @Test(expected = PrerequisitesNotMetException.class)
    public void enrol_enrolInOfferingWithFailedPreRequisite_ThrowsPrerequisitesNotMetException() throws PrerequisitesNotMetException{
        // set max load to 2
        myStudent.setMaxCurrentCourseLoad(2);
        // enroll in no pre-requisites enrollment
        Enrollment basicEnrollment = FactoryHelperClass.getEnrollment();
        try {
            myStudent.enrol(basicEnrollment);
        } catch (Exception e) {
            throw new IllegalArgumentException();
        }
        // set mark for enrollment
        basicEnrollment.result = Result.f;
        try {
            myStudent.enrol(FactoryHelperClass.getEnrollmentWithPrerequisite());
            System.out.println("enrolled");
        } catch (Exception e) {
            System.out.println(e.getMessage());
            throw e;
        }
    }

    @Test
    public void enrol_enrolInOfferingWithPassedPreRequisite_enrolsInOffering(){
        // set max load to 2
        myStudent.setMaxCurrentCourseLoad(2);
        // enroll in no pre-requisites enrollment
        Enrollment basicEnrollment = FactoryHelperClass.getEnrollment();
        try {
            myStudent.enrol(basicEnrollment);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        // set mark for enrollment
        basicEnrollment.result = Result.p;
        try {
            myStudent.enrol(FactoryHelperClass.getEnrollmentWithPrerequisite());
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        assertTrue(myStudent.getEnrollment().size() == 2);
    }



}