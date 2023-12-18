package servlets;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class OrganizerServlet extends HttpServlet{
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        request.getRequestDispatcher("/pages/organizer.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String[] buttonTypes = request.getParameterValues("buttonType");
        if (buttonTypes != null && buttonTypes.length > 0) {
            String buttonType = buttonTypes[0];
            if ("createEventButton".equals(buttonType)) {
                response.sendRedirect(request.getContextPath() + "/create_event");
            } else if ("showOrgEventsButton".equals(buttonType)) {
                response.sendRedirect(request.getContextPath() + "/show_org_events");
            } else if ("editEventButton".equals(buttonType)) {
                response.sendRedirect(request.getContextPath() + "/edit_event");
            } else if ("deleteEventButton".equals(buttonType)) {
                response.sendRedirect(request.getContextPath() + "/delete_event");
            } else if ("exitButton".equals(buttonType)) {
                response.sendRedirect(request.getContextPath() + "/index");
            } else {
                response.getWriter().println("Неопределенный тип кнопки");
            }
        } else {
            response.getWriter().println("Кнопка не выбрана");
        }
    }
}