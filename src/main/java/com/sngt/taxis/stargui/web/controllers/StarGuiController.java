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

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
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
    public ModelAndView dashboard(String mail, String pass, HttpServletRequest request) {
        LOGGER.info("Click Identify Login Mail:" + mail + " Pass:" + pass);

        /* Création ou récupération de la session */
        HttpSession session = request.getSession();
        LOGGER.info("Création de la session");

        User byMail = repository.findByMail(mail);
        ModelAndView modelView;
        if (null != byMail) {
            LOGGER.info(byMail.toString());
            if (pass.equals(byMail.getPass())) {
                modelView = new ModelAndView("MemberDisplay");
                modelView.addObject("user", byMail);
                modelView.addObject("edit", "yes");
                /* Mise en session d'une chaîne de caractères */
                session.setAttribute("userId", byMail.getUserId());
                LOGGER.info("Insertion dans la session de la valeur:" + byMail.getUserId());
            } else {
                modelView = new ModelAndView("index");
            }
        } else {
            modelView = new ModelAndView("index");
        }
        return modelView;
    }

    @RequestMapping(method = RequestMethod.GET, value = "/dashboard")
    public ModelAndView dashboardGET(HttpServletRequest request) {
    /* Création ou récupération de la session */
        Integer userId = (Integer) request.getSession().getAttribute("userId");
        LOGGER.info("Récupération de la session de la valeur de session : " + userId);
        User userById = repository.findByUserId(userId);

        if (null != userById) {
            LOGGER.info(userById.toString());
            ModelAndView modelView = new ModelAndView("MemberDisplay");
            modelView.addObject("user", userById);
            modelView.addObject("edit", "yes");
            return modelView;
        }
        return null;
    }

    /*****************
     * MEMBER
     **************************/

    @RequestMapping(method = RequestMethod.GET, value = "/member/register")
    public String registerGet(HttpServletResponse response) {
        LOGGER.info("Click Register");
        return "register";
    }

    @RequestMapping(method = RequestMethod.GET, value = "/member/modify")
    public ModelAndView registerAdvancedGet(HttpServletRequest request) {
        LOGGER.info("Click Register Advanced");

        /* Récupération de l'objet depuis la session */
        Integer userId = (Integer) request.getSession().getAttribute("userId");
        LOGGER.info("Récupération de la session de la valeur de session : " + userId);
        User userById = repository.findByUserId(userId);

        ModelAndView modelView = new ModelAndView("MemberModify");
        modelView.addObject("user", userById);

        return modelView;
    }

    @RequestMapping(method = RequestMethod.POST, value = "/member/modify")
    public ModelAndView memberModifyPost(User userJSON, HttpServletRequest request) {
        LOGGER.info("Click save member modification userId:" + userJSON.getUserId());
        Integer userId = (Integer) request.getSession().getAttribute("userId");
        LOGGER.info("Récupération de la session de la valeur de session : " + userId);

        ModelAndView modelView = new ModelAndView("dashboard");
        //Vérification de non hack
        if (userId == userJSON.getUserId()) {
            LOGGER.info("Meme user");
            User userDB = repository.findByUserId(userId);
            userDB.mergeModify(userJSON);
            repository.save(userDB);
            LOGGER.info("User updated " + userId);
            modelView.addObject("user", userDB);
        } else {
            //TODO Gérer le hack
            return null;
        }

        //SI save a fonctionné alors on retourne à l'index en disant OK
        //SINON on retourne à la meme pas en disant non OK et les champs qui posent problèmes.

        /* Récupération de l'objet depuis la session */
        return modelView;
    }

    @RequestMapping(method = RequestMethod.POST, value = "/member/register")
    public ModelAndView registerPost(User u) {
        LOGGER.info("Click Register.");

        repository.save(u);

        //SI save a fonctionné alors on retourne à l'index en disant OK
        //SINON on retourne à la meme pas en disant non OK et les champs qui posent problèmes.

        ModelAndView modelView = new ModelAndView("index");
        modelView.addObject("user", u);
        modelView.addObject("response", "yes");

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