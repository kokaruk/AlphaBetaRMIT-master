package model;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import junit.framework.Assert;

public class TestStaff {

	
	@Before
	public void setUp() throws Exception {
		
	}

	@Test
	public void testViewAllResults() {
		Staff lecturer = new Lecturer("Test Name", "testname2");
		List<String> testList = new ArrayList<String>();
		testList.add("Course: Test Course, Result: High Distinction");
		CourseOffering courseOffering = new CourseOffering();
		courseOffering.setName("Test Course");
		Enrollment enrollment = new Enrollment();
		enrollment.setResult("High Distinction");
		enrollment.setCourseOffering(courseOffering);
		List<Enrollment> enrolList = new ArrayList<Enrollment>();
		enrolList.add(enrollment);
		Student student = new Student("Test Name", "testname1");
		student.setEnrollment(enrolList);
		List<String> results = lecturer.viewAllResults(student);
		Assert.assertTrue(testList.equals(results));
	}

}
