package com.sngt.taxis.stargui.web;

import com.sngt.taxis.stargui.web.dao.UserDAOInterface;
import com.sngt.taxis.stargui.web.dao.EventDAOInterface;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class StarGuiWebApplication {

    public static final String BASE_URL = "";
    public static final Logger LOGGER = LoggerFactory.getLogger(StarGuiWebApplication.class);


    public static void main(String[] args) {
        SpringApplication.run(StarGuiWebApplication.class, args);
    }


}
