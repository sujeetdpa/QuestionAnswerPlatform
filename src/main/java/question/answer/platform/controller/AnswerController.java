package question.answer.platform.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import question.answer.platform.dto.TempAnswer;
import question.answer.platform.dto.TempComment;
import question.answer.platform.service.AnswerService;
import question.answer.platform.service.CommentService;

import javax.validation.Valid;

@RestController
@RequestMapping("/answer")
public class AnswerController {
    @Autowired
    private AnswerService answerService;
    @Autowired
    private CommentService commentService;

    @PostMapping("/add")
    public Long addAnswer(@Valid @RequestBody  TempAnswer tempAnswer){
        return answerService.addAnswer(tempAnswer).getId();

    }

    @PostMapping("/comment/add")
    public Long addComment(@Valid @RequestBody  TempComment tempComment){
        return commentService.addComment(tempComment).getId();
    }
    @PostMapping("/like")
    public void likeAnswer(@RequestParam("answerid") Long answerid, @RequestParam("userid") Long userid){
        answerService.likeAnswer(answerid,userid);
    }
}
