package com.Lesson3;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;

public class PasswordReminder {

    private DbConnector dbConnector;

    @Autowired
    public PasswordReminder(DbConnector dbConnector){
        this.dbConnector = dbConnector;
    }

    public void sendPassword(){
        //logic
    }
}
