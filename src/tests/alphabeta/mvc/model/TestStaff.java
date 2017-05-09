package alphabeta.mvc.model;

import org.junit.*;
import org.mockito.*;

import java.util.*;

import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.*;


public class TestStaff {

    StuffConcrete stuffTest;
    Set<String> testList;
    @Mock Student student;
    @Mock Enrollment enrollment;
    @Mock Set<Enrollment> enrollmentSet;
    @Mock Iterator<Enrollment> enrollmentIterator;
    @Mock CourseOffering offering;

    @Before
    public void setUp() {
        stuffTest = new StuffConcrete();
        testList = new HashSet<>();
        MockitoAnnotations.initMocks(this);
        when(student.getEnrollment()).thenReturn(enrollmentSet);
        when(enrollmentIterator.hasNext()).thenReturn(true, false);
        when(enrollmentIterator.next()).thenReturn(enrollment);
        when(enrollmentSet.iterator()).thenReturn(enrollmentIterator);
        when(enrollment.getCourseOffering()).thenReturn(offering);
        when(offering.getName()).thenReturn("2017 1 Test Course");
        when(enrollment.getResult()).thenReturn(Result.hd);
    }

	@Test
	public void testViewAllResults() {
		testList.add("2017 1 Test Course,High Distinction");
		Set<String> results = stuffTest.viewAllResults(student);

		assertTrue(testList.equals(results));
	}

	private class StuffConcrete extends Staff {
        StuffConcrete() {
            super("Test Name", "testname2");
        }
    }

}
