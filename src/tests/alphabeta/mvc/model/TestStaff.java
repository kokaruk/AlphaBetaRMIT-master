package alphabeta.mvc.model;

import org.junit.jupiter.api.*;
import org.mockito.*;

import java.util.*;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;


class TestStaff {

    private StuffConcrete stuffTest;
    private Set<String> testList;
    @Mock private Student student;
    @Mock private Enrollment enrollment;
    @Mock private Set<Enrollment> enrollmentSet;
    @Mock private Iterator<Enrollment> enrollmentIterator;
    @Mock private CourseOffering offering;

    @BeforeEach
    void setUp() {
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
	void testViewAllResults() {
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
