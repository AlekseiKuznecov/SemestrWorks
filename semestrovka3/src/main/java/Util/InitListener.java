package Util;

import Util.ConnectionProvider;
import Util.DbException;
import dao.CarDao;
import dao.UserDao;
import service.UserService;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

@WebListener
public class InitListener implements ServletContextListener {
    @Override
    public void contextInitialized(ServletContextEvent servletContextEvent) {
        try {
            ConnectionProvider connectionProvider = ConnectionProvider.getInstance();
            servletContextEvent.getServletContext().setAttribute("carDao",new CarDao(connectionProvider));
            servletContextEvent.getServletContext().setAttribute("userDao", new UserDao(connectionProvider));
            servletContextEvent.getServletContext().setAttribute("userService", new UserService());
        } catch (DbException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void contextDestroyed(ServletContextEvent servletContextEvent) {}
}
