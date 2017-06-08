package kr.ac.jejun.cotroller;

import kr.ac.jejun.model.Post;
import kr.ac.jejun.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

/**
 * Created by masinogns on 2017. 6. 8..
 */

@Controller
public class PostController {
    @Autowired
    private PostService postService;

    @RequestMapping({"/", "list"})
    public String list(ModelMap modelMap){
        List<Post> posts = postService.list();
        modelMap.addAttribute("postList", posts);
        return "list";
    }

    @RequestMapping("remove")
    public String remove(int id){
        postService.remove(id);
        return "redirect:list";
    }

    @RequestMapping("create")
    public String create(){
        return "create";
    }

    @RequestMapping(value = "register", method = RequestMethod.POST)
    public String register(Post post){
        postService.create(post);
        return "redirect:list";
    }

    @RequestMapping("edit")
    public String edit(int id, ModelMap modelMap){
        Post post = postService.get(id);
        modelMap.addAttribute("post", post);
        return "edit";
    }

    @RequestMapping("save")
    public String svae(Post post){
        postService.save(post);
        return "redirect:list";
    }

    @RequestMapping("detail")
    public String detail(int id, ModelMap modelMap){
        Post post = postService.get(id);
        modelMap.addAttribute("post", post);
        return "detail";
    }

}