package question.answer.platform.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import question.answer.platform.dao.TopicRepository;
import question.answer.platform.model.Topic;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class TopicService {
    @Autowired
    private TopicRepository topicRepository;
    public Topic findById(Long id){
       return topicRepository.findById(id).orElseThrow(()->new IllegalStateException("Topic does not exist with id:"+id));
    }

    public Topic getTopic(Long id) {
        return findById(id);
    }

    public List<Topic> getTopics() {
        return topicRepository.findAll();
    }

    public Topic addTopic(Topic topic) {
        return topicRepository.save(topic);
    }

    @Transactional
    public Topic updateTopic(Long id, Topic topic) {
        Topic top=findById(id);
        top.setName(topic.getName());
        return top;
    }

    public String deleteTopic(Long id) {
        Topic top=findById(id);
        topicRepository.deleteById(id);
        return String.format("Successfuly deleted topic: %s of id: %s",top.getName(),top.getId());
    }
}
