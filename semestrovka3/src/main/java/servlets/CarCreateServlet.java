package servlets;

import dao.CarDao;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpFilter;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/car/create")
public class CarCreateServlet extends HttpServlet {
    private CarDao carDao;

    @Override
    public void init(ServletConfig config) throws ServletException {
        super.init(config);
        carDao = (CarDao) getServletContext().getAttribute("carDao");
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            resp.getWriter().println("Edit car");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
