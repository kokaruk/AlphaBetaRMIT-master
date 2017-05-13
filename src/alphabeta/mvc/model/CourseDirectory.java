package alphabeta.mvc.model;


import java.util.HashSet;
import java.util.Set;

/**
 *
 * Last edited by Kristin on 13/5/17
 *
 */

public class CourseDirectory {
	
	private static Set<Course> courseSet = new HashSet<>();
	private static Set<Topic> topicSet = new HashSet<>();
	private static Set<Student> studentSet = new HashSet<>();
	
	public static void addCourse(Course course) {
		courseSet.add(course);
	}
	
	public static void addTopic(Topic topic) {
		topicSet.add(topic);
	}

	public static void addStudent(Student student) {
		studentSet.add(student);
	}
	
	public static Set<Course> getCourseSet() {
		return courseSet;
	}
	
	public static Set<Topic> getTopicSet() {
		return topicSet;
	}


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
	public static Student lookupStudent(int s) throws CourseException {
		Student student = null;
		for (Student st : studentSet) {
			if (s ==st.getStudentID()) {
				student = st;
			}
		}
		if (student == null)
			throw new CourseException("Student could not be found. Please try again.");
		return student;
	}

}
