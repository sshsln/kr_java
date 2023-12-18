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

public class CreateEventServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        if (request.getSession().getAttribute("session") != null) {
            String session = (String) request.getSession().getAttribute("session");
            request.setAttribute("session", session);
            request.getRequestDispatcher("/pages/create_event.jsp").forward(request, response);
        } else {
            response.sendRedirect(request.getContextPath() + "/org_options");
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String[] buttonTypes = request.getParameterValues("buttonType");
        if (buttonTypes != null && buttonTypes.length > 0) {
            String buttonType = buttonTypes[0];
            if ("createEventButton".equals(buttonType)) {
                if (request.getSession().getAttribute("session") != null) {
                    String session = (String) request.getSession().getAttribute("session");
                    response.addHeader("session", session);
                    String eventName = request.getParameter("event_name");
                    String date = request.getParameter("date");
                    String location = request.getParameter("location");
                    if (eventName == null || eventName.trim().isEmpty() || date == null || date.trim().isEmpty() || location == null || location.trim().isEmpty()) {
                        request.setAttribute("errorMessage", "Ошибка создания мероприятия. Убедитесь, что все поля заполнены.");
                        request.getRequestDispatcher("/pages/create_event.jsp").forward(request, response);
                        return;
                    }
                    LoginService loginService = new LoginService();
                    String organizerLogin = loginService.getLoginBySession(session);
                    Organizer organizer = new Organizer();
                    organizer.setLogin(organizerLogin);
                    Event event = new Event();
                    event.setEvent_name(eventName);
                    event.setDate(date);
                    event.setLocation(location);
                    event.setOrganizer(organizer);
                    OrgDBService orgDBService = new OrgDBService();
                    boolean success = orgDBService.createEvent(organizer, event);
                    if (success) {
                        request.setAttribute("successMessage", "Мероприятие успешно создано!");
                    } else {
                        request.setAttribute("errorMessage", "Ошибка при создании мероприятия.");
                    }
                    request.getRequestDispatcher("/pages/create_event.jsp").forward(request, response);
                }
            } else if ("organizerButton".equals(buttonType)) {
                response.sendRedirect(request.getContextPath() + "/organizer");
            } else {
                response.getWriter().println("Неопределенный тип кнопки");
            }
        }
    }
}
