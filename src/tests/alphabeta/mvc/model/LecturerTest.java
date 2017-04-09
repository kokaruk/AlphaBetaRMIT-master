package alphabeta.mvc.model;


import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.List;

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
		lecturer.upLoadResults();
	}

}
