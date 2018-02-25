package spring_webmvc_and_beans_task.src.main.java.ru.kpfu.springwebmvc.repositories.implementations;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;
import ru.kpfu.springwebmvc.models.User;
import ru.kpfu.springwebmvc.repositories.interfaces.UserRepository;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

@Repository
public class UserRepositoryImpl implements UserRepository {

    @Autowired
    @Qualifier("simpleJDBC")
    private DataSource dataSource;

    private static final String SELECT_USER_BY_LOGIN = "SELECT * FROM users WHERE login = ?";

    @Override
    public User findByLogin(String login) {
        User user = null;
        try {
            Connection conn = this.dataSource.getConnection();
            PreparedStatement ps = conn.prepareStatement(SELECT_USER_BY_LOGIN);
            ps.setString(1, login);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                user = User.builder()
                        .login(rs.getString("login"))
                        .password(rs.getString("password"))
                        .build();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return user;
    }
}
