package servlets;
import model.Organizer;
import services.LoginService;
import services.OrganizerService;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class OrgRegistrationServlet extends HttpServlet{
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute("errorText", "");
        response.setContentType("text/html;charset=UTF-8");
        request.getRequestDispatcher("/pages/org_registration.jsp").forward(request, response);
        super.doGet(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String[] buttonTypes = request.getParameterValues("buttonType");
        if (buttonTypes != null && buttonTypes.length > 0) {
            String buttonType = buttonTypes[0];
            if ("organizerButton".equals(buttonType)) {
                Organizer newOrganizer = new Organizer(request);
                if (newOrganizer.getLogin() == null || newOrganizer.getLogin().trim().isEmpty() || newOrganizer.getOrg_name() == null || newOrganizer.getOrg_name().trim().isEmpty() || newOrganizer.getPassword() == null || newOrganizer.getPassword().trim().isEmpty()) {
                    request.setAttribute("errorText", "Error registration. Please fill in all field.");
                    request.getRequestDispatcher("/pages/org_registration.jsp").forward(request, response);
                    return;
                }
                OrganizerService organizerService = new OrganizerService();
                if (organizerService.isLoginUnique(newOrganizer.getLogin())) {
                    organizerService.saveNewOrg(newOrganizer);
                    LoginService loginService = new LoginService();
                    String session = loginService.createSession(newOrganizer.getLogin());
                    request.getSession().setAttribute("session", session);
                    response.addHeader("session", session);
                    response.sendRedirect(request.getContextPath() + "/organizer");
                } else {
                    request.setAttribute("errorText", "Login already used. Change it.");
                    request.getRequestDispatcher("/pages/org_registration.jsp").forward(request, response);
                    return;
                }
            } else if ("orgOptionsButton".equals(buttonType)) {
                response.sendRedirect(request.getContextPath() + "/org_options");
            } else {
                response.getWriter().println("Неопределенный тип кнопки");
            }
        } else {
            response.getWriter().println("Кнопка не выбрана");
        }
    }
}