package kr.ac.jejun.service;

import kr.ac.jejun.model.Comment;
import kr.ac.jejun.model.Post;
import kr.ac.jejun.repository.CommentDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by masinogns on 2017. 6. 16..
 */
@Service
public class CommentServiceImpl implements CommentService{

    @Autowired
    CommentDao commentDao;

    @Override
    public List<Comment> list(Post post) {
        return (List<Comment>)commentDao.findByPost(post);
    }

    @Override
    public void save(Comment comment) {
        commentDao.save(comment);
    }

    @Override
    public void create(Comment comment) {
        commentDao.save(comment);
    }

    @Override
    public int get(Comment comment) {
        return comment.getPost().getId();
    }

    @Override
    public void remove(int id) {
        commentDao.delete(id);
    }
}
