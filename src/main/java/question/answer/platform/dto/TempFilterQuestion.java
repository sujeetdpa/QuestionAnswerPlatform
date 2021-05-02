package question.answer.platform.dto;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class TempFilterQuestion {
    private List<Long> companies=new ArrayList<>();
    private List<Long> subtopics=new ArrayList<>();
    private Long likes;
    private Date date;
    private List<Long> tags=new ArrayList<>();

    public List<Long> getCompanies() {
        return companies;
    }

    public void setCompanies(List<Long> companies) {
        this.companies = companies;
    }

    public List<Long> getSubtopics() {
        return subtopics;
    }

    public void setSubtopics(List<Long> subtopics) {
        this.subtopics = subtopics;
    }

    public Long getLikes() {
        return likes;
    }

    public void setLikes(Long likes) {
        this.likes = likes;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public List<Long> getTags() {
        return tags;
    }

    public void setTags(List<Long> tags) {
        this.tags = tags;
    }
}
