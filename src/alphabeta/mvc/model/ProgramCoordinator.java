package alphabeta.mvc.model;

/**
 *
 * Last edited by Kristin on 10/5/17
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
            List<Course> temp = new ArrayList<>();
            List<String> temp2 = new ArrayList<>();
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
                                temp.add(course);
                            }
                    }
                }
                if (!(prerequisites.size() == temp.size())) {
                    throw new CourseException("Prerequisite error - cannot create course. " +
                            "Prerequisites must be existing courses. Please try again.");
                }
                for (Topic z : allTopics) {
                    stringTopics.add(z.getNameOfTopic());
                }
                List<String> common = new ArrayList<>(stringTopics);
                List<String> notCommon = new ArrayList<>(prerequisites);

                common.retainAll(prerequisites);
                for (String k : common) {
                    System.out.println(common);
                }
                notCommon.removeAll(stringTopics);
                for (String x : notCommon) {
                    Topic newTopic = new Topic(x);
                    System.out.println("New topic " + newTopic.getNameOfTopic() + " created.");
                    topicsConvert.add(newTopic);
                }
                //this is broken
                for (String y: common) {
                    for (Topic t : allTopics) {
                        if (y.equals(t.getNameOfTopic())) {
                            topicsConvert.add(t);
                        }
                    }
                }
                }
                Course newCourse = new Course(name, temp, topicsConvert);
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