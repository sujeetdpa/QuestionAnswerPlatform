package question.answer.platform.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import question.answer.platform.dao.TagRepository;
import question.answer.platform.model.SubTopic;
import question.answer.platform.model.Tag;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class TagService {
    @Autowired
    private TagRepository tagRepository;

    public Tag findById(Long id){
        return tagRepository.findById(id).orElseThrow(()->new IllegalStateException("Subtopic does not exist with id:"+id));
    }

    public Tag getTag(Long id) {
        return findById(id);
    }

    public List<Tag> getTags() {
        return tagRepository.findAll();
    }

    public Tag addTag(Tag tag) {
        return tagRepository.save(tag);
    }

    @Transactional
    public Tag updateTag(Long id, Tag tag) {
        Tag t=findById(id);
        t.setName(tag.getName());
        return t;
    }

    public String deleteTag(Long id) {
        Tag t=findById(id);
        tagRepository.deleteById(id);
        return String.format("Successfully deleted Tag: %s of id: %s",t.getName(),t.getId());
    }
    public Tag findByName(String name){
        return tagRepository.findByName(name).orElseThrow(()->new IllegalStateException("Tag not found: "+name));
    }
}
