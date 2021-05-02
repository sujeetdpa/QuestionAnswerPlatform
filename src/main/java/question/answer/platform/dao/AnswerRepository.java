package question.answer.platform.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import question.answer.platform.model.Answer;

@Repository
public interface AnswerRepository extends JpaRepository<Answer,Long> {
}
