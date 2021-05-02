package question.answer.platform.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import question.answer.platform.model.Comment;

@Repository
public interface CommentRepository extends JpaRepository<Comment,Long> {
}
