package kr.ac.jejun.repository;


import kr.ac.jejun.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

/**
 * Created by masinogns on 2017. 6. 7..
 */
@Repository
public interface UserDao extends JpaRepository<User, Long>{
    public User findByUserid(String userid);

    @Query("select a from User a where a.userid = ?#{ principal.Username }")
    User findMe();
    
}
