package question.answer.platform.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import question.answer.platform.model.SubTopic;

@Repository
public interface SubTopicRepository extends JpaRepository<SubTopic,Long> {
}
