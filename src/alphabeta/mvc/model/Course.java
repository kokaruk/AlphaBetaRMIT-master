package alphabeta.mvc.model;

import java.util.List;

/**
 *
 */
public class Course {
    private CourseDirectory courseDirectory = ModelHelper.getCourseDirectory();
    public String name;
    public List<Course> prerequisiteList;
    public List<Topic> topics;

    public Course(String name){
        this.name = name;
    }

    public Course(String name, List<Course> prerequisiteList, List<Topic> topics) {
        this(name);
        this.prerequisiteList = prerequisiteList;
        this.topics = topics;
    }

    public void addPrerequisite(Course c){
        prerequisiteList.add(c);
    }

    public String getName() {
        return name;
    }

    public List<Course> getPrerequisiteList() {
        return prerequisiteList;
    }

    public List<Topic> getTopics() {
        return topics;
    }
}