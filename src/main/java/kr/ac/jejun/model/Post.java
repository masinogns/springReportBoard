package kr.ac.jejun.model;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by masinogns on 2017. 6. 8..
 */
@Entity
public class Post {

    @Id
    @GeneratedValue
    private int id;
    private String subject;
    private String content;
    private Date regdate;
    @ManyToOne
    @JoinColumn(name = "postcategory_id")
    private PostCategory postCategory;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public PostCategory getPostCategory() {
        return postCategory;
    }

    public void setPostCategory(PostCategory postCategory) {
        this.postCategory = postCategory;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Date getRegdate() {
        return regdate;
    }

    public void setRegdate(Date regdate) {
        this.regdate = regdate;
    }

}
