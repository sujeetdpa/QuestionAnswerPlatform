package question.answer.platform.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import question.answer.platform.dao.AnswerRepository;
import question.answer.platform.dao.QuestionRepository;
import question.answer.platform.model.Answer;
import question.answer.platform.model.Question;
import question.answer.platform.dto.TempAnswer;
import question.answer.platform.model.User;

import javax.transaction.Transactional;

@Service
public class AnswerService {
    @Autowired
    private AnswerRepository answerRepository;
    @Autowired
    private QuestionService questionService;
    @Autowired
    private UserService userService;
    @Autowired
    private  QuestionRepository questionRepository;

    @Transactional
    public Answer addAnswer(TempAnswer tempAnswer) {
        User user=userService.findById(tempAnswer.getUserid());
        Answer answer=new Answer();
        answer.setText(tempAnswer.getText());
        answer.setUser(user);
        answer=answerRepository.save(answer);
        Question question=questionService.findById(tempAnswer.getQuestionid());
        question.getAnswers().add(answer);
        return (answer);

    }
    public Answer findById(Long id){;
        return answerRepository.findById(id).orElseThrow(()->new IllegalStateException("Answer not found with id: "+id));
    }
    @Transactional
    public void likeAnswer(Long answerid, Long userid) {
        Answer answer=this.findById(answerid);
        User user=userService.findById(userid);
        answer.getLikes().add(user);
    }
}
