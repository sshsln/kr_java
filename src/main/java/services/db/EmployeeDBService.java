package services.db;

import model.Employee;

import java.util.List;

public class EmployeeDBService {

    public Boolean create(Employee employee){
        Boolean isSuccess = false;
        DataBaseService dataBaseService = new DataBaseService();
        String sql = "INSERT INTO employees (login, password, full_name)" +
                "VALUES ('"+employee.getLogin()+"', '"+employee.getPassword()+"','"+employee.getFio()+"')";
        if(dataBaseService.insert(sql)){
            // логика на успех
            isSuccess =true;
        } else {
            // ошибка
        }

        return isSuccess;
    }



}
