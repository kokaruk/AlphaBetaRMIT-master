package model;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.List;

/**
 * Created by dimz on 7/4/17.
 */
public class StudentTest {

    // comment

    @Mock
    Degree myDegree;
    @Mock
    List<Enrollment> course;
    @InjectMocks
    Student student;

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testViewMyResults() throws Exception {
        student.viewMyResults();
    }

    @Test
    public void testEnrol() throws Exception {
        boolean result = student.enrol();
        Assert.assertEquals(true, result);
    }

    @Test
    public void testWithdraw() throws Exception {
        boolean result = student.withdraw();
        Assert.assertEquals(true, result);
    }

    @Test
    public void testViewCourseOffereings() throws Exception {
        student.viewCourseOffereings();
    }
}