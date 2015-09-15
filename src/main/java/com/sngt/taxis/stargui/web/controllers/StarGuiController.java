package com.sngt.taxis.stargui.web.controllers;

import com.sngt.taxis.stargui.web.dao.UserDAOInterface;
import com.sngt.taxis.stargui.web.model.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.List;

@Controller
public class StarGuiController {

    public static final Logger LOGGER = LoggerFactory.getLogger(StarGuiController.class);


    @Autowired
    UserDAOInterface repository;

    /*****************
     * DASHBOARD
     **************************/

    @RequestMapping(method = RequestMethod.POST, value = "/dashboard")
    public ModelAndView dashboard(String mail, String pass) {
        LOGGER.info("Click Identify Login Mail:" + mail + " Pass:" + pass);

        User byMail = repository.findByMail(mail);
        ModelAndView modelView;
        if (null != byMail) {
            LOGGER.info(byMail.toString());

            if (pass.equals(byMail.getPass())) {
                modelView = new ModelAndView("MemberDisplay");
                modelView.addObject("user", byMail);
                modelView.addObject("edit", "yes");
            } else {
                modelView = new ModelAndView("index");
            }
        }else {
            modelView = new ModelAndView("index");
        }
        return modelView;
    }

    /*****************
     * MEMBER
     **************************/

    @RequestMapping(method = RequestMethod.GET, value = "/member/register")
    public String registerGet() {
        LOGGER.info("Click Register");
        return "register";
    }

    @RequestMapping(method = RequestMethod.GET, value = "/member/modify")
    public ModelAndView registerAdvancedGet() {
        LOGGER.info("Click Register Advanced");

        ModelAndView modelView = new ModelAndView("register");
        modelView.addObject("advanced", "yes");

        return modelView;
    }

    @RequestMapping(method = RequestMethod.POST, value = "/member/register")
    public ModelAndView registerPost(User u) {
        LOGGER.info("Click Register.");

        repository.save(u);

        ModelAndView modelView = new ModelAndView("MemberDisplay");
        modelView.addObject("user", u);
        modelView.addObject("edit", "yes");

        return modelView;
    }


    @RequestMapping(method = RequestMethod.GET, value = "/member/display" + "/{login}")
    public ModelAndView memberProfileDisplay(@PathVariable String login) {
        LOGGER.info("Member Profil Display : GET of the member with nickname=" + login);

        User byLogin = repository.findByLogin(login);
        LOGGER.info(byLogin.toString());

        ModelAndView modelView = new ModelAndView("MemberDisplay");
        modelView.addObject("user", byLogin);

        return modelView;
    }

    @RequestMapping(method = RequestMethod.GET, value = "/member/search")
    public String MemberSearchGet() {
        LOGGER.info("Click Membres Recherche : GET");
        return "MemberSearch";
    }

    @RequestMapping(method = RequestMethod.POST, value = "/member/search")
    public ModelAndView MemberSearchPost(String login, String gender, String location) {
        LOGGER.info("Click Membres Recherche Search : POST. Login:" + login + " Gender:" + gender + " Location:" + location);

        User byLogin = repository.findByLogin(login);

        List<User> listeUser = new ArrayList<User>();
        listeUser.add(byLogin);

        ModelAndView modelView = new ModelAndView("MemberSearch");
        modelView.addObject("listeUser", listeUser);

        return modelView;
    }

    /*********************
     * EVENT
     ****************/


    @RequestMapping(method = RequestMethod.GET, value = "/event/create")
    public String EventCreateGET() {
        LOGGER.info("Click Event Create : GET");
        return "EventCreate";
    }

    @RequestMapping(method = RequestMethod.POST, value = "/event/create")
    public String EventCreatePOST() {
        LOGGER.info("Click Event Create : POST");
        return "indexBack";
    }

    @RequestMapping(method = RequestMethod.GET, value = "/event/search")
    public String EventSearchGet() {
        LOGGER.info("Click Event Search : GET");
        return "EventSearch";
    }

}