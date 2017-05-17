package alphabeta.mvc.model;


import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.jupiter.api.*;
import org.mockito.*;

import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

/**
 * @author komal
 * @since 8/5/17.
 */
public class LecturerTest {

    private static Logger logger = LogManager.getLogger();

    @Mock private Course course;


    @Mock private Student student;
    @Mock private Enrollment enrollment;
    @Mock private Set<Enrollment> enrollmentSet;
    @Mock private Iterator<Enrollment> enrollmentIterator;
    @Mock private CourseOffering offering;
	private Lecturer lecturer;

	@BeforeEach
	public void setUp() {
        MockitoAnnotations.initMocks(this);
        when(student.getEnrollment()).thenReturn(enrollmentSet);
        when(enrollmentIterator.hasNext()).thenReturn(true, false);
        when(enrollmentIterator.next()).thenReturn(enrollment);
        when(enrollmentSet.iterator()).thenReturn(enrollmentIterator);
        when(enrollment.getCourseOffering()).thenReturn(offering);
        when(offering.getMyCourse()).thenReturn(course);
        when(course.getName()).thenReturn("blah");
		lecturer = new Lecturer("Foo Bar", "foobar");

	}


	@Test
	public void testUploadResults_case1() {
	    lecturer.addMyCourse(course);

        Course myCourse;
        Set<Enrollment> setTest = student.getEnrollment();
        for( Enrollment enrollmentItem : setTest ){
            myCourse = enrollmentItem.getCourseOffering().getMyCourse();
            logger.trace(myCourse.equals(course));
        }

       // lecturer.upLoadResultsTest(studentFake, Result.hd, course);

        lecturer.upLoadResultsTest(student);

	   // assertEquals(Result.hd, student.getEnrollment().iterator().next().result );
	}

	@Test
    public void testUploadResults_case2_throwsNoSuchElementException() {
        assertThrows(NoSuchElementException.class, () -> lecturer.upLoadResults(student, Result.hd, course));
    }

}
