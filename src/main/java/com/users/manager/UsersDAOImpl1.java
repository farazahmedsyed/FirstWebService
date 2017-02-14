package main.java.com.users.manager;/*package main.java.com.users.users.manager;

import com.mysql.cj.api.jdbc.Statement;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

//@Component
public class UsersDAOImpl1 implements UsersDAO
{

  public UsersDAO usersDAO(){return  new UsersDAOImpl1();}

   @Autowired
    private DataSource dataSource;

    public List<Users> viewAll() {

    String sql = "SELECT * FROM `USERS`";

    Connection conn = null;

    try {
        conn = dataSource.getConnection();
        PreparedStatement ps = conn.prepareStatement(sql);
        List<Users> users = new ArrayList<Users>();
        ResultSet rs = ps.executeQuery();

        while (rs.next())
        {
            users.add( new Users(
                            rs.getInt("USER_ID"),
                            rs.getString("NAME"),
                            rs.getInt("AGE"))
            );
        }
        rs.close();
        ps.close();
        return users;
    } catch (SQLException e) {
        throw new RuntimeException(e);
    } finally {
        if (conn != null) {
            try {
                conn.close();
            } catch (SQLException e) {}
        }
    }
}
    public List<Users> viewUserByID(Integer userID) {

        String sql = "SELECT * FROM `USERS` WHERE `USER_ID`= ? ";

        Connection conn = null;

        try {
            conn = dataSource.getConnection();
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1,userID);
            List<Users> users = new ArrayList<Users>();
            ResultSet rs = ps.executeQuery();

            while (rs.next())
            {
                users.add( new Users(
                        rs.getInt("USER_ID"),
                        rs.getString("NAME"),
                        rs.getInt("AGE"))
                );
            }
            rs.close();
            ps.close();
            return users;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            if (conn != null) {
                try {
                    conn.close();
                } catch (SQLException e) {}
            }
        }
    }
    public Users insertUser(Users user){
        String sql = "INSERT INTO USERS (NAME, AGE) VALUES (?, ?)";
        Connection conn = null;

        try {
            conn = dataSource.getConnection();
            PreparedStatement ps = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            ps.setString(1, user.getName());
            ps.setInt(2, user.getAge());
            ps.executeUpdate();
            ResultSet rs = ps.getGeneratedKeys();
            rs.next();
            user.setUserId(rs.getInt(1));
            ps.close();
            return user;

        } catch (SQLException e) {
            throw new RuntimeException(e);

        } finally {
            if (conn != null) {
                try {
                    conn.close();
                } catch (SQLException e) {}
            }
        }
    }
    public Users updateUser(Users user){
        String sql = "UPDATE USERS SET NAME=?,AGE=? WHERE USER_ID=?";
        Connection conn = null;

        try {
            conn = dataSource.getConnection();
            PreparedStatement ps = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            ps.setString(1, user.getName());
            ps.setInt(2, user.getAge());
            ps.setInt(3, user.getUserID());
            ps.executeUpdate();
            ps.close();
            return user;

        } catch (SQLException e) {
            throw new RuntimeException(e);

        } finally {
            if (conn != null) {
                try {
                    conn.close();
                } catch (SQLException e) {}
            }
        }
    }
}*/