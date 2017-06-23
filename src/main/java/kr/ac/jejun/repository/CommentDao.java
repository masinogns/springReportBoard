package kr.ac.jejun.repository;

import javafx.geometry.Pos;
import kr.ac.jejun.model.Comment;
import kr.ac.jejun.model.Post;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by masinogns on 2017. 6. 14..
 */
@Repository
public interface CommentDao extends JpaRepository<Comment, Integer> {
    public List<Comment> findByPost(Post post);
}
