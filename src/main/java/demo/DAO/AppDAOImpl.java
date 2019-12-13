package demo.DAO;

import demo.model.User;
import demo.model.User;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@Component
public class AppDAOImpl implements AppDAO {
    private DataSource dataSource;

    public AppDAOImpl(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    @Override
    public List<User> listUsers() {
        String SQL = "Select * from users";
        List<User> listUsers = new ArrayList<User>();
        Connection conn = null;
        try{
            conn = dataSource.getConnection();
            PreparedStatement ps = conn.prepareStatement(SQL);
            ResultSet rs =  ps.executeQuery();
            while(rs.next()){
                User temp = new User(
                        rs.getInt("users_id"),
                        rs.getString("username"),
                        rs.getString("email")
                );
                listUsers.add(temp);
            }
            rs.close();
            ps.close();
            return listUsers;

        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }finally{
            if (conn != null) {
                try {
                    conn.close();
                } catch (SQLException e) {e.printStackTrace();}
            }

        }


    }
}
