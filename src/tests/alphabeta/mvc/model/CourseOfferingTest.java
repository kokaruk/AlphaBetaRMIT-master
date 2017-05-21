package alphabeta.mvc.model;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * Created by Bill Thompson on 9/4/17.
 * Refactoring by DK 17/04/17
 * Course Offering JUnit Test Class
 * last edit by kristin 14/05/17
 */

public class CourseOfferingTest {

    private CourseOffering sef2017;
    private Semester mySemester;

    @BeforeEach
    public void setup(){
        sef2017 = getCourseOffering();
        mySemester  = new Semester(01,2018,01);
        //mySemester.semesterNumber = 1;
        //mySemester.year = 2018;
        //mySemester.week = 1;
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
		CourseOffering sef2017 = getCourseOffering();
		Staff myLecturer = new Lecturer("Bill T", "billt", 123);
        sef2017.setMyLecturer((Lecturer) myLecturer);

		assertEquals("Bill T", sef2017.getMyLecturer().getName());
	}

    // make fake course offering
    private CourseOffering getCourseOffering() {
        Semester mySemester = new Semester(2, 2017, 1);
        Lecturer myLecturer = new Lecturer("Test Name", "testname2", 123);
        List<Topic> myTopics = new ArrayList<>();
        myTopics.add(new Topic("Topic Name"));
        Course myCourse = new Course("Test Course");
        myCourse.topics = myTopics;
        return new CourseOffering(mySemester, 28, myLecturer, myCourse);
    }

}
