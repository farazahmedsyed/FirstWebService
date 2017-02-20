package main.java.com.manager.interfaces;

import main.java.com.entities.Employee;

import java.util.List;

public interface EmployeesDAO
{
    public List<Employee> viewAll();
    public Employee viewEmpByID(Integer empID);
    public Employee insertEmp(Employee emp);
    public Employee updateEmp(Employee emp);
}