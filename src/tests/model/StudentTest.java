package model;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.HashSet;
import java.util.Set;

import static org.junit.Assert.*;

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
    CourseOffering offering1;
    @Mock
    CourseOffering offering2;
    @Mock
    Semester semester1;
    @Mock
    Semester semester2;

    @InjectMocks
    Student studentMock;



    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
        offering1.offerSemester = semester1;
        offering2.offerSemester = semester2;
        myDegreeMock.currentSemester = semester1;
        studentMock.setDegree(myDegreeMock);

    }

    @Test
    public void ViewMyResults_NotEnrolledInAnyCourses_ThrowsIllegalStateException() {
        try {
            System.out.print(studentMock.viewMyResults());
        } catch (Exception e) {
            System.out.println(e.getMessage());
            assertTrue(e instanceof IllegalStateException);
        }

    }

    @Test
    public void ViewMyResults_EnrolledInMock_ExpectAString() {

        enrollmentMock1.student = studentMock;
        enrollmentMock1.courseOffering = offering1;

        enrollmentMock2.student = studentMock;
        enrollmentMock2.courseOffering = offering2;
        enrollmentMock2.result = Result.d;
        enrollmentMock2.passed = true;

        Set<Enrollment> course = new HashSet<>();
        course.add(enrollmentMock1);
        course.add(enrollmentMock2);

        System.out.println(enrollmentMock1.student.getName());
        System.out.println(course.size());
        studentMock.setEnrollment(course);
        System.out.println(studentMock.viewMyResults());
        String expectResult = "null,Distinction,Passed\r\n" +
                "null,Currently Enrolled,Failed\r\n";
        assertEquals(expectResult, studentMock.viewMyResults());
    }

}