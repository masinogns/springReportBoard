package kr.ac.jejun.repository;

import kr.ac.jejun.model.Post;
import kr.ac.jejun.model.PostCategory;
import kr.ac.jejun.model.User;
import org.springframework.context.annotation.Bean;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by masinogns on 2017. 6. 8..
 */
@Repository
public interface PostDao extends JpaRepository<Post, Integer> {
    public List<Post> findByPostCategory(PostCategory postCategory, Pageable pageable);
    public List<Post> findByUser(User user);
//    List<Post> findByUserid(Long id);
}
