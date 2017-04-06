package model;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by dimz on 5/4/17.
 * Abstract implementation of user class
 */
abstract class User {

    // readonly properties
    // name
    private String name;
    public String getName() {
        return name;
    }

    // username
    private String username;
    public String getUsername() {
        return username;
    }

    //constructor
    User(String name, String username){
        this.name = name;
        this.username = username;
    }

    public List<CourseOffering> viewCourseOffereings() {
        return new LinkedList<>();
    }

}