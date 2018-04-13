package examples.teamboard.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/user")
public class UserController {
    
    //    로그인 페이지 이동
    @GetMapping("/login")
    public String loginForm() {
        
        return "user/user_login";
    }
    
    //    로그인 시도
    @PostMapping("/login")
    public String login() {
        
        return "redirect:/boards";
    }
    
    //    회원가입 페이지 이동
    @GetMapping("/signup")
    public String signupForm() {
        
        return "user/user_signup";
    }
    
    //    회원등록
    @PostMapping("/signup")
    public String signup() {
        
        return "redirect:/user/login";
    }
    
    //    아이디 찾기 페이지 이동
    @GetMapping("/findid")
    public String findidForm() {
        return "user/user_findid";
    }
    
    //    아이디 찾기
    @PostMapping("/findid")
    public String findid() {
        
        return "user/user_result";
    }
    
    //    비밀번호 찾기 페이지 이동
    @GetMapping("/findpw")
    public String findpwForm() {
        return "user/user_findpw";
    }
    
    //    비밀번호 찾기
    @PostMapping("/findpw")
    public String findpw() {
        
        return "user/user_result";
    }
    
}
