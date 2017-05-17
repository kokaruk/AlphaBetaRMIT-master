package alphabeta.mvc.model;


import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Created by Bill Thompson on 9/4/17.
 * Topic Class JUnit test
 */

public class TopicTest {

	@Test
	public void testSetAndGetName() {
		Topic topic3 = new Topic("Java Programming");
		assertEquals("Java Programming", topic3.getNameOfTopic());
	}
}
