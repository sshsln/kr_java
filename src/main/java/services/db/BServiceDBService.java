package services.db;

import java.sql.ResultSet;

public class BServiceDBService {

    public ResultSet allService(){
        DataBaseService dataBaseService = new DataBaseService();
        String sql = "select * from service";
        return dataBaseService.select(sql);
    }

    public ResultSet allService(String phone){
        DataBaseService dataBaseService = new DataBaseService();
        String sql = "select * from service where phone = '"+phone+"'";
        return dataBaseService.select(sql);
    }


}
