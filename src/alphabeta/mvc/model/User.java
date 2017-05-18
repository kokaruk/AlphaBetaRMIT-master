package alphabeta.mvc.model;

import java.util.Set;

/**
 * Created by dimz on 5/4/17.
 * Abstract declaration of user class
 * last edit by kristin 14/5/17
 */
public abstract class User {

    private Integer ID;
    private CourseDirectory courseDirectory = ModelHelper.getCourseDirectory();

    // readonly properties
    // name
    private String name;
    // username
    private String username;

    //constructor
    public User(String name, String username, int ID) {
        this.name = name;
        this.username = username;
        this.ID = ID;
    }


    public String getId(){
        String.format("%s%03d", this.getClass().getName().charAt(0), ID);
        return ID.toString();
    }

    public String getName() {
        return name;
    }

    public String getUsername() {
        return username;
    }

    public Set<CourseOffering> viewCourseOfferings() {
        return courseDirectory.getCourseOfferingSet();
    }

}