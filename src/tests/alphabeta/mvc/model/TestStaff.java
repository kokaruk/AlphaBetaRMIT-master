package alphabeta.mvc.model;

import org.junit.Before;
import org.junit.Test;

import java.util.HashSet;
import java.util.Set;

import static org.junit.Assert.assertTrue;



public class TestStaff {

	
	@Before
	public void setUp() throws Exception {
		
	}

	@Test
	public void testViewAllResults() {
		Staff lecturer = new Lecturer("Test Name", "testname2");
		Set<String> testList = new HashSet<>();
		testList.add("Course: Test Course, Result: High Distinction");
		CourseOffering courseOffering = new CourseOffering();
		courseOffering.setName("Test Course");
		Enrollment enrollment = new Enrollment();
		enrollment.result = Result.hd;
		enrollment.courseOffering = courseOffering;
		Set<Enrollment> enrolList = new HashSet<>();
		enrolList.add(enrollment);
		Student student = new Student("Test Name", "testname1");
		student.setEnrollment(enrolList);
		Set<String> results = lecturer.viewAllResults(student);
		assertTrue(testList.equals(results));
	}

}
