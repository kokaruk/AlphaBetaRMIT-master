package alphabeta.mvc.systemDAL;

import alphabeta.mvc.model.Topic;

import java.util.Set;

/**
 * @author dimz
 * @since 18/5/17.
 */
public interface ITopicDAO {
    Set<Topic> getTopicSet();
    void addTopic(Topic topic);
    Topic lookUpTopic(String s);
}
