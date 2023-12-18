package servlets.rest;

import com.google.gson.Gson;
import services.BServiceService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;
import java.util.Map;

public class ServiceRest extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("application/json");
        resp.setCharacterEncoding("UTF-8");
        BServiceService bServiceService = new BServiceService();
        List<Map<String, Object>> all = bServiceService.getAll();
        String json = new Gson().toJson(all);
        resp.getWriter().println(json);
    }
}
