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


	// Two test, doing exactly the same thing!!!
    // Testing total count of topic class instances.
    // Do we need to know this?
    // Topic Card is not set in test criteria.
	/*
	@Test
	public void testTopicString() {
		Topic topic1 = new Topic("Unified Modelling Language");
		System.out.println("The name of the topic is " + topic1.getNameOfTopic());
		assertEquals("Unified Modelling Language",topic1.getNameOfTopic() );
	}

	@Test
	public void testTopic() {
		int nowNumberOfTopics = Topic.numberOfTopics;
		Topic topic2 = new Topic();
		System.out.println("The number of the topics is " + Topic.numberOfTopics);
		System.out.println("The name of the topic is " + topic2.getNameOfTopic());
		assertEquals(nowNumberOfTopics + 1, Topic.numberOfTopics);
	}
	*/

	@Test
	public void testSetAndGetName() {
		Topic topic3 = new Topic("Java Programming");
		assertEquals("Java Programming", topic3.getNameOfTopic());
	}
}
