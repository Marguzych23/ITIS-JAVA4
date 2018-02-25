package spring_webmvc_and_beans_task.src.main.java.ru.kpfu.springwebmvc.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import ru.kpfu.springwebmvc.models.User;
import ru.kpfu.springwebmvc.services.UserService;

@Controller("Index Controller")
public class IndexController {

    private UserService userService;

    @Autowired
    public IndexController(UserService userService) {
        this.userService = userService;
    }

    @RequestMapping("/hardcode")
    @ResponseBody
    public String getHardCodeMessage() {

        User user = User.builder()
                .login("Marguzych")
                .password("Din.Rey")
                .build();

        return user.toString();

    }

    @RequestMapping("/db")
    @ResponseBody
    public String getComplexMessage() {
        return this.userService.getUserByLogin("116rus").toString();
    }

}
