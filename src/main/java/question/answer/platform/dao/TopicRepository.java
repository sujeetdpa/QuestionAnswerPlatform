package question.answer.platform.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import question.answer.platform.model.Topic;

@Repository
public interface TopicRepository extends JpaRepository<Topic,Long> {
}
