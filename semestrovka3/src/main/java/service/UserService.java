package service;

import entity.User;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class UserService {
    public void auth(User user, HttpServletRequest request, HttpServletResponse response){
        request.getSession().setAttribute("user", user);
    }
    public boolean isNoAnonymous(HttpServletRequest request, HttpServletResponse response){
        return request.getSession().getAttribute("user")!= null;
    }

    public User getUser(HttpServletRequest req, HttpServletResponse res) {
        return (User) req.getSession().getAttribute("user");
    }
}
