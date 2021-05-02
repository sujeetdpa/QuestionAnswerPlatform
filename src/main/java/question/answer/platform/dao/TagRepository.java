package question.answer.platform.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import question.answer.platform.model.Tag;

import java.util.Optional;

@Repository
public interface TagRepository extends JpaRepository<Tag,Long> {
    public Optional<Tag> findByName(String name);
}
