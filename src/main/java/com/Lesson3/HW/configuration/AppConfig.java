package com.Lesson3.HW.configuration;

import com.Lesson3.HW.Service.FileService;
import com.Lesson3.HW.controller.Controller;
import com.Lesson3.HW.dao.repository.FileDAOimpl;
import com.Lesson3.HW.dao.repository.StorageDAOimpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;


@org.springframework.context.annotation.Configuration
@EnableWebMvc
@ComponentScan("com")
public class AppConfig {

    @Bean
    public FileDAOimpl fileDAOimpl() {
        return new FileDAOimpl();
    }

    @Bean
    public StorageDAOimpl storageDAOimpl() {
        return new StorageDAOimpl();
    }

    @Bean
    public FileService fileService() {
        return new FileService(fileDAOimpl());
    }

//    @Bean (name = "Controller")
//    public Controller controller() {
//        return new Controller(fileService());
//    }
}
