package alphabeta.mvc.model;

import java.util.Set;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by dimz on 5/4/17.
 * Abstract declaration of user class
 * last edit by kristin 14/5/17
 */
abstract class User {

    private CourseDirectory courseDirectory = CourseDirectory.getInstance();

    // readonly properties
    // name
    private String name;
    // username
    private String username;

    //constructor
    User(String name, String username) {
        this.name = name;
        this.username = username;
    }

    public String getName() {
        return name;
    }

    public String getUsername() {
        return username;
    }

    public Set<CourseOffering> viewCourseOfferings() {
        Set<CourseOffering> courseOfferings = courseDirectory.getCourseOfferingSet();
        return courseOfferings;
    }

}