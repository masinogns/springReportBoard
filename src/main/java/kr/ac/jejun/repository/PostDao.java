package kr.ac.jejun.repository;

import kr.ac.jejun.model.Post;
import kr.ac.jejun.model.PostCategory;
import kr.ac.jejun.model.User;
import org.springframework.context.annotation.Bean;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by masinogns on 2017. 6. 8..
 */
@Repository
public interface PostDao extends CrudRepository<Post, Integer> {
    public List<Post> findByPostCategory(PostCategory postCategory);
    public List<Post> findByUser(User user);
//    List<Post> findByUserid(Long id);
}
