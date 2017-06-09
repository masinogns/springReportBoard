package kr.ac.jejun.security;



import kr.ac.jejun.model.Account;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * Created by masinogns on 2017. 6. 7..
 */
public class UserDetailsImpl extends User{
    private String nick;

    public String getNick() {
        return nick;
    }

    public void setNick(String nick) {
        this.nick = nick;
    }

    public UserDetailsImpl(Account account){
        super(account.getUserid(), account.getPassword(), authorities(account));
        this.nick = account.getNick();
    }

    private static Collection<? extends GrantedAuthority> authorities(Account account) {
        List<GrantedAuthority> authorities = new ArrayList<>();

        authorities.add(new SimpleGrantedAuthority(account.getRole()));
        return authorities;
    }
}
