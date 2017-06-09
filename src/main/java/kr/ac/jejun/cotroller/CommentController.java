package kr.ac.jejun.cotroller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by masinogns on 2017. 6. 9..
 */
@Controller
@RequestMapping("/comment")
public class CommentController {
    @RequestMapping("create")
    public String create(){
        return "create";
    }
}
