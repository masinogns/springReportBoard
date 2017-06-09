package kr.ac.jejun.security;



import kr.ac.jejun.model.User;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * Created by masinogns on 2017. 6. 7..
 */
public class UserDetailsService extends org.springframework.security.core.userdetails.User {
    private String nick;

    public String getNick() {
        return nick;
    }

    public void setNick(String nick) {
        this.nick = nick;
    }

    public UserDetailsService(User user){
        super(user.getUserid(), user.getPassword(), authorities(user));
        this.nick = user.getNick();
    }

    private static Collection<? extends GrantedAuthority> authorities(User user) {
        List<GrantedAuthority> authorities = new ArrayList<>();

        authorities.add(new SimpleGrantedAuthority(user.getRole()));
        return authorities;
    }
}
