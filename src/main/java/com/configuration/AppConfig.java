package com.configuration;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
@EnableWebMvc
@ComponentScan(basePackages = {"com"})
public class AppConfig implements WebMvcConfigurer {

//    @Bean
//    public FileDAOimpl fileDAOimpl() {
//        return new FileDAOimpl();
//    }
//
//    @Bean
//    public StorageDAOimpl storageDAOimpl() {
//        return new StorageDAOimpl();
//    }
//
//    @Bean
//    public FileService fileService() {
//        return new FileService(fileDAOimpl());
//    }

//    @Bean (name = "Controller")
//    public Controller controller() {
//        return new Controller(fileService());
//    }
}
