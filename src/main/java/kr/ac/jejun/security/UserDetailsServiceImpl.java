package kr.ac.jejun.security;


import kr.ac.jejun.dao.AccountDao;
import kr.ac.jejun.model.Account;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

/**
 * Created by masinogns on 2017. 6. 7..
 */
@Service
public class UserDetailsServiceImpl implements UserDetailsService{
    @Autowired
    AccountDao accountRepository;

    @Override
    public UserDetails loadUserByUsername(String userid) throws UsernameNotFoundException {
        Account account = accountRepository.findByUserid(userid);
        if (account == null){
            throw new UsernameNotFoundException(userid);
        }
        return new UserDetailsImpl(account);
    }
}
