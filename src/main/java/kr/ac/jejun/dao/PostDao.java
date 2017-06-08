package kr.ac.jejun.dao;

import kr.ac.jejun.model.Post;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by masinogns on 2017. 6. 8..
 */
public interface PostDao extends CrudRepository<Post, Integer> {
}
