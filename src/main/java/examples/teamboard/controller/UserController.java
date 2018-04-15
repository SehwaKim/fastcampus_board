package examples.teamboard.controller;

import examples.teamboard.domain.User;
import examples.teamboard.service.UserService;
import examples.teamboard.service.UserServiceImpl;
import examples.teamboard.util.SecureUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    UserService userService;

    @PostMapping("/checkid")
    public@ResponseBody String checkId(User user, ModelAndView parameter)
    {
        boolean isExistId = userService.checkId(user);
        String returnVal = "no";
        if(isExistId == false){
            returnVal ="no";
        }else if(isExistId == true){
            returnVal ="yes";
        }
        return returnVal;
    }

    @GetMapping("/login")
    public String loginForm() {
        return "user/user_login";
    }
    @PostMapping("/login")
    public String login(@ModelAttribute User user, HttpSession session ,ModelMap parameter) {
        if(session.getAttribute("user") == null) {

            user.setPwd(SecureUtil.sha256Encoding((user.getPwd())));
            user = userService.longIn(user);

            if(user != null){
                session.setAttribute("user",user);
            }
            else
            {
                parameter.addAttribute("visible","true");
                return "user/user_login";
            }
        }
        return "redirect:/boards";
    }

    @GetMapping("/logout")
    public String logout(@ModelAttribute User user, HttpSession session) {
        session.removeAttribute("user");
        return "redirect:/boards";
    }

    //    회원가입 페이지 이동
    @GetMapping("/signup")
    public String signupForm() {
        return "user/user_signup";
    }
    
    //    회원등록
    @PostMapping("/signup")
    public String signup(@ModelAttribute User user,ModelMap parameter) {
        boolean result = false;
        user.setPwd(SecureUtil.sha256Encoding((user.getPwd())));
        result = userService.signUp(user);

        if(result == false) {
           //TODO
            //회원등록이 정상적으로 이루어 지지 않았습니다.(forward처리..)
            //return "error";
        }
        return "redirect:/user/login";
    }
    
    //    아이디 찾기 페이지 이동
    @GetMapping("/findid")
    public String findidForm() {
        return "user/user_findid";
    }
    
    //    아이디 찾기
    @PostMapping("/findid")
    public String findid(@ModelAttribute User user,ModelMap parameter) {
        String id;
        id = userService.findId(user);
        if(id == null){
            parameter.addAttribute("result","err");
            return "user/user_findid";
        }else{
            parameter.addAttribute("title","아이디");
            parameter.addAttribute("result",id);
        }
        return "user/user_result";
    }
    
    //    비밀번호 찾기 페이지 이동
    @GetMapping("/findpwd")
    public String findpwdForm() {
        return "user/user_findpwd"; //로그인패이지 재활용...
    }
    
    //    비밀번호 찾기
    @PostMapping("/findpwd")
    public String findpwd(@ModelAttribute User user,ModelMap parameter) {
        String pwd;
        pwd = userService.findPwd(user);
        if(pwd == null){
            parameter.addAttribute("result","err");
            return "user/user_findpwd";
        }else{
            parameter.addAttribute("title","임시 비밀번호");
            parameter.addAttribute("result",pwd);
        }
        return "user/user_result";
    }
}
