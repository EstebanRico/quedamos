package com.sngt.taxis.stargui.web.controllers;

import com.sngt.taxis.stargui.web.model.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.Calendar;
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

    @RequestMapping(method = RequestMethod.GET, value = "/member/register")
    public String registerGet() {
        LOGGER.info("Click Register");
        return "register";
    }

    @RequestMapping(method = RequestMethod.POST, value = "/member/register")
    public ModelAndView registerPost(String mail, String login, String gender, String location, String pass, String confPass) {
        LOGGER.info("Click Register. Mail:" + mail + " Pass:" + pass + " Login:"+login+" Gender:"+gender+" Location:"+location+" confPass:"+confPass);

        User u = new User();
        u.setNickName(login);
        u.setCreationDate(Calendar.getInstance().getTime());
        u.setGender(gender);
        u.setMail(mail);
        u.setPass(pass);
        u.setLocation(location);

        u.setDescription("Description is mine");

        //TODO enregistrement de l'utilisateur en base de données

        ModelAndView modelView = new ModelAndView("ProfileDisplay");
        modelView.addObject("user", u);

        return modelView;
    }

    @RequestMapping(method = RequestMethod.GET, value = "/member/search")
    public String MemberSearchGet() {
        LOGGER.info("Click Membres Recherche : GET");
        return "MemberSearch";
    }

    @RequestMapping(method = RequestMethod.GET, value = "/member/display"+"/{nickname}")
    public ModelAndView memberProfileDisplay(@PathVariable String nickname) {
        LOGGER.info("Member Profil Display : GET of the member with nickname="+nickname);

        //TODO faire le maping en base
        User user = new User();
        user.initTest1();

        ModelAndView modelView = new ModelAndView("MemberDisplay");
        modelView.addObject("user", user);

        return modelView;
    }

    @RequestMapping(method = RequestMethod.POST, value = "/member/search")
    public ModelAndView MemberSearchPost(String login, String gender, String location) {
        LOGGER.info("Click Membres Recherche Search : POST. Login:" + login + " Gender:" + gender + " Location:" + location);

        //TODO faire le maping en base
        User user = new User();
        user.initTest1();
        User user2 = new User();
        user2.initTest2();
        user2.setNickName("USER2");

        List<User> listeUser = new ArrayList<User>();
        listeUser.add(user);
        listeUser.add(user2);

        ModelAndView modelView = new ModelAndView("MemberSearch");
        modelView.addObject("listeUser", listeUser);

        return modelView;
    }

}