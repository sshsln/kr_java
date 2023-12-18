package services.db;

import java.sql.ResultSet;

public class ProjectDBService {


    public ResultSet allData(){
        DataBaseService dataBaseService = new DataBaseService();
        String sql = "select * from projects";
        return dataBaseService.select(sql);
    }

    public void create(String name) {
        DataBaseService dataBaseService = new DataBaseService();
        String sql = "INSERT INTO projects  (name)\n" +
                "VALUES ('"+name+"')";
        if(dataBaseService.insert(sql)){
            // логика на успех
        } else {
            // ошибка
        }

    }

}
