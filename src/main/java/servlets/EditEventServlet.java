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

public class EditEventServlet extends HttpServlet{
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
            List<Event> events = orgDBService.showUpcomingOrgEvents(organizer);
            request.setAttribute("events", events);
            request.getRequestDispatcher("/pages/edit_event.jsp").forward(request, response);
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
            if ("editEventButton".equals(buttonType)) {
                if (request.getSession().getAttribute("session") != null) {
                    String session = (String) request.getSession().getAttribute("session");
                    response.addHeader("session",session);
                    String selectedEventId = request.getParameter("event_id");
                    String date = request.getParameter("date");
                    String location = request.getParameter("location");
                    if (date == null || date.trim().isEmpty() || location == null || location.trim().isEmpty()){
                        request.setAttribute("errorMessage", "Ошибка редактирования данных. Заполните все поля.");
                        request.getRequestDispatcher("/pages/edit_event.jsp").forward(request, response);
                        return;
                    }
                    LoginService loginService = new LoginService();
                    String organizerLogin = loginService.getLoginBySession(session);
                    Organizer organizer = new Organizer();
                    organizer.setLogin(organizerLogin);
                    Event event = new Event();
                    event.setId_e(Integer.parseInt(selectedEventId));
                    event.setDate(date);
                    event.setLocation(location);
                    OrgDBService orgDBService = new OrgDBService();
                    boolean success = orgDBService.editEvent(organizer, event);
                    if (success) {
                        request.setAttribute("successMessage", "Данные успешно отредактированы!");
                    } else {
                        request.setAttribute("errorMessage", "Ошибка редактирования данных.");
                    }
                    request.getRequestDispatcher("/pages/edit_event.jsp").forward(request, response);
                }
            } else if ("organizerButton".equals(buttonType)) {
                response.sendRedirect(request.getContextPath() + "/organizer");
            } else {
                response.getWriter().println("Неопределенный тип кнопки");
            }
        } else {
            response.getWriter().println("Кнопка не выбрана");
        }
    }
}
