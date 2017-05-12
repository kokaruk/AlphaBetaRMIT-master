package alphabeta.mvc.model;

/**
 *
 * Last edited by Kristin on 12/5/17
 *
 */

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class ProgramCoordinator extends Staff {

        public ProgramCoordinator(String name, String password) {
            super(name, password);
        }

        public Course addNewCourse(String name, List<String> prerequisites, List<String> topics, int week ) throws CourseException {
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
                    throw new CourseException("Prerequisite error - cannot create course. " +
                            "Prerequisites must be existing courses. Please try again.");
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




        public void grantWaivers() {
            // TODO - implement alphabeta.mvc.model.ProgramCoordinator.grantWaivers
            throw new UnsupportedOperationException();
        }


        public void increaseLoad(int Student) {
            // TODO - implement alphabeta.mvc.model.ProgramCoordinator.increaseLoad
            throw new UnsupportedOperationException();
        }



    }