package data.dto.mapper;

import data.dto.ETopic;
import data.model.Topic;

import java.util.ArrayList;

public class TopicListMapper {

    public ArrayList<Topic> map(ArrayList<ETopic> eTopics){
        ArrayList<Topic> topicList = new ArrayList<>();
        for(ETopic eTopic: eTopics){
            Topic topic = new Topic();
            topic.setId(eTopic.getId());
            topic.setName(eTopic.getName());
            topicList.add(topic);
        }
        return topicList;
    }
}
