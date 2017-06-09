package kr.ac.jejun.cotroller;


import kr.ac.jejun.dao.UserDao;
import kr.ac.jejun.model.User;
import kr.ac.jejun.security.UserDetailsService;
import kr.ac.jejun.service.HelloMessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by masinogns on 2017. 6. 7..
 */
@Controller
public class HomeContorller {
    @RequestMapping({"/", "index"})
    public String index(){
        return "index";
    }

    @RequestMapping("/admin")
    public String admin(){
        return "/account/admin";
    }

    @RequestMapping("/user")
    public String user(){
        return "/account/user";
    }

    @RequestMapping("/login")
    public String login(){
        return "/account/login";
    }

    @RequestMapping("registerForm")
    public String registerForm(){
        return "/account/registerForm";
    }

    //필요한 부분은 security 계층으로 옮겨줘야한다
    @Autowired
    UserDao accountRepository;

    @Autowired
    PasswordEncoder passwordEncoder;

    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public String register(User user){
        //회원 정보를 데이터베이스에 저장
        // 암호화하는 부분
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        accountRepository.save(user);

        //SecurityContextholder에서 Context를 받아 인증을 설정한다
        UserDetailsService userDetails = new UserDetailsService(user);
        Authentication authentication =
                new UsernamePasswordAuthenticationToken(userDetails, null, userDetails.getAuthorities());
        SecurityContextHolder.getContext().setAuthentication(authentication);
        return "redirect:/";
    }

    @RequestMapping("/getPrivateMessage")
    @PreAuthorize("(#user.userid==principal.Username) or hasRole('ADMIN')")
    public String authstring(User user, Model model){
        model.addAttribute("msg", "당신은 관리자이거나 요청 파라미터랑 아이디가 같습니다");
        return "authorizedMessage";
    }

    @RequestMapping("/getUserMessage")
    @PreAuthorize("hasRole('USER')")
    public String userMessage(User user, Model model){
        model.addAttribute("msg","당신은 유저입니다");
        return "authorizedMessage";
    }

    @RequestMapping("/403")
    public void accessdeniedPage(){}

    @RequestMapping("userinformation")
    public void userinformation(Model model){
        model.addAttribute("user", accountRepository.findMe());
    }

    @Autowired
    HelloMessageService helloMessageService;
    @RequestMapping("/message")
    @ResponseBody
    public String getMessage(){
        return helloMessageService.getMessage();
    }

}
