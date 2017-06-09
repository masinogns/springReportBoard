package kr.ac.jejun.service;

import kr.ac.jejun.model.Post;
import kr.ac.jejun.model.PostCategory;

import java.util.List;

/**
 * Created by masinogns on 2017. 6. 9..
 */
public interface PostCategoryService {
    List<PostCategory> list();

    void remove(int id);

    void create(PostCategory postCategory);

    PostCategory get(int id);

    void save(PostCategory postCategory);
}
