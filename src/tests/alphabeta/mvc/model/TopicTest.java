package alphabeta.mvc.model;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

/**
 * Created by Bill Thompson on 9/4/17.
 * Topic Class JUnit test
 */

public class TopicTest {

	@Before
	public void setUp() throws Exception {
	}

	@Test
	public void testTopicString() {
		int nowNumberOfTopics = Topic.numberOfTopics;
		Topic topic1 = new Topic("Unified Modelling Language");
		System.out.println("The number of the topics is " + Topic.numberOfTopics);
		System.out.println("The name of the topic is " + topic1.getNameOfTopic());
		assertEquals(nowNumberOfTopics + 1, Topic.numberOfTopics);
	}

	@Test
	public void testTopic() {
		int nowNumberOfTopics = Topic.numberOfTopics;
		Topic topic2 = new Topic();
		System.out.println("The number of the topics is " + Topic.numberOfTopics);
		System.out.println("The name of the topic is " + topic2.getNameOfTopic());
		assertEquals(nowNumberOfTopics + 1, Topic.numberOfTopics);
	}

	@Test
	public void testSetAndGetName() {
		Topic topic3 = new Topic();
		System.out.println("The number of the topics is " + Topic.numberOfTopics);
		System.out.println("The name of the topic is " + topic3.getNameOfTopic());
		System.out.println("Now setting the name!");
		topic3.setName("Java Programming");
		System.out.println("The name of the topic is now " + topic3.getNameOfTopic());
		assertEquals("Java Programming", topic3.getNameOfTopic());
	}
	
	@Test
	public void testTopicArray() {
		int nowNumberOfTopics = Topic.numberOfTopics;
		System.out.println("The number of the topics to start is " + nowNumberOfTopics);
		Topic[] topicArray = new Topic[3];
		topicArray[0] = new Topic("Unified Modelling Language");
		topicArray[1] = new Topic("Java Programming");
		topicArray[2] = new Topic("Software Engineering");
		System.out.println("The number of the topics is " + Topic.numberOfTopics);
		for (int i = 0; i < topicArray.length; i++)
			System.out.println("The name of the topic is " + topicArray[i].getNameOfTopic());
		assertEquals(nowNumberOfTopics + 3, Topic.numberOfTopics);
	}
	

}
