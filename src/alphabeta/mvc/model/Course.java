package alphabeta.mvc.model;

import java.util.List;

/**
 *
 */
class Course {
    public String name;
    public List<Course> prerequisiteList;
    public List<Topic> topics;
}