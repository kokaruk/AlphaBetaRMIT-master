package alphabeta.mvc.systemDAL;

import alphabeta.mvc.model.Course;
import alphabeta.mvc.model.Topic;

import java.util.*;
/**
 * @author dimz
 * @since 18/5/17.
 */
public class CourseDAO_fake implements ICourseDAO {

    private Set<Course> courseSet = new HashSet<>();

    // singleton instance
    private static ICourseDAO instance;
    // private constructor
    private CourseDAO_fake() {
    }
    // lazy instantiation
    public static ICourseDAO getInstance() {
        if (instance == null) {
            instance = new CourseDAO_fake();
        }
        return instance;
    }

    @Override
    public Course getNewCourse(String name) {
        Course course = new Course(name);
        courseSet.add(course);
        return course;
    }
    @Override
    public Course getNewCourse(String name, List<Course> prerequisiteList, List<Topic> topics) {
        Course course = new Course(name, prerequisiteList, topics);
        courseSet.add(course);
        return course;
    }

    @Override
    public Set<Course> getCourseSet() {
        return courseSet;
    }


    @Override  //Find a course with a String
    public Course lookupCourse(String s) {
        return courseSet.stream()
                .filter(course -> s.equals(course.getName()))
                .findAny()
                .orElseThrow(() -> new UnsupportedOperationException("Course could not be found. Please try again"));
    }


}