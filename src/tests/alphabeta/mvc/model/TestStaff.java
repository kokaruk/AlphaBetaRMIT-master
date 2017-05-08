package alphabeta.mvc.model;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static org.junit.Assert.assertTrue;



public class TestStaff {


	@Test
	public void testViewAllResults() {
		Staff lecturer = new Lecturer("Test Name", "testname2");
		Set<String> testList = new HashSet<>();
		testList.add("Course: 2017 1 Test Course, Result: High Distinction");
		//Prints hard coded results for a student for the purpose of demonstration
		Semester mySemester = new Semester();
		mySemester.semesterNumber = 1;
		mySemester.year = 2017;
		mySemester.week = 1;
		Staff myLecturer = new Lecturer("Test Name", "testname2");
		List<Topic> myTopics = new ArrayList<>();
		myTopics.add( new Topic("Topic Name"));
		Course myCourse = new Course();
		myCourse.name = "Test Course";
		myCourse.topics = myTopics;
		CourseOffering courseOffering = new CourseOffering(mySemester, 28, (Lecturer)myLecturer, myCourse);
		Enrollment enrollment = new Enrollment();
		enrollment.result = Result.hd;
		enrollment.courseOffering = courseOffering;
		Set<Enrollment> enrolList = new HashSet<>();
		enrolList.add(enrollment);
		Student student = new Student("Test Name", "testname1");
		student.setEnrollment(enrolList);
		Set<String> results = lecturer.viewAllResults(student);
		System.out.println(results);
		assertTrue(testList.equals(results));
	}

}
