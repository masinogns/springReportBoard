package kr.ac.jejun.service;

import kr.ac.jejun.model.Comment;
import kr.ac.jejun.model.Post;
import kr.ac.jejun.model.User;
import kr.ac.jejun.repository.CommentDao;
import kr.ac.jejun.repository.PostDao;
import kr.ac.jejun.repository.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by masinogns on 2017. 6. 15..
 */
@Controller
public class AjaxController {

    @Autowired
    private UserDao userDao;

    @Autowired
    private PostDao postDao;

    @Autowired
    private CommentDao commentDao;

    @RequestMapping(value = "/detail/commentAjax", method = RequestMethod.POST)
    @ResponseBody
    public Map<String, Object> commentAjax(@RequestBody Map<String, Object> params){
        Map<String, Object> resultMap = new HashMap<String, Object>();

        Long userId = Long.parseLong((String)params.get("user_id"));
        Integer postId = Integer.parseInt((String)params.get("post_id"));

        User user = userDao.findOne(userId);
        Post post = postDao.findOne(postId);

        Comment comment = new Comment();
        comment.setUser(user);
        comment.setPost(post);

        comment.setContent((String)params.get("content"));
        commentDao.save(comment);

        return resultMap;
    }
}
