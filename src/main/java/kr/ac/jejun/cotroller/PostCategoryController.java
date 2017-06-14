package kr.ac.jejun.cotroller;

import kr.ac.jejun.model.Post;
import kr.ac.jejun.model.PostCategory;
import kr.ac.jejun.service.PostCategoryService;
import kr.ac.jejun.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

/**
 * Created by masinogns on 2017. 6. 9..
 */
@Controller
@RequestMapping("/category")
public class PostCategoryController {
    @Autowired
    PostCategoryService postCategoryService;

    @Autowired
    PostService postService;

    @RequestMapping("list")
    public String list(ModelMap modelMap){
        List<PostCategory> posts = postCategoryService.list();
        modelMap.addAttribute("postList", posts);
        return "/category/list";
    }

    @RequestMapping("remove")
    public String remove(int id){
        postCategoryService.remove(id);
        return "redirect:/category/list";
    }

    @RequestMapping("create")
    public String create(){
        return "/category/create";
    }

    @RequestMapping(value = "register", method = RequestMethod.POST)
    public String register(PostCategory postCategory){
        postCategoryService.create(postCategory);
        return "redirect:/category/list";
    }

    @RequestMapping("edit")
    public String edit(int id, ModelMap modelMap){
        PostCategory post = postCategoryService.get(id);
        modelMap.addAttribute("post", post);
        return "/post/edit";
    }

    @RequestMapping("save")
    public String svae(PostCategory postCategory){
        postCategoryService.save(postCategory);
        return "redirect:/category/list";
    }

    @RequestMapping("detail")
    public String detail(int id, ModelMap modelMap){
        PostCategory postCategory = postCategoryService.get(id);
        List<Post> posts = postService.postList(postCategory);
        modelMap.addAttribute("postList", posts);
        return "/category/detail";
    }
}
