package alphabeta.mvc.model;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by dimz on 5/4/17.
 * Abstract declaration of user class
 */
abstract class User {

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

    public List<CourseOffering> viewCourseOffereings() {
        return new LinkedList<>();
    }

}