package model;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Set;

import static org.junit.Assert.assertTrue;

/**
 * Created by dimz on 7/4/17.
 * Test Class. Testing Public Methods for Student Class
 */
public class StudentTest {

    @Mock
    Degree myDegree;
    @Mock
    Set<Enrollment> course;
    @Mock
    Enrollment enrollment;
    @InjectMocks
    Student student;

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
        student.setDegree(myDegree);
    }

    @Test
    public void ViewMyResults_NotEnrolledInAnyCourses_ThrowsIllegalStateException() {
        try {
            System.out.print(student.viewMyResults());
        } catch (Exception e) {
            assertTrue(e instanceof IllegalStateException);
        }

    }

    @Test
    public void ViewMyResults_EnrolledInMock_ExpectAString() {
        enrollment.student = student;
        System.out.println(enrollment.student.getName());
        course.add(enrollment);
        System.out.print(course.size());
        student.setEnrollment(course);
    }

}