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

public class CancelRegistrationServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        VisDBService visDBService = new VisDBService();
        List<Event> events = visDBService.showUpcomingVisEvents();
        request.setAttribute("events", events);
        request.getRequestDispatcher("/pages/cancel_registration.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String[] buttonTypes = request.getParameterValues("buttonType");
        if (buttonTypes != null && buttonTypes.length > 0) {
            String buttonType = buttonTypes[0];
            if ("cancelRegistrationButton".equals(buttonType)) {
                String selectedEventId = request.getParameter("event_id");
                String email = request.getParameter("email");
                if (email == null || email.trim().isEmpty()) {
                    request.setAttribute("errorMessage", "Ошибка отмены регистрации. Убедитесь в корректности введённого email.");
                    request.getRequestDispatcher("/pages/cancel_registration.jsp").forward(request, response);
                    return;
                }
                Visitor visitor = new Visitor();
                visitor.setEmail(email);
                Event event = new Event();
                event.setId_e(Integer.parseInt(selectedEventId));
                VisDBService visDBService = new VisDBService();
                boolean checkReg = visDBService.isRegistrationExist(email, Integer.parseInt(selectedEventId));
                if (checkReg) {
                    boolean regExist = visDBService.cancelRegistration(email, Integer.parseInt(selectedEventId));
                    request.setAttribute("successMessage", "Регистрация на мероприятие отменена!");
                } else {
                    request.setAttribute("errorMessage", "Ошибка. Вы не регистрировались на это мероприятие.");
                }
                request.getRequestDispatcher("/pages/cancel_registration.jsp").forward(request, response);
            } else if ("visitorButton".equals(buttonType)) {
                response.sendRedirect(request.getContextPath() + "/visitor");
            } else {
                response.getWriter().println("Неопределенный тип кнопки");
            }
        }
    }
}
