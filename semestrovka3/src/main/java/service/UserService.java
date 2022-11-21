package service;

import dao.UserDao;
import entity.User;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.SQLException;
import java.util.List;

public class UserService {
    private static final UserDao userDao = new UserDao();
    public void auth(User user, HttpServletRequest request, HttpServletResponse response){
        request.getSession().setAttribute("user", user);
    }
    public boolean isNoAnonymous(HttpServletRequest request, HttpServletResponse response){
        return request.getSession().getAttribute("user")!= null;
    }

    public User getUser(HttpServletRequest req, HttpServletResponse res) {
        return (User) req.getSession().getAttribute("user");
    }
    public void save(User user) throws SQLException {
        userDao.save(user);
    }
    public List<User> getAllUsers() throws SQLException {
        return userDao.findAll();
    }
}
