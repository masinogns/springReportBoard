package kr.ac.jejun.repository;

import javafx.geometry.Pos;
import kr.ac.jejun.model.Comment;
import kr.ac.jejun.model.Post;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

/**
 * Created by masinogns on 2017. 6. 14..
 */
public interface CommentDao extends CrudRepository<Comment, Integer>{
    public List<Comment> findByPost(Post post);
}
