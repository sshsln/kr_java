package servlets;

import model.Employee;
import services.EmployeeService;
import services.LoginService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class AddUserServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        if(req.getSession().getAttribute("session") != null){
            String session = (String) req.getSession().getAttribute("session");
            req.setAttribute("session", session);
            req.getRequestDispatcher("/pages/add-user.jsp").forward(req, resp);
        }
        super.doGet(req, resp);
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
                if(login.equals("admin")){
                    Employee newEmployee = new Employee(req);
                    EmployeeService employeeService = new EmployeeService();
                    employeeService.saveEmployee(newEmployee);
                }
                resp.addHeader("session",session);
                resp.sendRedirect(req.getContextPath() + "/lk");
            }

        }
    }
}
