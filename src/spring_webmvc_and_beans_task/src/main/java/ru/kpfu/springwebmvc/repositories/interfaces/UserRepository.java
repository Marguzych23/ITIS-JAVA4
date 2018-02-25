package spring_webmvc_and_beans_task.src.main.java.ru.kpfu.springwebmvc.repositories.interfaces;

import ru.kpfu.springwebmvc.models.User;

public interface UserRepository {
    User findByLogin(String login);
}
