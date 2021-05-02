package question.answer.platform.model;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.*;

@Entity
public class Question {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotNull
    @Size(min = 50,max =500)
    private String text;

    @Temporal(TemporalType.DATE)
    private Date entryDate=new Date();
    //many to many
    @ManyToMany(cascade = CascadeType.ALL)
    private Set<Company> companies=new HashSet<>();
    //one to many
    @OneToMany(cascade = CascadeType.ALL)
    private List<Answer> answers=new ArrayList<>();
    //one to many
    @ManyToMany(cascade = CascadeType.ALL)
    private Set<User> likes=new HashSet<>();
    //one to many
    @ManyToMany()
    private Set<Tag> tags=new HashSet<>();
    //many to one
    @ManyToOne(cascade = CascadeType.ALL)
    private SubTopic subTopic;
    //many to one
    @ManyToOne(cascade = CascadeType.ALL)
    private User user;
    @Transient
    private transient Topic topic;

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

    public List<Answer> getAnswers() {
        return answers;
    }

    public void setAnswers(List<Answer> answers) {
        this.answers = answers;
    }

    public Set<User> getLikes() {
        return likes;
    }

    public void setLikes(Set<User> likes) {
        this.likes = likes;
    }

    public Set<Tag> getTags() {
        return tags;
    }

    public void setTags(Set<Tag> tags) {
        this.tags = tags;
    }

    public SubTopic getSubTopic() {
        return subTopic;
    }

    public void setSubTopic(SubTopic subTopic) {
        this.subTopic = subTopic;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Date getEntryDate() {
        return entryDate;
    }

    public void setEntryDate(Date entryDate) {
        this.entryDate = entryDate;
    }

    public Topic getTopic() {
        return subTopic.getTopic();
    }

    public void setTopic(Topic topic) {
        this.topic = topic;
    }

    @Override
    public String toString() {
        return "Question{" +
                "id=" + id +
                ", text='" + text + '\'' +
                ", entryDate=" + entryDate +
                ", companies=" + companies +
                ", answers=" + answers +
                ", likes=" + likes +
                ", tags=" + tags +
                ", subTopic=" + subTopic +
                ", user=" + user +
                '}';
    }
}
