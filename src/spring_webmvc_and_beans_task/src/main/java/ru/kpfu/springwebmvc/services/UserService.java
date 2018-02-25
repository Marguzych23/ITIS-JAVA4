package spring_webmvc_and_beans_task.src.main.java.ru.kpfu.springwebmvc.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.kpfu.springwebmvc.models.User;
import ru.kpfu.springwebmvc.repositories.interfaces.UserRepository;

@Service
public class UserService {

    private UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository){
        this.userRepository = userRepository;
    }

    public User getUserByLogin(String login) {
        return this.userRepository.findByLogin(login);
    }
}
