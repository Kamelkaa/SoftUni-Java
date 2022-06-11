package exam01_16December2020.Openning.bakery;

import exam01_16December2020.Openning.Employee;

import java.util.ArrayList;
import java.util.List;

public class Bakery {
    private String name;
    private int capacity;
    private List<Employee> employees;

    public Bakery(String name, int capacity) {
        this.name = name;
        this.capacity = capacity;
        this.employees = new ArrayList<>();
    }

    //•	Method add(Employee employee) – adds an entity to the data if there is room for him/her.
    public void add(Employee employee){
        if(this.employees.size() < this.capacity) {
            this.employees.add(employee);
        }
    }

    //•	Method remove(String name) – removes an employee by given name, if such exists, and returns bool.
    public boolean remove(String name){
        for (Employee employee : employees) {
            if(employee.getName().equals(name)){
                employees.remove(employee);
                return true;
            }
        }
        return false;
    }

    //•	Getter getCount() – returns the number of employees.
    public int getCount(){
        return employees.size();
    }


    //•	Method getEmployee(string name) – returns the employee with the given name.
    public Employee getEmployee(String name){

        for (Employee employee : employees) {
            if (employee.getName().equals(name)) {
                return employee;
            }
        }

        Employee employee = new Employee("NoEmployee", 0, "NoCountry");
        return employee;
    }

    //•	Method getOldestEmployee() – returns the oldest employee
    public Employee getOldestEmployee(){
        Employee oldest = null;
        for (Employee employee : employees) {
            if(oldest == null || oldest.getAge() < employee.getAge()){
                oldest = employee;
            }
        }
        return oldest;
    }

    //•	report() – returns a string in the following format:
    //o	"Employees working at Bakery {bakeryName}:
    //{Employee1}
    public String report(){
        StringBuilder fill = new StringBuilder();
        fill.append(String.format("Employees working at Bakery %s:",this.name));
        fill.append(System.lineSeparator());
        for (Employee employee : employees) {
            fill.append(employee).append(System.lineSeparator());
        }
        return fill.toString().trim();
    }
}
