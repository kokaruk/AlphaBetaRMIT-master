package alphabeta.mvc.model;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * Created by dimz on 10/4/17.
 * Exception thown if required prerequisites not met when
 */
public class PrerequisitesNotMetException extends Exception {

    Student myStudent;
    CourseOffering myOffering;

    //constructor
    PrerequisitesNotMetException(Student myStudent, CourseOffering myOffering){
        this.myStudent = myStudent;
        this.myOffering = myOffering;
    }

    @Override
    public String getMessage() {
        Set<Course>passedCourses = myStudent.getEnrollment()
                .stream()
                .filter(en -> en.passed)
                .map(en -> en.courseOffering.getCourse())
                .collect(Collectors.toCollection(HashSet::new));
        Set<Course> requiredCourse = myOffering
                .getCourse()
                .prerequisiteList
                .stream()
                .filter(c -> myStudent.getWaivers().contains(c))
                .filter( c -> passedCourses.contains(c))
                .collect(Collectors.toCollection(HashSet::new));
        return "Missing required pre-requisites: "
                + requiredCourse.stream()
                .map(c -> c.name)
                .collect(Collectors.joining(","));
    }
}
