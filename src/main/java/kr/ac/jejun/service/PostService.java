package kr.ac.jejun.service;

import kr.ac.jejun.model.Post;

import java.util.List;

/**
 * Created by masinogns on 2017. 6. 8..
 */
public interface PostService {
    List<Post> list();

    void remove(int id);

    void create(Post post);

    Post get(int id);

    void save(Post post);
}
