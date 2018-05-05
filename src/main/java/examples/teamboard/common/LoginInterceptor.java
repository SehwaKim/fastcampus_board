package examples.teamboard.common;

import examples.teamboard.domain.User;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;

public class LoginInterceptor extends HandlerInterceptorAdapter {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {

        HttpSession session = request.getSession();
        User user = (User)session.getAttribute("user");
        String currentPath = request.getServletPath();

        //TODO
        //회원정보 접근 필터처리 필요
        if(user == null){
            response.sendRedirect("/user/login?referer="+currentPath);
            return false;
        }
        return true;
    }

}
