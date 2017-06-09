package kr.ac.jejun.model;

import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotEmpty;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 * Created by masinogns on 2017. 6. 7..
 */
@Entity
public class Account {
    @Id
    @GeneratedValue
    private Long id;

    @Column(unique = true)
    private String userid;
    @Column(name = "password")
    @Length(min = 6, message = "*당신의 비밀번호는 최소 6자 이상이여야 합니다")
    @NotEmpty(message = "*비밀번호를 입력해주세요")
    private String password;

    //이 부분은 나중에 enum과 일대다로 빼든지하는 작업이 필요할 것으로 보인다고 한다
    // 시큐리티 튜토리얼이라서 간단하게 작업하는 것을 명심
    private String role;
    private String nick;

    public Account() {
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

    @Override
    public String toString() {
        return "Account [id="+id+", userid="+userid+", password="+password+", role="+role+", nick="+nick+"]";
    }
}
