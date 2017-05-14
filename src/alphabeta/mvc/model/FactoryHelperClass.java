package alphabeta.mvc.model;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by dimz on 17/4/17.
 * last edit by kristin 14/5/17 (only due to change in semester constructor)
 */
public class FactoryHelperClass {

    private static final Integer MAX_CURRENT_COURSE_LOAD = 1;

    // create a student instance
    static Student getStudent() {
        Student myStudent = new Student("Alex Foo", "alexfoo");
        myStudent.setMaxCurrentCourseLoad(MAX_CURRENT_COURSE_LOAD);
        return myStudent;
    }

    // create an enrollment instance
    public static Enrollment getEnrollmentWithPrerequisite() {

        Course myCourse = new Course();
        myCourse.name = "Course 1";
        myCourse.topics = new ArrayList<>();
        myCourse.topics.add(new Topic("Topic 1"));

        Course myPrerequisiteCourse = new Course();
        myPrerequisiteCourse.name = "Course 2 prerequisite to 1";
        myPrerequisiteCourse.topics = new ArrayList<>();

        myCourse.prerequisiteList = new ArrayList<>();
        myCourse.prerequisiteList.add(myPrerequisiteCourse);

        Enrollment myEnrollment = new Enrollment();
        myEnrollment.courseOffering = getCourseOffering();
        myEnrollment.courseOffering.setMyCourse(myCourse);

        return myEnrollment;
    }

    public static Enrollment getEnrollment() {
        Course myPrerequisiteCourse = new Course();
        myPrerequisiteCourse.name = "Course 2 prerequisite to 1";
        myPrerequisiteCourse.topics = new ArrayList<>();
        Enrollment myEnrollment = new Enrollment();
        myEnrollment.courseOffering = getCourseOffering();
        myEnrollment.courseOffering.setMyCourse(myPrerequisiteCourse);
        return myEnrollment;
    }

    // make fake course offering
    public static CourseOffering getCourseOffering() {
        Semester mySemester = new Semester(01, 2017, 1);
        Lecturer myLecturer = new Lecturer("Test Name", "testname2");
        List<Topic> myTopics = new ArrayList<>();
        myTopics.add(new Topic("Topic Name"));
        Course myCourse = new Course();
        myCourse.name = "Test Course";
        myCourse.topics = myTopics;
        return new CourseOffering(mySemester, 28, myLecturer, myCourse);
    }

}
