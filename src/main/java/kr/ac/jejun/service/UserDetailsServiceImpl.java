package kr.ac.jejun.service;


import kr.ac.jejun.repository.UserDao;
import kr.ac.jejun.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

/**
 * Created by masinogns on 2017. 6. 7..
 */
@Service
public class UserDetailsServiceImpl implements org.springframework.security.core.userdetails.UserDetailsService {
    @Autowired
    UserDao accountRepository;

    @Override
    public UserDetails loadUserByUsername(String userid) throws UsernameNotFoundException {
        User user = accountRepository.findByUserid(userid);
        if (user == null){
            throw new UsernameNotFoundException(userid);
        }
        return new UserDetailsService(user);
    }
}
