package servlets;

import model.Employee;
import services.LoginService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class LoginServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setAttribute("errorText", "");
        req.getRequestDispatcher("/pages/login.jsp").forward(req, resp);
        resp.setContentType("text/html");
        super.doGet(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getServletContext();
        Employee employee = new Employee(req);
        LoginService loginService = new LoginService();
        if(loginService.auth(employee.getLogin(), employee.getPassword())){
            loginService.logOut(employee.getLogin());
            String session = loginService.createSession(employee.getLogin());
            req.getSession().setAttribute("session", session);
            resp.addHeader("session",session);
            resp.sendRedirect(req.getContextPath() + "/lk");
        } else {
            req.setAttribute("errorText", "error login or pass");
            req.getRequestDispatcher("/pages/login.jsp").forward(req, resp);
            super.doPost(req, resp);
        }

    }
}
