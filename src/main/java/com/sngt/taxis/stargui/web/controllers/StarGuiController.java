package com.sngt.taxis.stargui.web.controllers;

import com.sngt.taxis.stargui.web.model.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.List;

@Controller
public class StarGuiController {

    public static final Logger LOGGER = LoggerFactory.getLogger(StarGuiController.class);

    @RequestMapping(method = RequestMethod.POST, value = "/dashboard")
    public String dashboard(String mail, String pass) {
        LOGGER.info("Click Identify Login Mail:" + mail + " Pass:" + pass);
        //TODO faire le maping en base
        if ("a@a.a".equals(mail) && "z".equals(pass)) {
            LOGGER.info("LOGIN");
            return "dashboard";
        }
        LOGGER.info("NOT LOGIN");
        return "index";
    }

    @RequestMapping(method = RequestMethod.GET, value = "/MenuMemberSearch")
    public String MenuMemberSearchGet() {
        LOGGER.info("Click Membres Recherche : GET");
        return "MenuMemberSearch";
    }

    @RequestMapping(method = RequestMethod.POST, value = "/MenuMemberSearch")
    public ModelAndView MenuMemberSearchPost(String login, String gender, String location) {
        LOGGER.info("Click Membres Recherche Search : POST. Login:" + login + " Gender:" + gender + " Location:" + location);

        //TODO faire le maping en base
        User user = new User();
        user.initTest();
        User user2 = new User();
        user2.initTest();
        user2.setNickName("USER2");

        List<User> listeUser = new ArrayList<User>();
        listeUser.add(user);
        listeUser.add(user2);

        ModelAndView modelView = new ModelAndView("MenuMemberSearch");
        modelView.addObject("listeUser", listeUser);

        return modelView;
    }

}