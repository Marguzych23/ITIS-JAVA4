package spring_webmvc_and_beans_task.src.main.java.ru.kpfu.springwebmvc.config;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@Configuration
@EnableWebMvc
@ComponentScan({"ru.kpfu.springwebmvc.controllers", "ru.kpfu.springwebmvc.services",
        "ru.kpfu.springwebmvc.repositories", "ru.kpfu.springwebmvc.config"})
@PropertySource("classpath:db.properties")
public class WebConfig implements ApplicationContextAware {

    private ApplicationContext appContext;

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.appContext = applicationContext;
    }

}

