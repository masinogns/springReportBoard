package kr.ac.jejun.cotroller;

import kr.ac.jejun.model.Post;
import kr.ac.jejun.model.User;
import kr.ac.jejun.repository.UserDao;
import kr.ac.jejun.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

/**
 * Created by masinogns on 2017. 6. 8..
 */

@Controller
@RequestMapping("/post")
public class PostController {
    @Autowired
    private PostService postService;

    @Autowired
    private UserDao userDao;

    @RequestMapping({"/", "list"})
    public String list(String userid, ModelMap modelMap){
        User user = userDao.findByUserid(userid);
        List<Post> posts = postService.userList(user);
        modelMap.addAttribute("postList", posts);
        return "/post/list";
    }

    @RequestMapping("remove")
    public String remove(int id){
        postService.remove(id);
        return "redirect:/category/list";
    }

    @RequestMapping("create")
    public String create(int id, ModelMap modelMap){
        modelMap.addAttribute("category_id", id);
        return "/post/create";
    }

    @RequestMapping(value = "register", method = RequestMethod.POST)
    public String register(Post post){
        postService.create(post);
        return "redirect:/category/list";
    }

    @RequestMapping("edit")
    public String edit(int id, ModelMap modelMap){
        Post post = postService.get(id);
        modelMap.addAttribute("post", post);
        return "/post/edit";
    }

    @RequestMapping("save")
    public String svae(Post post){
        postService.save(post);
        return "redirect:/category/list";
    }

    @RequestMapping("detail")
    public String detail(int id, ModelMap modelMap){
        Post post = postService.get(id);
        modelMap.addAttribute("post", post);
        return "/post/detail";
    }

}
