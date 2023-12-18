package servlets.rest;

import com.google.gson.Gson;
import model.Project;
import services.ProjectService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.io.IOException;
import java.util.List;
import java.util.Map;

public class ProjectRestServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        resp.setContentType("application/json"); //указываем формат ответа (что это json)
        resp.setCharacterEncoding("UTF-8");//укажем кодировку
        ProjectService projectService = new ProjectService();
        List<Project> projects =  projectService.getAllProject();
        String json = new Gson().toJson(projects);
        resp.getWriter().println(json);
    }


    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");//кодировка

        //получаю входящий json
        StringBuilder requestBodyBuilder = new StringBuilder();
        BufferedReader reader = req.getReader();

        try {
            String line;
            while ((line = reader.readLine()) != null) {
                requestBodyBuilder.append(line);
            }
        } finally {
            reader.close();
        }

        String json = requestBodyBuilder.toString();
        Map<String,String> obj = new Gson().fromJson(json, Map.class);

        Project project = new Project();
        project.setName(obj.get("name"));

        ProjectService projectService = new ProjectService();
        projectService.createProject(project);





    }
}
