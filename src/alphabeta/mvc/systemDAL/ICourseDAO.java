package alphabeta.mvc.systemDAL;

import alphabeta.mvc.model.Course;
import alphabeta.mvc.model.Topic;

import java.util.*;

/**
 * @author dimz
 * @since 18/5/17.
 */
public interface ICourseDAO {

    Course getNewCourse(String name);
    Course getNewCourse(String name, List<Course> prerequisiteList, List<Topic> topics);
    Set<Course> getCourseSet();
    //Find a course with a String
    Course lookupCourse(String s);
}
