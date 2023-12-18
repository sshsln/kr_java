package servlets;

import model.Employee;
import services.LoginService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class LKServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        if(req.getSession().getAttribute("session") != null){ // если сессия есть то прокидываем в параметр
            String session = (String) req.getSession().getAttribute("session");
            req.setAttribute("session", session);
            List<String> users = new ArrayList<>();
            users.add("aaaa");
            Employee e = new Employee();
            e.setLogin("test");
            Employee e1 = new Employee();
            e.setLogin("test1");
            req.setAttribute("users", users);
            req.getRequestDispatcher("/pages/lk.jsp").forward(req, resp);

            super.doGet(req, resp);
        } else {
            // если сессии нет, то на страницу авторизации
            resp.sendRedirect(req.getContextPath() + "/login");
        }

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        if (req.getSession().getAttribute("session") != null) {
            String session = (String) req.getSession().getAttribute("session");
            LoginService loginService = new LoginService();
            String login = loginService.getLoginBySession(session);
            if (login==null){
                resp.sendRedirect(req.getContextPath() + "/login");
            } else{
                resp.addHeader("session",session);
                resp.sendRedirect(req.getContextPath() + "/add-user");
            }


        }
    }
}
