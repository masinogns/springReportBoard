package kr.ac.jejun.repository;

import kr.ac.jejun.model.Post;
import kr.ac.jejun.model.PostCategory;
import org.springframework.context.annotation.Bean;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

/**
 * Created by masinogns on 2017. 6. 8..
 */
public interface PostDao extends CrudRepository<Post, Integer> {
    public List<Post> findByPostCategory(PostCategory postCategory);
}
