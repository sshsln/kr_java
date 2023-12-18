package servlets;
import model.Event;
import services.db.VisDBService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public class ShowVisEventsServlet extends HttpServlet{
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
            response.setContentType("text/html;charset=UTF-8");
            VisDBService visDBService = new VisDBService();
            List<Event> events = visDBService.showVisEvents();
            if (!events.isEmpty()) {
                request.setAttribute("events", events);
                request.getRequestDispatcher("/pages/show_vis_events.jsp").forward(request, response);
            } else {
                response.getWriter().println("Нет предстоящих мероприятий");
            }
            super.doGet(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String[] buttonTypes = request.getParameterValues("buttonType");
        if (buttonTypes != null && buttonTypes.length > 0) {
            String buttonType = buttonTypes[0];
            if ("visitorButton".equals(buttonType)) {
                response.sendRedirect(request.getContextPath() + "/visitor");
            } else {
                response.getWriter().println("Неопределенный тип кнопки");
            }
        } else {
            response.getWriter().println("Кнопка не выбрана");
        }
    }
}
