package kr.ac.jejun.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotEmpty;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by masinogns on 2017. 6. 7..
 */
@Entity
@Getter
@Setter
@ToString
public class User {
    @Id
    @GeneratedValue
    private Long id;

    @Column(unique = true)
    private String userid;
    @Column(name = "password")
    @Length(min = 6, message = "*당신의 비밀번호는 최소 6자 이상이여야 합니다")
    @NotEmpty(message = "*비밀번호를 입력해주세요")
    private String password;

    private String role;
    private String nick;

    public User() {

    }

    public User(String userid, String password, String role, String nick) {
        this.userid = userid;
        this.password = password;
        this.role = role;
        this.nick = nick;
    }



    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUserid() {
        return userid;
    }

    public void setUserid(String userid) {
        this.userid = userid;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getNick() {
        return nick;
    }

    public void setNick(String nick) {
        this.nick = nick;
    }

}
