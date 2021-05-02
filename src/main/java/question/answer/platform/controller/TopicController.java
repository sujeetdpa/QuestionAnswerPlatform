package question.answer.platform.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import question.answer.platform.model.Topic;
import question.answer.platform.service.TopicService;

import java.util.List;

@RestController
@RequestMapping("/topic")
public class TopicController {
    @Autowired
    private TopicService topicService;

    @GetMapping("/{id}")
    public Topic getTopic(@PathVariable Long id){
        return topicService.getTopic(id);
    }

    @GetMapping("/all")
    public List<Topic> getTopics(){
        return topicService.getTopics();
    }
    @PostMapping("/add")
    public Topic addTopic(@RequestBody Topic topic){
        return  topicService.addTopic(topic);
    }
    @PutMapping("/update/{id}")
    public Topic updateTopic(@PathVariable Long id,@RequestBody Topic topic){
        return topicService.updateTopic(id,topic);
    }
    @DeleteMapping("/delete/{id}")
    public String deleteTopic(@PathVariable Long id){
        return topicService.deleteTopic(id);
    }
}
