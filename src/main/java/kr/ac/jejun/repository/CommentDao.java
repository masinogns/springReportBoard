package kr.ac.jejun.repository;

import kr.ac.jejun.model.Comment;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by masinogns on 2017. 6. 14..
 */
public interface CommentDao extends CrudRepository<Comment, Integer>{
}
