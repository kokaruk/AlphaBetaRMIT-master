package alphabeta.mvc.model;

/**
 * Created by Bill Thompson on 9/4/17.
 * Topic Class
 */

class Topic {

	// Define and initialize the class variables
    private String name ;
    
	// Declare and initialise the static variables
	public static int numberOfTopics = 0;
	
	// Construct a Topic with a particular name
	public Topic(String topicName){
		this.name = topicName;
		numberOfTopics++;
	}
	
	// Get the number of Topics
	public int getNumberOfTopics(){
		return numberOfTopics;
	}
	
	// Construct a Topic with a blank name
	public Topic(){
		numberOfTopics++;
	}
	
	// Set the name of the topic
	public void setName(String newName){
		this.name = newName;
	}
	
	// Get the name of the Topic
	public String getNameOfTopic(){
		return name;
	}
    
}