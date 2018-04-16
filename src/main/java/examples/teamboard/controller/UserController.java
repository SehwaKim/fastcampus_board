package examples.teamboard.controller;

import examples.teamboard.domain.Board;
import examples.teamboard.domain.User;
import examples.teamboard.service.UserService;
import examples.teamboard.service.UserServiceImpl;
import examples.teamboard.util.SecureUtil;
import examples.teamboard.util.StringUtil;
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

    @GetMapping("/update")
    public String userUpdateForm(HttpSession session,ModelMap parameter) {
        User user = (User)session.getAttribute("user");
        if(user != null)
        {
            userService.getUserInfo(user);
            parameter.addAttribute("user",user);
            return "user/user_update";
        }else{
            return "redirect:/user/login";
        }
    }

    @PostMapping("/update")
    public String userUpdate(User user,HttpSession session) {

        if(StringUtil.isNotBlank(user.getPwd()))
        {
           user =  userService.updateUser(user);

        }else
        {
            user  =  userService.updateEmail(user);
            System.out.println("user: " + user.getEmail());
        }
        session.setAttribute("user",user);
        return "redirect:/boards";
    }

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
    public String loginForm(@RequestParam(name ="referer",required = false) String referer,ModelMap parametor) {
        parametor.addAttribute("referer",referer);
        return "user/user_login";
    }

    @PostMapping("/login")
    public String login(@RequestParam(name="referer",required = false) String referer,User user, HttpSession session , ModelMap parameter) {

        user.setPwd(SecureUtil.sha256Encoding((user.getPwd())));
        user = userService.longIn(user);

        if(user != null){
            user.setPwd(null);
            session.setAttribute("user",user);
        }
        else {
            parameter.addAttribute("visible","true");
            return "user/user_login";
        }
        if(StringUtil.isNotBlank(referer)){
            return "redirect:" + referer;
        }
        return "redirect:/boards";
    }

    @GetMapping("/logout")
    public String logout(@ModelAttribute User user, HttpSession session) {
        session.removeAttribute("user");
        return "redirect:/boards";
    }

    @GetMapping("/signup")
    public String signupForm() {
        return "user/user_signup";
    }

    @PostMapping("/signup")
    public String signup(@ModelAttribute User user,ModelMap parameter) {

        user.setPwd(SecureUtil.sha256Encoding((user.getPwd())));
        boolean result = userService.signUp(user);

        if(result == false) {
           //TODO
            //회원등록이 정상적으로 이루어 지지 않았습니다.(forward처리..)
            //return "error";
        }
        return "redirect:/user/login";
    }

    @GetMapping("/findid")
    public String findidForm() {
        return "user/user_findid";
    }
    

    @PostMapping("/findid")
    public String findid(@ModelAttribute User user,ModelMap parameter) {

        String id = userService.findId(user);
        if(id == null){
            parameter.addAttribute("result","err");
            return "user/user_findid";
        }else{
            parameter.addAttribute("title","아이디");
            parameter.addAttribute("result",id);
        }
        return "user/user_result";
    }

    @GetMapping("/findpwd")
    public String findpwdForm() {
        return "user/user_findpwd";
    }

    @PostMapping("/findpwd")
    public String findpwd(@ModelAttribute User user,ModelMap parameter) {

        System.out.println(user.getId()+":" + user.getEmail());
        String pwd = userService.changePwd(user);
        System.out.println(pwd);
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
