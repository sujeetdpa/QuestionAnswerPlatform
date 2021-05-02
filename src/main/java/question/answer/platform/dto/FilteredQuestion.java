package question.answer.platform.dto;

import question.answer.platform.model.Answer;
import question.answer.platform.model.Company;
import question.answer.platform.model.Tag;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class FilteredQuestion {
    private Long id;
    private String text;
    private Set<Company> companies=new HashSet<>();
    private Long likes;
    private Answer answer;
    private Set<Tag> tags=new HashSet<>();

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public Set<Company> getCompanies() {
        return companies;
    }

    public void setCompanies(Set<Company> companies) {
        this.companies = companies;
    }

    public Long getLikes() {
        return likes;
    }

    public void setLikes(Long likes) {
        this.likes = likes;
    }

    public Answer getAnswer() {
        return answer;
    }

    public void setAnswer(Answer answer) {
        this.answer = answer;
    }

    public Set<Tag> getTags() {
        return tags;
    }

    public void setTags(Set<Tag> tags) {
        this.tags = tags;
    }
}
