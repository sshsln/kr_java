package servlets;

import model.Event;
import model.Visitor;
import services.db.VisDBService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public class RegistrationServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        VisDBService visDBService = new VisDBService();
        List<Event> events = visDBService.showUpcomingVisEvents();
        request.setAttribute("events", events);
        request.getRequestDispatcher("/pages/registration.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String[] buttonTypes = request.getParameterValues("buttonType");
        if (buttonTypes != null && buttonTypes.length > 0) {
            String buttonType = buttonTypes[0];
            if ("registrationButton".equals(buttonType)) {
                String selectedEventId = request.getParameter("event_id");
                String visitor_name = request.getParameter("visitor_name");
                String email = request.getParameter("email");
                if (visitor_name == null || visitor_name.trim().isEmpty() || email == null || email.trim().isEmpty()) {
                    request.setAttribute("errorMessage", "Ошибка регистрации! Заполните все поля.");
                    request.getRequestDispatcher("/pages/registration.jsp").forward(request, response);
                    return;
                }
                Visitor visitor = new Visitor();
                visitor.setVisitor_name(visitor_name);
                visitor.setEmail(email);
                Event event = new Event();
                event.setId_e(Integer.parseInt(selectedEventId));
                VisDBService visDBService = new VisDBService();
                boolean checkUser = visDBService.isUserExist(email);
                int visitorId;
                if (checkUser) {
                    boolean userExist = visDBService.editVisName(visitor);
                } else {
                    boolean userNew = visDBService.createVisitor(visitor);
                }
                Visitor newVisitor = visDBService.getVisitorByEmail(visitor.getEmail());
                visitorId = newVisitor.getId_v();
                boolean success = visDBService.createRegistration(event.getId_e(), visitorId);
                if (success) {
                    request.setAttribute("successMessage", "Вы успешно зарегистрировались на мероприятие!");
                } else {
                    request.setAttribute("errorMessage", "Ошибка регистрации.");
                }
                request.getRequestDispatcher("/pages/registration.jsp").forward(request, response);
            } else if ("visitorButton".equals(buttonType)) {
                response.sendRedirect(request.getContextPath() + "/visitor");
            } else {
                response.getWriter().println("Неопределенный тип кнопки");
            }
        }
    }
}
