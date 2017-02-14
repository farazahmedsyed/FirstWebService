package main.java.com.users.manager;

/**
 * Created by Venturdive on 08/02/2017.
 */
public class Users1 {

        private Integer userID;
        private String name;
        private Integer age;
    public Users1(){}

    public Users1(Integer userID, String name, Integer age) {
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
