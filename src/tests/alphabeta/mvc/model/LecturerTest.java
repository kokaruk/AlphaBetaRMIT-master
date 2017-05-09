package alphabeta.mvc.model;


import org.junit.*;
import org.mockito.*;
import java.util.NoSuchElementException;
import java.util.Set;
import static org.mockito.Mockito.*;
import static org.junit.Assert.*;

/**
 * @author komal
 * @since 8/5/17.
 */
public class LecturerTest {

	@Mock
	Student student;
	@Mock
    Enrollment enrollment;
	@Mock
    CourseOffering courseOffering;
    Set<Enrollment> enrollmentSet;
	Lecturer lecturer;
	
	@Before
	public void setUp() {
        enrollmentSet.add(enrollment);
		MockitoAnnotations.initMocks(this);
		lecturer = new Lecturer("Foo Bar", "foobar");
		when(student.getEnrollment()).thenReturn(enrollmentSet);
	}

	@Test
	public void testUploadResults_case1() {
	    lecturer.upLoadResults(student, Result.hd);

	    assertEquals(Result.hd, student.getEnrollment().iterator().next().result );
	}

	@Test(expected = NoSuchElementException.class)
    public void testUploadResults_case2_throwsNoSuchElementException() {
        try {
            lecturer.upLoadResults(student, Result.hd);
        } catch (Exception e) {
            throw e;
        }
    }

    @Test(expected = ItemExistsException.class)
    public void testUploadResults_case4_ThrowsItemExistsException() throws ItemExistsException{
        try {
            lecturer.upLoadResults(student, Result.hd);
        } catch (Exception e) {
            throw e;
        }

    }

}
