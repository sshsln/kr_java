package services;

import model.Project;
import services.db.ProjectDBService;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class ProjectService {

    public List<Project> getAllProject(){
        List<Project> projects = new ArrayList<>();
        ProjectDBService projectDBService = new ProjectDBService();
        ResultSet resultSet = projectDBService.allData();
        try{
            while (resultSet.next()){
                Project project = new Project();
                project.setName(resultSet.getString("name"));
                projects.add(project);
            }

        } catch (Exception e){

        }

        return projects;
    }


    public  void  createProject(Project project){
        ProjectDBService projectDBService = new ProjectDBService();
        projectDBService.create(project.getName());
    }

}
