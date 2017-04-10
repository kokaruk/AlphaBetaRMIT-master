package alphabeta.mvc.model;


import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.List;

import static org.junit.Assert.assertTrue;

public class LecturerTest {

	 @Mock
	 List<CourseOffering> courses;
	 @InjectMocks
	 Lecturer lecturer;
	
	@Before
	public void setUp() throws Exception {
		MockitoAnnotations.initMocks(this);
	}

	@Test
	public void testUploadResults() {
		assertTrue(lecturer.upLoadResults());
	}

}
