package model;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.junit.Assert.assertTrue;

/**
 * Created by dimz on 7/4/17.
 * Test Class. Testing Public Methods for Student Class
 */
public class StudentTest {

    @Mock
    Degree myDegreeMock;
    @InjectMocks
    Student studentMock;


    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
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
/*
    @Test
    public void ViewMyResults_EnrolledInMock_ExpectAString() {

        Enrollment enrollmentMock = mock(Enrollment.class);

        Set<Enrollment> course;


        enrollmentMock.student = studentMock;
        System.out.println(enrollmentMock.student.getName());
        course.add(enrollmentMock);
        System.out.print(course.size());
        studentMock.setEnrollment(course);
    }
*/
}