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

    private CourseOffering sef2017;
    private Semester mySemester;

    @Before
    public void setup(){
        sef2017 = FactoryHelperClass.getCourseOffering();
        mySemester  = new Semester();
        mySemester.semesterNumber = 1;
        mySemester.year = 2018;
        mySemester.week = 1;
        sef2017.setMySemester(mySemester);
    }

	@Test
	public void testNewCourseOffering() {
		assertEquals("2018 1 Test Course", sef2017.getName());
	}


	@Test
	public void testSetSemester() {


		assertEquals(2018, sef2017.getMySemester().year);
	}

	@Test
	public void testSetMaxStudents() {
		sef2017.setMaxStudents(10);

		assertEquals(10, sef2017.getMaxStudents());
	}

	@Test
	public void testAssignLecturerCourse() {
		CourseOffering sef2017 = FactoryHelperClass.getCourseOffering();
        String lecturer[] = new String[]{"Bill T", "billt"};
		Staff myLecturer = new Lecturer(lecturer[0], lecturer[1]);
        sef2017.setMyLecturer((Lecturer) myLecturer);

		assertEquals(lecturer[0], sef2017.getMyLecturer().getName());
	}

}
