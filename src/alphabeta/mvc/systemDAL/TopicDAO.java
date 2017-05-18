package alphabeta.mvc.systemDAL;

import alphabeta.mvc.model.Topic;

import java.util.Set;

/**
 * @author dimz
 * @since 18/5/17.
 */
public class TopicDAO implements ITopicDAO {
    // singleton instance
    private static ITopicDAO instance;
    // private constructor
    private TopicDAO() {
    }
    // lazy instantiation
    public static ITopicDAO getInstance() {
        if (instance == null) {
            instance = new TopicDAO();
        }
        return instance;
    }

    @Override
    public Set<Topic> getTopicSet() {
        return null;
    }

    @Override
    public void addTopic(Topic topic) {

    }

    @Override
    public Topic lookUpTopic(String s) {
        return null;
    }
}
