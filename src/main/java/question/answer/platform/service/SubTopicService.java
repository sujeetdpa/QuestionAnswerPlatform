package question.answer.platform.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import question.answer.platform.dao.SubTopicRepository;
import question.answer.platform.model.SubTopic;
import question.answer.platform.model.Topic;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class SubTopicService {
    @Autowired
    private SubTopicRepository subTopicRepository;
    @Autowired
    private TopicService topicService;

    public SubTopic findById(Long id){
        return subTopicRepository.findById(id).orElseThrow(()->new IllegalStateException("Subtopic does not exist with id:"+id));
    }

    public SubTopic getSubTopic(Long id) {
        return findById(id);
    }

    public List<SubTopic> getSubTopics() {
        return subTopicRepository.findAll();
    }

    public SubTopic addSubTopic(SubTopic subTopic) {
        Topic topic=topicService.findById(subTopic.getTopic().getId());
        subTopic.setTopic(topic);
        return subTopicRepository.save(subTopic);
    }
    @Transactional
    public SubTopic updateSubTopic(Long id, SubTopic subTopic) {
        SubTopic sub=findById(id);
        sub.setName(subTopic.getName());
        return sub;
    }

    public String deleteSubTopic(Long id) {
        SubTopic sub=findById(id);
        subTopicRepository.deleteById(id);
        return  String.format("Successfully deleted SubTopic: %s of id: %s",sub.getName(),sub.getId());
    }
}
