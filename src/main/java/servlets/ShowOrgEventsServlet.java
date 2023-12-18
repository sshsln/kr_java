package servlets;
import model.Event;
import model.Organizer;
import services.LoginService;
import services.db.OrgDBService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public class ShowOrgEventsServlet extends HttpServlet{
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        if (request.getSession().getAttribute("session") != null) {
            String session = (String) request.getSession().getAttribute("session");
            request.setAttribute("session", session);
            response.setContentType("text/html;charset=UTF-8");
            LoginService loginService = new LoginService();
            String organizerLogin = loginService.getLoginBySession(session);
            Organizer organizer = new Organizer();
            organizer.setLogin(organizerLogin);
            OrgDBService orgDBService = new OrgDBService();
            List<Event> events = orgDBService.showOrgEvents(organizer);
            if (!events.isEmpty()) {
            request.setAttribute("events", events);
            request.getRequestDispatcher("/pages/show_org_events.jsp").forward(request, response);
            } else {
                request.setAttribute("events", events);
                request.setAttribute("errorText", "Вы ещё не организовали ни одного мероприятия!");
                request.getRequestDispatcher("/pages/show_org_events.jsp").forward(request, response);
            }
            //super.doGet(request, response);
        } else {
            response.sendRedirect(request.getContextPath() + "/org_options");
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String[] buttonTypes = request.getParameterValues("buttonType");
        if (buttonTypes != null && buttonTypes.length > 0) {
            String buttonType = buttonTypes[0];
            if ("organizerButton".equals(buttonType)) {
                response.sendRedirect(request.getContextPath() + "/organizer");
            } else {
                response.getWriter().println("Неопределенный тип кнопки");
            }
        } else {
            response.getWriter().println("Кнопка не выбрана");
        }
    }
}
