package question.answer.platform.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import question.answer.platform.model.Question;

@Repository
public interface QuestionRepository extends JpaRepository<Question,Long> {
}
