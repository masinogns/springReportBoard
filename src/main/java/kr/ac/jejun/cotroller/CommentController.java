package kr.ac.jejun.cotroller;

import kr.ac.jejun.model.Comment;
import kr.ac.jejun.model.Post;
import kr.ac.jejun.repository.CommentDao;
import kr.ac.jejun.repository.PostDao;
import kr.ac.jejun.service.CommentService;
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
    CommentService commentService;

    @RequestMapping("create")
    public String create(){
        return "create";
    }

    @RequestMapping(value = "register", method = RequestMethod.POST)
    public String register(Comment comment){
        commentService.save(comment);
        return "redirect:/post/detail/?id="+commentService.get(comment);
    }

    @RequestMapping("remove")
    public String remove(int id){
        commentService.remove(id);
        return "redirect:/category/list";
    }

}
