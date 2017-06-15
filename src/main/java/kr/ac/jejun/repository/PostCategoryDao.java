package kr.ac.jejun.repository;

import kr.ac.jejun.model.PostCategory;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by masinogns on 2017. 6. 9..
 */
@Repository
public interface PostCategoryDao extends CrudRepository<PostCategory, Integer> {

}
