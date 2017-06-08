package kr.ac.jejun.service;

import kr.ac.jejun.dao.PostDao;
import kr.ac.jejun.model.Post;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by masinogns on 2017. 6. 8..
 */
@Service
public class PostServiceImpl implements PostService {

    @Autowired
    PostDao postDao;

    @Override
    public List<Post> list() {
        return (List<Post>)postDao.findAll();
    }

    @Override
    public void remove(int id) {
        postDao.delete(id);

    }

    @Override
    public void create(Post post) {
        postDao.save(post);
    }

    @Override
    public Post get(int id) {
        return postDao.findOne(id);
    }

    @Override
    public void save(Post post) {
        postDao.save(post);
    }
}
