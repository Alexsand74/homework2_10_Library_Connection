package com.example.homework2_10_library_connection.service;

import com.example.homework2_10_library_connection.exception.EmployeeAlreadyAddedException;
import com.example.homework2_10_library_connection.exception.EmployeeNotFoundException;
import com.example.homework2_10_library_connection.exception.EmployeeStorageIsFullException;
import com.example.homework2_10_library_connection.model.Employee;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class EmployeeService {
    private static final int LIMIT = 10;
    private final Map<String, Employee> employees;
    public EmployeeService() {
        this.employees = new HashMap<>();
    }
    public Employee addEmployee(String firstName, String lastName, int department, double salary) {
        Employee employee = new Employee(firstName, lastName, department,salary);
        String key = getKey(firstName,lastName);
        if (employees.containsKey(key)) {
            throw new EmployeeAlreadyAddedException();
        }
        if (employees.size() < LIMIT) {
            employees.put(key,employee);
            return employee;
        }
        throw new EmployeeStorageIsFullException();
    }

    public Employee findEmployee(String firstName, String lastName) {
        String key = getKey(firstName,lastName);
        if (!employees.containsKey(key)) {
            throw new EmployeeNotFoundException();
        }
        return employees.get(key);
    }
    public Employee removeEmployee(String firstName, String lastName) {
        String key = getKey(firstName,lastName);
        if (!employees.containsKey(key)) {
                  throw new EmployeeNotFoundException();
        }
        return employees.remove(key);
    }

    public List<Employee> getAll() {
        return new ArrayList<>(employees.values());
    }
    public String getKey (String firstName, String lastName){
        return firstName+lastName;
    }
}
