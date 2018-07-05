package data.dto.mapper;

import data.dto.ETopic;
import data.model.Topic;
import interfaces.Mapping;

public class TopicMapper implements Mapping<Topic, ETopic> {

    @Override
    public Topic map(ETopic item) {
        Topic topic = new Topic();
        topic.setId(item.getId());
        topic.setName(item.getName());
        return topic;
    }
}
