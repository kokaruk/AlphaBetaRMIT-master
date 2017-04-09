package alphabeta.mvc.model;


import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by Bill Thompson on 9/4/17.
 * Course Offering JUnit Test Class
 */

public class CourseOfferingTest {

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {

	}

	@Before
	public void setUp() throws Exception {

	}

	@Test
	public void testNumberCourseOffering() {
		int nowNumberOfCourseOfferings = CourseOffering.numberOfCourseOfferings;
		System.out.println("The number of the course offerings is " + nowNumberOfCourseOfferings);
		CourseOffering sef2017 = new CourseOffering("Software Engineering Fundamentals", 2017, 30, "Joe");
		System.out.println("The number of the course offerings is " + CourseOffering.numberOfCourseOfferings);
		assertEquals(nowNumberOfCourseOfferings + 1, CourseOffering.numberOfCourseOfferings);
	}
	
	@Test
	public void testNewCourseOffering() {
		CourseOffering sef2017 = new CourseOffering("Software Engineering Fundamentals", 2017, 30, "Joe");
		System.out.println("The name of the course offering is " + sef2017.getNameOfCourseOffering());
		assertEquals("Software Engineering Fundamentals", sef2017.getNameOfCourseOffering());
	}
	
	@Test
	public void testCourseOffering() {
		CourseOffering sef2017 = new CourseOffering();
		System.out.println("The name for the new Course Offering is " + sef2017.getNameOfCourseOffering());
		sef2017.setName("Database Concepts");
		System.out.println("The new name for the new Course Offering is " + sef2017.getNameOfCourseOffering());
		assertEquals("Database Concepts", sef2017.getNameOfCourseOffering());
	}

	@Test
	public void testSetSemester() {
		CourseOffering sef2017 = new CourseOffering();
		System.out.println("The semester for the new Course Offering is " + sef2017.getSemester());
		sef2017.setSemester(2018);
		System.out.println("The semester for the new Course Offering is " + sef2017.getSemester());
		assertEquals(2018, sef2017.getSemester());
	}

	@Test
	public void testSetMaxStudents() {
		CourseOffering sef2017 = new CourseOffering();
		System.out.println("The maximum number of students for the new Course Offering is " + sef2017.getMaxStudents());
		sef2017.setMaxStudents(10);
		System.out.println("The maximum number of students for the new Course Offering is " + sef2017.getMaxStudents());
		assertEquals(10, sef2017.getMaxStudents());
	}

	@Test
	public void testAssignLecturerCourse() {
		CourseOffering sef2017 = new CourseOffering();
		System.out.println("The Lecturer for the new Course Offering is " + sef2017.getNameOfLecturer());
		sef2017.assignLecturerCourse("Bill");
		System.out.println("The Lecturer for the new Course Offering is " + sef2017.getNameOfLecturer());
		assertEquals("Bill", sef2017.getNameOfLecturer());
	}

}
