package main.java.com.entities;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "employees")
public class Employee implements Serializable{

    @Id
    //@Column(name="empID")
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Integer empID;
        private String name;
        private Integer age;
    public Employee(){}
  public Employee(User user){
      this.empID=user.getUserID();
      this.age=user.getAge();
      this.name=user.getName();
  }
    public Employee(Integer empID, String name, Integer age) {
        this.empID=empID;
        this.name=name;
        this.age=age;
    }

    public Integer getEmpID() {
        return empID;
    }

    public void setEmpID(Integer empID) {
        this.empID = empID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }
}
