package data.dto.mapper;

import data.dto.ETopic;
import data.model.Topic;
import interfaces.ArrayListMapping;

import java.util.ArrayList;

public class TopicListMapper implements ArrayListMapping<Topic, ETopic> {

    @Override
    public ArrayList<Topic> map(ArrayList<ETopic> arrayList) {
        ArrayList<Topic> topicList = new ArrayList<>();
        for(ETopic eTopic: arrayList){
            Topic topic = new Topic();
            topic.setId(eTopic.getId());
            topic.setName(eTopic.getName());
            topicList.add(topic);
        }
        return topicList;
    }
}
