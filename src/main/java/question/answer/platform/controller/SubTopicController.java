package question.answer.platform.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import question.answer.platform.model.SubTopic;
import question.answer.platform.model.Topic;
import question.answer.platform.service.SubTopicService;

import javax.servlet.http.HttpServletResponse;
import java.util.List;

@RestController
@RequestMapping("/subtopic")
public class SubTopicController {
    @Autowired
    private SubTopicService subTopicService;

    @GetMapping("/{id}")
    public SubTopic getTopic(@PathVariable Long id){
        return subTopicService.getSubTopic(id);
    }

    @GetMapping("/all")
    public List<SubTopic> getTopics(){
        return subTopicService.getSubTopics();
    }

    @PostMapping("/add")
    public SubTopic addTopic( @RequestBody SubTopic SubTopic){
        return  subTopicService.addSubTopic(SubTopic);
    }

    @PutMapping("/update/{id}")
    public SubTopic updateTopic(@PathVariable Long id,@RequestBody SubTopic SubTopic){
        return subTopicService.updateSubTopic(id,SubTopic);
    }

    @DeleteMapping("/delete/{id}")
    public String deleteTopic(@PathVariable Long id){
        return subTopicService.deleteSubTopic(id);
    }

}
