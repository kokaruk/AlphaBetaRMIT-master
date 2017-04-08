package model;


import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

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
