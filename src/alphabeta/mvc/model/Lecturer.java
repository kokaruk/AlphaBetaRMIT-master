package alphabeta.mvc.model;


import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.HashSet;
import java.util.NoSuchElementException;
import java.util.Set;

public class Lecturer extends Staff {
    private static Logger logger = LogManager.getLogger();
    public Lecturer(String name, String username) {
        super(name, username);
    }

    private Set<Course> myCourses = new HashSet<>();

    void addMyCourse(Course myCourse) {
        myCourses.add(myCourse);
    }

    void upLoadResults(Student student, Result result, Course course) throws NoSuchElementException {
        if (!myCourses.contains(course)) throw new NoSuchElementException();

        Course myCourse;
        Set<Enrollment> setTest = student.getEnrollment();
        for( Enrollment enrollmentItem : setTest ){
            myCourse = enrollmentItem.getCourseOffering().getMyCourse();
            logger.trace(myCourse.equals(course));
        }

        Enrollment enrollment = student.getEnrollment()
                .stream()
                .filter( enr -> enr.getCourseOffering().getMyCourse().name.equals(course.getName()))
                .findAny()
                .orElseThrow(NoSuchElementException::new);
        enrollment.setResult(result);
    }


    void upLoadResultsTest(Student student) throws NoSuchElementException {
        Set<Enrollment> list = student.getEnrollment();
        Set<String> forPrint = new HashSet<>();
        for (Enrollment enrol : list) {
            CourseOffering courseOffering = enrol.getCourseOffering();
            String name = courseOffering.getName();
            String result = enrol.getResult().getDescription();
            String fullResult = name + "," + result;
            forPrint.add(fullResult);
        }
    }



}