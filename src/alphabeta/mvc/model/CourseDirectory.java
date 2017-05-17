package alphabeta.mvc.model;


import alphabeta.mvc.systemDAL.FactoryDAO;
import alphabeta.mvc.systemDAL.ICourseOfferingDAO;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.HashSet;
import java.util.NoSuchElementException;
import java.util.Set;

/**
 * Last edit by kristin on 13/5/17
 */

public final class CourseDirectory {

    private static Logger logger = LogManager.getLogger();

    // singleton instance
    private static CourseDirectory instance = new CourseDirectory();
    private ICourseOfferingDAO courseOfferingDAO = FactoryDAO.courseOfferingDAO();
    private Set<Course> courseSet = new HashSet<>();
    private Set<Topic> topicSet = new HashSet<>();
    private Set<Student> studentSet = new HashSet<>();
    private Set<Lecturer> lecturerSet = new HashSet<>();
    private Semester semester = new Semester(01, 2017, 01);
    // private constructor
    private CourseDirectory(){}
    public static CourseDirectory getInstance() {
        return instance;
    }

    void addCourse(Course course) {
        courseSet.add(course);
    }

    void addTopic(Topic topic) {
        topicSet.add(topic);
    }

    void addStudent(Student student) {
        studentSet.add(student);
    }

    void addLecturer(Lecturer lecturer) {
        lecturerSet.add(lecturer);
    }

    CourseOffering getCourseOffering(Semester semester, int maxStudents, Lecturer lecturer, Course course) {
        return courseOfferingDAO.getCourseOffering(semester, maxStudents, lecturer, course);
    }

    Set<Course> getCourseSet() {
        return courseSet;
    }

    Set<Topic> getTopicSet() {
        return topicSet;
    }

    public Semester getSemester() { return semester; }

    Set<CourseOffering> getCourseOfferingSet() { return courseOfferingDAO.getCurrentOfferings(semester); }

    //Find a topic with a String
    Topic lookUpTopic(String s) {
        Topic topic = null;
        for (Topic t : topicSet) {
            if (s.equals(t.getNameOfTopic())) {
                topic = t;
            }
        }
        return topic;
    }

    //Find a course with a String
    Course lookupCourse(String s) {
        Course course = null;
        for (Course c : courseSet) {
            if (s.equals(c.getName())) {
                course = c;
            }
        }
        if (course == null)
            throw new UnsupportedOperationException("Course could not be found. Please try again");
        return course;
    }

    //Find a Student with studentID
    //Probably need to change exception type here
    public Student lookupStudent(String s) throws CourseException {
        Student student = null;
        for (Student st : studentSet) {
            if (s.equals(st.getStudentID())) {
                student = st;
            }
        }
        if (student == null)
            throw new CourseException("Student could not be found. Please try again.");
        return student;
    }

    //Find a CourseOffering with a String
    CourseOffering lookupCourseOffering(String name) throws NoSuchElementException {
        return courseOfferingDAO.lookupCourseOffering(name);
    }

    //Find a Lecturer with a String
    Lecturer lookupLecturer(String s) throws UnsupportedOperationException {
        Lecturer lecturer = null;
        for (Lecturer l : lecturerSet) {
            if (s.equals(l.getName())) {
                lecturer = l;
            }
        }
        if (lecturer == null)
            throw new UnsupportedOperationException("Lecturer could not be found. Please try again");
        return lecturer;
    }
}
