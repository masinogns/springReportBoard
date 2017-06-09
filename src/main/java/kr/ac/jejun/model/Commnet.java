package kr.ac.jejun.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 * Created by masinogns on 2017. 6. 9..
 */
@Entity
@Getter@Setter
@ToString
public class Commnet {

    @Id
    @GeneratedValue
    private int id;
    private String content;

    public Commnet() {
    }

    public Commnet(String content) {
        this.content = content;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
