package alphabeta.mvc.model;

/**
 * Created by Bill Thompson on 9/4/17.
 * Refactor by DK on 17/4/17
 * Edited by Kristin on 10/5/17
 * Topic Class
 */
public class Topic {
    private CourseDirectory courseDirectory = ModelHelper.getCourseDirectory();

    // Define and initialize the class variables
    private String myName;

    // Construct a Topic with a particular name
    public Topic(String topicName) {
        this.myName = topicName;
        courseDirectory.addTopic(this);
    }

    // Set the name of the topic
    public void setName(String newName) {
        this.myName = newName;
    }

    // Get the name of the Topic
    public String getNameOfTopic() {
        return myName;
    }

}