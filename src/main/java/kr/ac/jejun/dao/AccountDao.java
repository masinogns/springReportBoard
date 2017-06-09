package kr.ac.jejun.dao;


import kr.ac.jejun.model.Account;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

/**
 * Created by masinogns on 2017. 6. 7..
 */
public interface AccountDao extends JpaRepository<Account, Long>{
    public Account findByUserid(String userid);

    @Query("select a from Account a where a.userid = ?#{ principal.Username }")
    Account findMe();
}
