package alphabeta.mvc.model;


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
            List<Course> preReqsConvert = new ArrayList<Course>();
            List<Topic> topicsConvert = new ArrayList<Topic>();
            List<String> newTopics = new ArrayList<String>();
            boolean match = false;
            boolean match2 = true;
            //System.out.println("does this method even run");
            //test for time limit to create courses
            if (week > 8) {
                throw new CourseException("Cannot create course this late in the Semester - please wait until next Semester.");
            }
            //test if prereq exists - if not throw error
            else {
                for (String preReq : prerequisites) {
                    for (Course course : allCourses) {
                        while (match == false) {
                            if (preReq.equals(course.getName())) {
                                preReqsConvert.add(course);
                                match = true;
                            }
                            else {
                                throw new CourseException("Prerequisite does not exist - cannot create course");
                            }
                        }
                    }
                }
                //test if topic exists - if not create and notify
                for (Topic t : allTopics) {
                    for (String str : topics) {
                        if (str.equals(t.getNameOfTopic())) {
                            topicsConvert.add(t);
                            match2 = true;
                        }
                        else if (match2==false) {
                            newTopics.add(str);
                            match2 = true;
                        }
                    }
                    match2 = false;
                }
                //create new topics



                for (String s : newTopics) {
                    Topic t = new Topic(s);
                    System.out.println("Created new Topic " + t.getNameOfTopic() + " in Directory");
                    topicsConvert.add(t);
                }
                Course newCourse = new Course(name, preReqsConvert, topicsConvert);
                return newCourse;
            }
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