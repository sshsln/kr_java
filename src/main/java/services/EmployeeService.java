package services;

import model.Employee;
import services.db.EmployeeDBService;

public class EmployeeService {

    public void saveEmployee(Employee employee){
        EmployeeDBService employeeDBService = new EmployeeDBService();
        HashService hashService = new HashService();
        employee.setPassword(hashService.createHash(employee.getPassword()));
        employeeDBService.create(employee);
    }

}
