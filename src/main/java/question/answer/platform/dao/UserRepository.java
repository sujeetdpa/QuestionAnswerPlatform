package question.answer.platform.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import question.answer.platform.model.User;

@Repository
public interface UserRepository extends JpaRepository<User,Long> {
}
