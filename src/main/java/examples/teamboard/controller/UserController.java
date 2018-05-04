package examples.teamboard.controller;

import examples.teamboard.common.CommonCategory;
import examples.teamboard.domain.User;
import examples.teamboard.service.UserService;
import examples.teamboard.util.StringUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import javax.servlet.http.HttpSession;
import java.util.*;

@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    UserService userService;

    @ModelAttribute("userCategories")
    public List<CommonCategory> categories() {
      List<CommonCategory> list = new ArrayList<>();
      list.add(new CommonCategory("회원정보수정","update"));
      list.add(new CommonCategory("비밀번호변경","updatePwd"));
      return list;
    }

    @PostMapping("/checkid")
    @ResponseBody
    public String checkId(User user)
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

    @GetMapping("/update")
    public String userUpdateForm(HttpSession session,ModelMap parameter) {
        User user = (User)session.getAttribute("user");
        return "user/user_update";
    }

    @PostMapping("/update")
    public String userUpdate(User user,HttpSession session) {

        session.setAttribute("user",user);
        userService.updateUser(user);
        return "redirect:/user/update";
    }

    @GetMapping("/updatePwd")
    public String pwdUpdateForm(HttpSession session,ModelMap parameter) {
        User user = (User)session.getAttribute("user");
        return "user/user_uppwd";
    }
    @PostMapping("/updatePwd")
    public String pwdUpdate(User user,HttpSession session) {
        String userId  = ((User)session.getAttribute("user")).getId();

        userService.updatePwd(userId,user.getPwd());
        return "redirect:/user/logout";
    }


    @GetMapping("/login")
    public String loginForm(@RequestParam(name ="referer",required = false) String referer,ModelMap parametor) {
        parametor.addAttribute("referer",referer);
        return "user/user_login";
    }

    @PostMapping("/login")
    public String login(@RequestParam(name="referer",required = false) String referer,User user, HttpSession session , ModelMap parameter) {

        user = userService.longIn(user);

        if(user != null){
            user.setPwd(null);
            session.setAttribute("user",user);
        }
        else {
            parameter.addAttribute("visible","true");
            return "user/user_login";
        }
        if(StringUtil.isNotBlank(referer)){ //이전경로가 있을 때
            return "redirect:" + referer; //이전경로로 refer...
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
        int result = userService.signUp(user);

        if(result == 0) {
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

        String pwd = userService.changeTempPwd(user);
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
