package question.answer.platform.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import question.answer.platform.dao.CommentRepository;
import question.answer.platform.model.Answer;
import question.answer.platform.model.Comment;
import question.answer.platform.dto.TempComment;
import question.answer.platform.model.User;

import javax.transaction.Transactional;

@Service
public class CommentService {
    @Autowired
    private CommentRepository commentRepository;
    @Autowired
    private AnswerService answerService;
    @Autowired
    private UserService userService;

    @Transactional
    public Comment addComment(TempComment tempComment) {
        User user=userService.findById(tempComment.getUserid());
        Comment comment=new Comment();
        comment.setText(tempComment.getText());
        comment.setUser(user);
        comment=commentRepository.save(comment);
        Answer answer=answerService.findById(tempComment.getAnswerid());
        answer.getComments().add(comment);
        return comment;
    }
}
