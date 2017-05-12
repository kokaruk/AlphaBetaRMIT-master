package alphabeta.mvc.model;
/**
 *
 * Last edited by Kristin on 12/5/17
 *
 */

import java.util.HashSet;
import java.util.Set;

public class CourseDirectory {
	
	private static Set<Course> courseSet = new HashSet<>();
	private static Set<Topic> topicSet = new HashSet<>();
	
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

}
