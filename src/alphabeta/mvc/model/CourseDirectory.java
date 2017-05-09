package alphabeta.mvc.model;

import java.util.HashSet;
import java.util.Set;

public class CourseDirectory {
	
	private static Set<Course> courseSet = new HashSet<Course>();
	private static Set<Topic> topicSet = new HashSet<Topic>();
	
	public static void addCourse(Course course) {
		courseSet.add(course);
	}
	
	public static void addTopic(Topic topic) {
		topicSet.add(topic);
	}
	
	public static Set<Course> getCourseSet() {
		return courseSet;
	}
	
	public static Set<Topic> getTopicSet() {
		return topicSet;
	}

}
