package kr.ac.jejun.service;

import kr.ac.jejun.model.PostCategory;
import kr.ac.jejun.model.User;
import kr.ac.jejun.repository.PostDao;
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

    public List<Post> postList(PostCategory category){
        return (List<Post>)postDao.findByPostCategory(category);
    }

    @Override
    public List<Post> userList(User user) {
        return (List<Post>)postDao.findByUser(user);
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
