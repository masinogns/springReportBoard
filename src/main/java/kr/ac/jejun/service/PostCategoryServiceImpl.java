package kr.ac.jejun.service;

import kr.ac.jejun.repository.PostCategoryDao;
import kr.ac.jejun.model.PostCategory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by masinogns on 2017. 6. 9..
 */
@Service
public class PostCategoryServiceImpl implements PostCategoryService{
    @Autowired
    PostCategoryDao postCategoryDao;

    @Override
    public List<PostCategory> list() {
        return (List<PostCategory>)postCategoryDao.findAll();
    }

    @Override
    public void remove(int id) {
        postCategoryDao.delete(id);
    }

    @Override
    public void create(PostCategory postCategory) {
        postCategoryDao.save(postCategory);
    }

    @Override
    public PostCategory get(int id) {
        return postCategoryDao.findOne(id);
    }

    @Override
    public void save(PostCategory postCategory) {
        postCategoryDao.save(postCategory);
    }
}
