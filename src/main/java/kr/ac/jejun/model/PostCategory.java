package kr.ac.jejun.model;

import org.springframework.context.annotation.Bean;

import javax.persistence.*;
import java.util.List;

/**
 * Created by masinogns on 2017. 6. 9..
 */
@Entity
public class PostCategory {
    @Id
    @GeneratedValue
    private int id;
    private String name;
    @OneToMany(mappedBy = "postCategory")
    private List<Post> post;


    public List<Post> getPost() {
        return post;
    }

    public void setPost(List<Post> post) {
        this.post = post;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
