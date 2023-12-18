package services;

import model.Project;
import services.db.BServiceDBService;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BServiceService {

    public List<Map<String,Object>> getAll(){
        List<Map<String, Object>> all = new ArrayList<>();
        BServiceDBService bServiceDBService = new BServiceDBService();
        ResultSet resultSet = bServiceDBService.allService();
        try{
            while (resultSet.next()){
                Map<String ,Object> map = new HashMap<>();
                map.put("id", resultSet.getInt("id"));
                map.put("phone", resultSet.getString("phone"));
                map.put("description", resultSet.getString("description"));
                map.put("isActive", resultSet.getInt("isActive"));
                all.add(map);
            }

        } catch (Exception e){

        }

        return all;
    }


}
