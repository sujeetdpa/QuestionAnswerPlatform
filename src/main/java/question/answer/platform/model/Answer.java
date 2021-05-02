package question.answer.platform.model;

import javax.persistence.*;
import java.util.*;

@Entity
public class Answer implements Comparator {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String text;
    @ManyToOne(cascade = CascadeType.ALL)
    private User user;
    @OneToMany(cascade = CascadeType.ALL)
    private List<Comment> comments=new ArrayList<>();
    @ManyToMany
    private Set<User> likes=new HashSet<>();

    public Set<User> getLikes() {
        return likes;
    }

    public void setLikes(Set<User> likes) {
        this.likes = likes;
    }

    public List<Comment> getComments() {
        return comments;
    }

    public void setComments(List<Comment> comments) {
        this.comments = comments;
    }

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

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @Override
    public int compare(Object o1, Object o2) {
      Answer answer1= (Answer) o1;
      Answer answer2= (Answer) o2;
      if(answer1.getLikes().size()<answer2.getLikes().size())
          return -1;
      else if(answer1.getLikes().size()>answer2.getLikes().size())
        return 1;
      else
          return 0;
    }
}

