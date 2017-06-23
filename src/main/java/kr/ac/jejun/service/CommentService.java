package kr.ac.jejun.service;

import kr.ac.jejun.model.Comment;
import kr.ac.jejun.model.Post;

import java.util.List;

/**
 * Created by masinogns on 2017. 6. 14..
 */
public interface CommentService {
    List<Comment> list(Post post);

    void save(Comment comment);

    void create(Comment comment);

    int get(Comment comment);


    void remove(int id);
}
