package kr.ac.jejun.cotroller;

import kr.ac.jejun.model.Comment;
import kr.ac.jejun.model.Post;
import kr.ac.jejun.repository.CommentDao;
import kr.ac.jejun.repository.PostDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

/**
 * Created by masinogns on 2017. 6. 9..
 */
@Controller
@RequestMapping("/comment")
public class CommentController {
    @Autowired
    PostDao postDao;

    @Autowired
    CommentDao commentDao;

    @RequestMapping("create")
    public String create(){
        return "create";
    }

    @RequestMapping(value = "/post/details", method = RequestMethod.POST)
    public String postDetail(@RequestParam String id, Model model){
        Post post = postDao.findOne(Integer.parseInt(id));
        List<Comment> comments = commentDao.findByPost(post);

        model.addAttribute("post", post);
        model.addAttribute("replies", comments);

        return "/post/detail";

    }

}
