package question.answer.platform.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import question.answer.platform.dto.FilteredQuestion;
import question.answer.platform.model.Question;
import question.answer.platform.dto.TempFilterQuestion;
import question.answer.platform.dto.TempQuestion;
import question.answer.platform.service.QuestionService;

import javax.validation.Valid;
import java.util.Set;

@RestController
@RequestMapping("/question")
public class QuestionController {
    @Autowired
    private QuestionService questionService;
    @PostMapping("/add")
    public Long addQuestion(@Valid @RequestBody TempQuestion tempQuestion){
        return questionService.addQuestion(tempQuestion).getId();
    }

    @GetMapping("/{id}")
    public Question getQuestion(@PathVariable Long id){
        return questionService.getQuestion(id);
    }

    @PostMapping("/like")
    public void likeQuestion(@RequestParam("questionid") Long questionid,@RequestParam("userid") Long userid){
        questionService.likeQuestion(questionid,userid);
    }
    @GetMapping("/filter")
    public Set<FilteredQuestion> filterQuestion(@RequestBody TempFilterQuestion tempFilterQuestion){
        return  questionService.filterQuestion(tempFilterQuestion);
    }

}
