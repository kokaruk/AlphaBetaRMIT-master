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

    Set<Course> requiredCourse;
        //constructor
    PrerequisitesNotMetException(Set<Course> requiredCourse){
        this.requiredCourse = requiredCourse;
    }

    @Override
    public String getMessage() {
        return "Missing required pre-requisites: "
                + requiredCourse.stream()
                .map(c -> c.name)
                .collect(Collectors.joining(","));
    }
}
