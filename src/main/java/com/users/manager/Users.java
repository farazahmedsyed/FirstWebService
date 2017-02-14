package main.java.com.users.manager;

import javax.persistence.*;

/**
 * Created by Venturdive on 08/02/2017.
 */
@Entity
@Table(name="Users")
public class Users {

    @Id
    @Column(name="USER_ID")
    @GeneratedValue(strategy=GenerationType.IDENTITY)
        private Integer userID;
        private String name;
        private Integer age;
    public Users(){}

    public Users(Integer userID,String name,Integer age) {
        this.userID=userID;
        this.name=name;
        this.age=age;
    }

    public Integer getUserID() {
        return userID;
    }

    public void setUserId(Integer userID) {
        this.userID = userID;
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
