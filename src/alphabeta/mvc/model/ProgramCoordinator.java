package alphabeta.mvc.model;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

/**
 * Last edited by Kristin on 14/5/17
 */

public class ProgramCoordinator extends Staff {

    private CourseDirectory courseDirectory = ModelHelper.getCourseDirectory();

    public ProgramCoordinator(String name, String password, int ID) {
        super(name, password, ID);
    }

    public Course addNewCourse(String courseName, List<String> prerequisites, List<String> topics, int week) throws CourseException {
        Set<Course> allCourses = courseDirectory.getCourseSet();
        Set<Topic> allTopics = courseDirectory.getTopicSet();
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
          //  if (!(prerequisites.size() == courseList.size())) {
          //      throw new CourseException("Error - Prerequisite not found in course list. " +
          //              "Prerequisite must be an existing course. Please try again.");
          //  }
            for (Topic z : allTopics) {
                stringTopics.add(z.getNameOfTopic());
            }
            stringTopics.retainAll(topics);
            for (String f : stringTopics) {
                Topic exists = courseDirectory.lookUpTopic(f);
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
        Course newCourse = new Course(courseName, courseList, topicsConvert);
        System.out.println("Topic created");
        return newCourse;
    }

    public void grantWaivers(String studentID, String waiverString) {
        //lookup Student
        try {
            Student st = courseDirectory.lookupStudentByID(studentID);
            //find waiver in directory
            try {
                Course c = courseDirectory.lookupCourse(waiverString);
                st.setWaivers(c);
                System.out.println("Waiver for " + c.getName() + " added for " + st.getName() + " (student ID: "
                        + st.getId() + ").");
            }
            catch (UnsupportedOperationException e) {
                System.out.println(e.getMessage());
            }
        }
        catch (CourseException | SQLException | NumberFormatException e) {
            System.out.println(e.getMessage());
        }
    }


    public void increaseLoad(String studentID, int load) {
        // Change Student's max course load
        try {
            Student s = courseDirectory.lookupStudentByID(studentID);
            s.setMaxCurrentCourseLoad(load);
            System.out.println("Course load for " + s.getName() + " (student ID: " + s.getId() + ") is "
                    + s.getMaxCurrentCourseLoad());
        }
        catch (CourseException | SQLException | NumberFormatException e) {
            System.out.println(e.getMessage());
        }
    }


}