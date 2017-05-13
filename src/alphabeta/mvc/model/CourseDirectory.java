package alphabeta.mvc.model;


import java.util.HashSet;
import java.util.Set;

/**
 * Last edit by kristin on 13/5/17
 */

public class CourseDirectory {

    private static Set<Course> courseSet = new HashSet<>();
    private static Set<Topic> topicSet = new HashSet<>();
    private static Set<Student> studentSet = new HashSet<>();
    private static Set<CourseOffering> courseOfferingSet = new HashSet<>();
    private static Set<Lecturer> lecturerSet = new HashSet<>();
    private static Semester semester = new Semester(01, 2017, 01);


    public static void addCourse(Course course) {
        courseSet.add(course);
    }

    public static void addTopic(Topic topic) {
        topicSet.add(topic);
    }

    public static void addStudent(Student student) {
        studentSet.add(student);
    }

    public static void addLecturer(Lecturer lecturer) {
        lecturerSet.add(lecturer);
    }

    public static void addCourseOffering(CourseOffering courseOffering) {
        courseOfferingSet.add(courseOffering);
    }

    public static Set<Course> getCourseSet() {
        return courseSet;
    }

    public static Set<Topic> getTopicSet() {
        return topicSet;
    }

    public static Semester getSemester() { return semester; }


    //Find a topic with a String
    public static Topic lookUpTopic(String s) {
        Topic topic = null;
        for (Topic t : topicSet) {
            if (s.equals(t.getNameOfTopic())) {
                topic = t;
            }
        }
        return topic;
    }

    //Find a course with a String
    public static Course lookupCourse(String s) {
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
    public static Student lookupStudent(int s) throws CourseException {
        Student student = null;
        for (Student st : studentSet) {
            if (s == st.getStudentID()) {
                student = st;
            }
        }
        if (student == null)
            throw new CourseException("Student could not be found. Please try again.");
        return student;
    }

    //Find a CourseOffering with a String
    public static CourseOffering lookupCourseOffering(String s) throws UnsupportedOperationException {
        CourseOffering courseOffering = null;
        for (CourseOffering co : courseOfferingSet) {
            if (s.equals(co.getName())) {
                courseOffering = co;
            }
        }
        if (courseOffering == null)
            throw new UnsupportedOperationException("Course Offering could not be found. Please try again");
        return courseOffering;
    }

    //Find a Lecturer with a String
    public static Lecturer lookupLecturer(String s) throws UnsupportedOperationException {
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
