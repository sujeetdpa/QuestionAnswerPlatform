package question.answer.platform.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import question.answer.platform.dao.QuestionRepository;
import question.answer.platform.dto.FilteredQuestion;
import question.answer.platform.dto.TempFilterQuestion;
import question.answer.platform.dto.TempQuestion;
import question.answer.platform.model.*;

import javax.transaction.Transactional;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class QuestionService {
    @Autowired
    private SubTopicService subTopicService;
    @Autowired
    private CompanyService companyService;
    @Autowired
    private TagService tagService;
    @Autowired
    private UserService userService;
    @Autowired
    private QuestionRepository questionRepository;

    public Question findById(Long id){
        return questionRepository.findById(id).orElseThrow(()->new IllegalStateException("Question not found for id:"+id));
    }
    @Transactional
    public Question addQuestion(TempQuestion tempQuestion) {
        Question question=new Question();
        Set<Tag> tags=new HashSet<>();
        Company company=null;
        SubTopic subTopic=subTopicService.findById(tempQuestion.getSubtopicid());
        if(tempQuestion.getCompanyid()!=null){
        company=companyService.getCompany(tempQuestion.getCompanyid());
            question.setCompanies(Set.of(company));
        }
        if(!tempQuestion.getTags().isEmpty()){

            tags=tempQuestion.getTags().stream().map((tag)->tagService.findByName(tag)).collect(Collectors.toSet());
            question.setTags(tags);
        }

        User user=userService.findById(tempQuestion.getUserid());

        question.setText(tempQuestion.getText());

        question.setSubTopic(subTopic);

        question.setUser(user);
        question=questionRepository.save(question);

        return question;
    }

    public Question getQuestion(Long id) {
        Question question=findById(id);
        return question;
    }

    @Transactional
    public void likeQuestion(Long questionid, Long userid) {
        Question question=findById(questionid);
        User user=userService.findById(userid);
        question.getLikes().add(user);
    }

    public Set<FilteredQuestion> filterQuestion(TempFilterQuestion tempFilterQuestion) {
        List<Question> questions=questionRepository.findAll();
        if(!tempFilterQuestion.getCompanies().isEmpty()){
            Set<Company> companies=tempFilterQuestion.getCompanies().stream().map((com)->companyService.findById(com)).collect(Collectors.toSet());

            questions=questions.stream().filter(question -> {
                return  !question.getCompanies().stream().filter((company -> companies.contains(company))).collect(Collectors.toSet()).isEmpty();
            }).collect(Collectors.toList());
        }
        if(!tempFilterQuestion.getSubtopics().isEmpty()){
            Set<SubTopic> subTopics=tempFilterQuestion.getSubtopics().stream().map((st)->subTopicService.findById(st)).collect(Collectors.toSet());
            questions=questions.stream().filter(question -> subTopics.contains(question.getSubTopic())).collect(Collectors.toList());

        }
        if(!tempFilterQuestion.getTags().isEmpty()){
            Set<Tag> tags= tempFilterQuestion.getTags().stream().map((tag)->tagService.findById(tag)).collect(Collectors.toSet());
            System.out.println(tags);
            questions=questions.stream().filter(question -> {
                 return !question.getTags().stream().filter((tag)->tags.contains(tag)).collect(Collectors.toSet()).isEmpty();
            }).collect(Collectors.toList());
        }
        if(tempFilterQuestion.getDate()!=null){
            questions=questions.stream().filter(question -> question.getEntryDate().after(tempFilterQuestion.getDate())).collect(Collectors.toList());
        }
        if(tempFilterQuestion.getLikes()!=null){
            questions=questions.stream().filter(question -> (long)question.getLikes().size()>tempFilterQuestion.getLikes()).collect(Collectors.toList());
        }
        if(questions.isEmpty()){
            throw new IllegalStateException("No Record Found");
        }
        Set<FilteredQuestion> filteredQuestionSet=new HashSet<>();
        questions.forEach((question -> {
            FilteredQuestion filteredQuestion=new FilteredQuestion();
            filteredQuestion.setId(question.getId());
            filteredQuestion.setText(question.getText());
            filteredQuestion.setLikes((long) question.getLikes().size());
            filteredQuestion.setCompanies(question.getCompanies());
            filteredQuestion.setTags(question.getTags());
            List<Answer> answers=question.getAnswers();
            if(!answers.isEmpty()){
                answers.sort(new Answer());
                filteredQuestion.setAnswer(answers.get(answers.size()-1));
            }
            filteredQuestionSet.add(filteredQuestion);
        }));

        return filteredQuestionSet;
    }
}
