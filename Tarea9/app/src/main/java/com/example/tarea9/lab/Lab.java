package com.example.tarea9.lab;

import com.example.tarea9.model.Employee;

import java.util.List;

public interface Lab {

    public void add(Employee e);
    public void update(Employee e);
    public  void delete(Employee e);
    public List<? extends Employee> getEmployeeList();


}
