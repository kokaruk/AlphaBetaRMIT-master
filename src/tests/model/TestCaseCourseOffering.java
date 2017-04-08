package model;


import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import static org.junit.Assert.assertEquals;


public class TestCaseCourseOffering {

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
		System.out.println("The name of the course offering is " + sef2017.name);
		assertEquals("Software Engineering Fundamentals", sef2017.name);
	}
	
	@Test
	public void testCourseOffering() {
		CourseOffering sef2017 = new CourseOffering();
		System.out.println("The name for the new Course Offering is " + sef2017.name);
		sef2017.setName("Database Concepts");
		System.out.println("The new name for the new Course Offering is " + sef2017.name);
		assertEquals("Database Concepts", sef2017.name);
	}

	@Test
	public void testSetSemester() {
		CourseOffering sef2017 = new CourseOffering();
		System.out.println("The semester for the new Course Offering is " + sef2017.semester);
		sef2017.setSemester(2018);
		System.out.println("The semester for the new Course Offering is " + sef2017.semester);
		assertEquals(2018, sef2017.semester);
	}

	@Test
	public void testSetMaxStudents() {
		CourseOffering sef2017 = new CourseOffering();
		System.out.println("The maximum number of students for the new Course Offering is " + sef2017.maxStudents);
		sef2017.setMaxStudents(10);
		System.out.println("The maximum number of students for the new Course Offering is " + sef2017.maxStudents);
		assertEquals(10, sef2017.maxStudents);
	}

	@Test
	public void testAssignLecturerCourse() {
		CourseOffering sef2017 = new CourseOffering();
		System.out.println("The Lecturer for the new Course Offering is " + sef2017.lecturer);
		sef2017.assignLecturerCourse("Bill");
		System.out.println("The Lecturer for the new Course Offering is " + sef2017.lecturer);
		assertEquals("Bill", sef2017.lecturer);
	}

}
