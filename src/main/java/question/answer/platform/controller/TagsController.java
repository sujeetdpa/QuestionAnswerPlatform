package question.answer.platform.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import question.answer.platform.model.SubTopic;
import question.answer.platform.model.Tag;
import question.answer.platform.service.TagService;

import javax.servlet.http.HttpServletResponse;
import java.util.List;

@RestController
@RequestMapping("/tag")
public class TagsController {
    @Autowired
    private TagService tagService;

    @GetMapping("/{id}")
    public Tag getTag(@PathVariable Long id){
        return tagService.getTag(id);
    }

    @GetMapping("/all")
    public List<Tag> getTags(){
        return tagService.getTags();
    }
    @PostMapping("/add")
    public Tag addTag(@RequestBody Tag tag){
        return  tagService.addTag(tag);
    }
    @PutMapping("/update/{id}")
    public Tag updateTag(@PathVariable Long id,@RequestBody Tag tag){
        return tagService.updateTag(id,tag);
    }
    @DeleteMapping("/delete/{id}")
    public String deleteTag(@PathVariable Long id, HttpServletResponse response){
        response.setStatus(200);
        return tagService.deleteTag(id);
    }
}
