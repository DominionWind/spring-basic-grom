package com.Lesson3.HW.configuration;


import com.Lesson3.HW.Service.FileService;
import com.Lesson3.HW.controller.Controller;
import com.Lesson3.HW.dao.repository.FileDAOimpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;

@org.springframework.context.annotation.Configuration
@ComponentScan("com")
public class AppConfig {

    @Bean
    public FileDAOimpl fileDAOimpl(){
        return new FileDAOimpl();
    }

    @Bean
    public FileService fileService(){
        return new FileService(fileDAOimpl());
    }

    @Bean
    public Controller controller(){
        return new Controller(fileService());
    }

}
