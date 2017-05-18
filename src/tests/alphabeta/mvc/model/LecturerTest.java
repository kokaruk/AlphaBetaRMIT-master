package alphabeta.mvc.model;


import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Set;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.when;

/**
 * @author komal
 * @since 8/5/17.
 */
public class LecturerTest {

    private static Logger logger = LogManager.getLogger();
    private Lecturer lecturer;
    private Result result = Result.hd;


    @Mock private Student student;
    @Mock private Enrollment enrollment;
    @Mock private Set<Enrollment> enrollmentSet;
    @Mock private Iterator<Enrollment> enrollmentIterator;
    @Mock private CourseOffering offering;
    @Mock private Course course;

	@BeforeEach
	public void setUp() {
        lecturer = new Lecturer("Foo Bar", "foobar", 123);
        MockitoAnnotations.initMocks(this);
        when(student.getEnrollment()).thenReturn(enrollmentSet);
        when(enrollmentIterator.hasNext()).thenReturn(true, false);
        when(enrollmentIterator.next()).thenReturn(enrollment);
        when(enrollmentSet.iterator()).thenReturn(enrollmentIterator);
        when(enrollment.getCourseOffering()).thenReturn(offering);
        when(enrollment.getResult()).thenReturn(result);
        when(offering.getMyCourse()).thenReturn(course);
        doNothing().when(enrollment).setResult(result);
        when(enrollmentSet.stream()).thenReturn(Stream.of(enrollment));
    }


	@Test
	public void testUploadResults_case1() {
	    lecturer.addMyCourse(course);
        lecturer.upLoadResults(student, result, course);
	}

	@Test
    public void testUploadResults_case2_throwsNoSuchElementException() {
        assertThrows(NoSuchElementException.class, () -> lecturer.upLoadResults(student, result, course));
    }

}
