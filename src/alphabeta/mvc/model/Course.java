package alphabeta.mvc.model;

import java.util.List;

/**
 *
 */
class Course {

    private String name;
    private List<Course> prerequisiteList;
    private List<Topic> topics;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public List<Course> getPrerequisiteList() {
		return prerequisiteList;
	}
	public void setPrerequisiteList(List<Course> prerequisiteList) {
		this.prerequisiteList = prerequisiteList;
	}
	public List<Topic> getTopics() {
		return topics;
	}
	public void setTopics(List<Topic> topics) {
		this.topics = topics;
	}

}