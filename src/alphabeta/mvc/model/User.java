package alphabeta.mvc.model;

import java.util.Set;

/**
 * Created by dimz on 5/4/17.
 * Abstract declaration of user class
 * last edit by kristin 14/5/17
 */
public abstract class User {

    private int ID;
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
    // database connection working
   // ID = String.format("%sS%04d", idNum);

    public String getId(){

        return String.format("%s%04d", this.getClass().getSimpleName().substring(0,2).toUpperCase(), ID);
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