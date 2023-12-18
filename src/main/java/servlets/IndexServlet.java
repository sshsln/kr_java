package servlets;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class IndexServlet extends HttpServlet{
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        request.getRequestDispatcher("/pages/index.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String buttonType = request.getParameter("buttonType");
        if ("organizer".equals(buttonType)) {
            response.sendRedirect(request.getContextPath() + "/org_options");
        } else if ("visitor".equals(buttonType)) {
            response.sendRedirect(request.getContextPath() + "/visitor");
        } else {
            response.getWriter().println("Неопределенный тип кнопки");
        }
    }
}
