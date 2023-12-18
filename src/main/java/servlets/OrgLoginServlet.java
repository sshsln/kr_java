package servlets;

import model.Organizer;
import services.LoginService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class OrgLoginServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        request.getRequestDispatcher("/pages/org_login.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String[] buttonTypes = request.getParameterValues("buttonType");
        if (buttonTypes != null && buttonTypes.length > 0) {
            String buttonType = buttonTypes[0];
            if ("organizerButton".equals(buttonType)) {
                request.getServletContext();
                Organizer organizer = new Organizer(request);
                LoginService loginService = new LoginService();
                if (loginService.orgAuth(organizer.getLogin(), organizer.getPassword())) {
                    loginService.logOut(organizer.getLogin());
                    String session = loginService.createSession(organizer.getLogin());
                    request.getSession().setAttribute("session", session);
                    response.addHeader("session", session);
                    response.sendRedirect(request.getContextPath() + "/organizer");
                } else {
                    request.setAttribute("errorText", "Неправильный логин или пароль. Повторите попытку входа.");
                    request.getRequestDispatcher("/pages/org_login.jsp").forward(request, response);
                    super.doPost(request, response);
                }
            } else if ("orgOptionsButton".equals(buttonType)) {
                response.sendRedirect(request.getContextPath() + "/org_options");
            } else {
                response.getWriter().println("Неопределенный тип кнопки");
            }
        }
    }
}