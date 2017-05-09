package alphabeta.mvc.model;

import java.util.List;

/**
 *
 */
public class Course {
    public String name;
    public List<Course> prerequisiteList;
    public List<Topic> topics;

    public Course(){
        CourseDirectory.addCourse(this);
    }

    public Course(String name){
        this.name = name;
        CourseDirectory.addCourse(this);
    }

    public Course(String name, List<Course> prerequisiteList, List<Topic> topics) {
        this.name = name;
        this.prerequisiteList = prerequisiteList;
        this.topics = topics;
        CourseDirectory.addCourse(this);
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