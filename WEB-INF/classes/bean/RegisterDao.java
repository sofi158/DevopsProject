package bean;
import java.sql.*;

public class RegisterDao {

    public static boolean register(RegisterBean bean) {
        boolean status = false;
        try {
            Connection con = ConnectionProvider.getCon();
            
            PreparedStatement ps = con.prepareStatement("insert into users(name, email, password) values (?, ?, ?)");
            ps.setString(1, bean.getName());
            ps.setString(2, bean.getEmail());
            ps.setString(3, bean.getPassword());
            
            int result = ps.executeUpdate();
            if(result > 0) {
                status = true;
            }
        } catch(Exception e) {
            e.printStackTrace();
        }
        return status;
    }
}
