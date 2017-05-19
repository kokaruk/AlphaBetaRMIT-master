package alphabeta.mvc.systemDAL;

import alphabeta.mvc.model.Topic;

import java.util.HashSet;
import java.util.Set;

/**
 * @author dimz
 * @since 18/5/17.
 */
public class TopicDAO_fake implements ITopicDAO {

    private Set<Topic> topicSet = new HashSet<>();

    // singleton instance
    private static ITopicDAO instance;
    // private constructor
    private TopicDAO_fake() {
        createTestTopics();
    }
    // lazy instantiation
    public static ITopicDAO getInstance() {
        if (instance == null) {
            instance = new TopicDAO_fake();
        }
        return instance;
    }

    @Override
    public Set<Topic> getTopicSet() {
        return topicSet;
    }

    @Override
    public void addTopic(Topic topic) {
        topicSet.add(topic);
    }

    @Override //Find a topic with a String
    public Topic lookUpTopic(String s) {
        return topicSet.stream()
                .filter(topic -> s.equals(topic.getNameOfTopic()))
                .findAny()
                .orElse(null);
    }

    public void createTestTopics() {
        Topic topic1 = new Topic("Agile");
        Topic topic2 = new Topic("Intro to JavaFX");
        Topic topic3 = new Topic("Agile vs Waterfall");
        Topic topic4 = new Topic("Sequence Diagrams");
        Topic topic5 = new Topic("UML diagrams");
        topicSet.add(topic1);
        topicSet.add(topic2);
        topicSet.add(topic3);
        topicSet.add(topic4);
        topicSet.add(topic5);


    }

}
