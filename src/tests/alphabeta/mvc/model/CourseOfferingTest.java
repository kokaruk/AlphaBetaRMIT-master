package alphabeta.mvc.model;


import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by Bill Thompson on 9/4/17.
 * Refactoring by DK 17/04/17
 * Course Offering JUnit Test Class
 */

public class CourseOfferingTest {

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {

	}

	@Before
	public void setUp() throws Exception {

	}

	// suppressed. integration test.
	/*
	@Test
	public void testNumberCourseOffering() {
		int nowNumberOfCourseOfferings = CourseOffering.numberOfCourseOfferings;
		System.out.println("The number of the course offerings is " + nowNumberOfCourseOfferings);
		CourseOffering sef2017 = new CourseOffering("Software Engineering Fundamentals", 2017, 30, "Joe");
		System.out.println("The number of the course offerings is " + CourseOffering.numberOfCourseOfferings);
		assertEquals(nowNumberOfCourseOfferings + 1, CourseOffering.numberOfCourseOfferings);
	}
	*/
	
	@Test
	public void testNewCourseOffering() {
		CourseOffering sef2017 = FactoryHelperClass.getCourseOffering();
		System.out.println("The name of the course offering is " + sef2017.getName());
		// assertion
		assertEquals("2017 1 Test Course", sef2017.getName());
	}


	@Test
	public void testSetSemester() {
		CourseOffering sef2017 = FactoryHelperClass.getCourseOffering();

        System.out.println("The semester for the new Course Offering is " + sef2017.getMySemester().year);
        Semester mySemester = new Semester();
        mySemester.semesterNumber = 1;
        mySemester.year = 2018;
        mySemester.week = 1;
		sef2017.setMySemester(mySemester);
		System.out.println("The semester for the new Course Offering is " + sef2017.getMySemester().year);
        // assertion
		assertEquals(2018, sef2017.getMySemester().year);
	}

	@Test
	public void testSetMaxStudents() {
		CourseOffering sef2017 = FactoryHelperClass.getCourseOffering();
		System.out.println("The maximum number of students for the new Course Offering is " + sef2017.getMaxStudents());
		sef2017.setMaxStudents(10);
		System.out.println("The maximum number of students for the new Course Offering is " + sef2017.getMaxStudents());
        // assertion
		assertEquals(10, sef2017.getMaxStudents());
	}

	@Test
	public void testAssignLecturerCourse() {
		CourseOffering sef2017 = FactoryHelperClass.getCourseOffering();
		System.out.println("The Lecturer for the new Course Offering is " + sef2017.getMyLecturer().getName());
        String lecturerName = "Bill T";
		Staff myLecturer = new Lecturer(lecturerName, "billt");
        sef2017.setMyLecturer((Lecturer) myLecturer);
		System.out.println("The Lecturer for the new Course Offering is " + sef2017.getMyLecturer().getName());
        // assertion
		assertEquals(lecturerName, sef2017.getMyLecturer().getName());
	}

}
