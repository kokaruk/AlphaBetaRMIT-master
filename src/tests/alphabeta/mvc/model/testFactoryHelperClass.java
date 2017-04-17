package alphabeta.mvc.model;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by dimz on 17/4/17.
 */
class testFactoryHelperClass {

    private static final Integer MAX_CURRENT_COURSE_LOAD = 1;

    // create a student instance
    static Student getStudent() {
        Student myStudent = new Student("Alex Foo", "alexfoo");
        myStudent.setMaxCurrentCourseLoad(MAX_CURRENT_COURSE_LOAD);
        return myStudent;
    }

    // create an enrollment instance
    static Enrollment getEnrollmentWithPrerequisite() {

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

    // make fake course offering
    static CourseOffering getCourseOffering(){
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
        return new CourseOffering(mySemester, 28, (Lecturer)myLecturer, myCourse);
    }

}
