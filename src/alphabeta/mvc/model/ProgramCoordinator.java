package alphabeta.mvc.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

/**
 * Last edited by Kristin on 13/5/17
 */

public class ProgramCoordinator extends Staff {

    public ProgramCoordinator(String name, String password) {
        super(name, password);
    }

    public Course addNewCourse(String name, List<String> prerequisites, List<String> topics, int week) throws CourseException {
        Set<Course> allCourses = CourseDirectory.getCourseSet();
        Set<Topic> allTopics = CourseDirectory.getTopicSet();
        List<Course> courseList = new ArrayList<>();
        List<Topic> topicsConvert = new ArrayList<>();
        List<String> stringTopics = new ArrayList<>();
        //test for time limit to create courses
        if (week > 8) {
            throw new CourseException("Cannot create course this late in the Semester - please wait until next Semester.");
        }
        //test if prereq exists - if not throw error
        else {
            for (String preReq : prerequisites) {
                for (Course course : allCourses) {
                    if (preReq.equals(course.getName())) {
                        courseList.add(course);
                    }
                }
            }
            if (!(prerequisites.size() == courseList.size())) {
                throw new CourseException("Error - Prerequisite not found in course list. " +
                        "Prerequisite must be an existing course. Please try again.");
            }
            for (Topic z : allTopics) {
                stringTopics.add(z.getNameOfTopic());
            }
            stringTopics.retainAll(topics);
            for (String f : stringTopics) {
                Topic exists = CourseDirectory.lookUpTopic(f);
                topicsConvert.add(exists);
            }
            topics.removeAll(stringTopics);
            System.out.println();
            for (String w : topics) {
                Topic t = new Topic(w);
                System.out.println(t.getNameOfTopic() + " topic not found in directory - new topic " +
                        t.getNameOfTopic() + " created.");
                topicsConvert.add(t);
            }
        }
        Course newCourse = new Course(name, courseList, topicsConvert);
        return newCourse;
    }

    public void grantWaivers(int studentID, String waiverString) {
        //lookup Student
        try {
            Student st = CourseDirectory.lookupStudent(studentID);
            //find waiver in dictory
            try {
                Course c = CourseDirectory.lookupCourse(waiverString);
                st.setWaivers(c);
                System.out.println("Waiver " + c.getName() + " added for " + st.getName() + " (student ID: "
                        + st.getStudentID() + ").");
            }
            catch (UnsupportedOperationException e) {
                System.out.println(e.getMessage());
            }
        }
        catch (CourseException e) {
            System.out.println(e.getReason());
        }
    }


    public void increaseLoad(int studentID, int load) {
        // Change Student's max course load
        try {
            Student s = CourseDirectory.lookupStudent(studentID);
            s.setMaxCurrentCourseLoad(load);
            System.out.println("Course load for " + s.getName() + " (student ID: " + s.getStudentID() + ") is "
                    + s.getMaxCurrentCourseLoad());
        }
        catch (CourseException e) {
            System.out.println(e.getReason());
        }
    }


}