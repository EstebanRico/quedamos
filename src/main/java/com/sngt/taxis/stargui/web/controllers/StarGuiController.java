package com.sngt.taxis.stargui.web.controllers;

import com.sngt.taxis.stargui.web.dao.EventDAOInterface;
import com.sngt.taxis.stargui.web.dao.UserDAOInterface;
import com.sngt.taxis.stargui.web.model.Event;
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
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Controller
public class StarGuiController {

    public static final Logger LOGGER = LoggerFactory.getLogger(StarGuiController.class);


    @Autowired
    UserDAOInterface userRepository;
    @Autowired
    EventDAOInterface eventRepository;

    /*****************
     * DASHBOARD
     **************************/

    @RequestMapping(method = RequestMethod.POST, value = "/dashboard")
    public ModelAndView dashboard(String mail, String pass, HttpServletRequest request) {
        LOGGER.info("Click Identify Login Mail:" + mail + " Pass:" + pass);

        /* Création ou récupération de la session */
        HttpSession session = request.getSession();
        LOGGER.info("Création de la session");

        User byMail = userRepository.findByMail(mail);
        ModelAndView modelView;
        if (null != byMail) {
            LOGGER.info(byMail.toString());
            if (pass.equals(byMail.getPass())) {
                modelView = new ModelAndView("MemberDisplay");
                modelView.addObject("user", byMail);
                modelView.addObject("edit", "yes");
                /* Mise en session d'une chaîne de caractères */
                session.setAttribute("userId", byMail.getUserId());
                session.setAttribute("user", byMail);
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
        User userById = userRepository.findByUserId(userId);

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
        LOGGER.info("Click Register Advancedd");

        /* Récupération de l'objet depuis la session */
        Integer userId = (Integer) request.getSession().getAttribute("userId");
        LOGGER.info("Récupération de la session de la valeur de session : " + userId);
        User userById = userRepository.findByUserId(userId);

        ModelAndView modelView = new ModelAndView("MemberModify");
        modelView.addObject("user", userById);
        LOGGER.info("Envoie de l'user avec la description : " + userById.getDescription());

        return modelView;
    }

    @RequestMapping(method = RequestMethod.POST, value = "/member/modify")
    public ModelAndView memberModifyPost(User userJSON, HttpServletRequest request) {
        LOGGER.info("Click save member modification userId:" + userJSON.getUserId() + "  Location:" + userJSON.getLocation());
        Integer userId = (Integer) request.getSession().getAttribute("userId");
        LOGGER.info("Récupération de la session de la valeur de session : " + userId);

        ModelAndView modelView = new ModelAndView("MemberDisplay");
        //Vérification de non hack
        if (userId == userJSON.getUserId()) {
            LOGGER.info("Meme user");
            User userDB = userRepository.findByUserId(userId);
            userDB.mergeModify(userJSON);
            userRepository.save(userDB);
            LOGGER.info("User updated " + userId);
            modelView.addObject("user", userDB);
            modelView.addObject("edit", "yes");
        } else {
            //TODO Gérer le hack
            LOGGER.error("Member modify retourne null");
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

        userRepository.save(u);

        //SI save a fonctionné alors on retourne à l'index en disant OK
        //SINON on retourne à la meme page en disant non OK et les champs qui posent problèmes.

        ModelAndView modelView = new ModelAndView("index");
        modelView.addObject("user", u);
        modelView.addObject("response", "yes");

        return modelView;
    }


    @RequestMapping(method = RequestMethod.GET, value = "/member/display" + "/{login}")
    public ModelAndView memberProfileDisplay(@PathVariable String login) {
        LOGGER.info("Member Profil Display : GET of the member with nickname=" + login);

        User byLogin = userRepository.findByLogin(login);
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
    public ModelAndView MemberSearchPost(String login, String location) {
        LOGGER.info("Click Membres Recherche Search : POST. Login:" + login + " Location:" + location);

        List<User> listUserByLoginLike = userRepository.findByLoginLikeAndLocationLike("%" + login + "%", "%" + location + "%");

        ModelAndView modelView = new ModelAndView("MemberSearch");
        if (null != listUserByLoginLike)
            modelView.addObject("listeUser", listUserByLoginLike);

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
    public ModelAndView EventCreatePOST(Event event, HttpServletRequest request) {
        LOGGER.info("Click Event Create : POST Event:" + event.toString());

        event.setDateCreation(new SimpleDateFormat("dd/MM/yyy").format(new Date()));
        Integer userId = (Integer) request.getSession().getAttribute("userId");
        event.setUserId(userId);
        eventRepository.save(event);


        ModelAndView modelView = new ModelAndView("EventDisplay");
        User user = userRepository.findByUserId(userId);
        modelView.addObject("userLogin", user.getLogin());
        modelView.addObject("event", event);
        return modelView;
    }

    @RequestMapping(method = RequestMethod.GET, value = "/event/search")
    public String EventSearchGet() {
        LOGGER.info("Click Event Search : GET");
        return "EventSearch";
    }

    @RequestMapping(method = RequestMethod.POST, value = "/event/search")
    public ModelAndView EventSearchPost(String location, String type) {
        LOGGER.info("Click Event Search : POST, location:" + location + " type:" + type);

        List<Event> listeEvent = eventRepository.findByTypeLikeAndLocationLike("%" + type + "%", "%" + location + "%");

        ModelAndView modelView = new ModelAndView("EventSearch");
        if (null != listeEvent)
            modelView.addObject("listeEvent", listeEvent);

        LOGGER.info("Click Event Search : POST, retourne " + listeEvent.size());
        return modelView;
    }

    @RequestMapping(method = RequestMethod.GET, value = "/event/display" + "/{eventId}")
    public ModelAndView eventDisplayGet(@PathVariable Integer eventId) {
        LOGGER.info("Event Display : GET of the event with eventName=" + eventId);

        Event eventById = eventRepository.findByEventId(eventId);
        LOGGER.info(eventById.toString());

        ModelAndView modelView = new ModelAndView("EventDisplay");
        modelView.addObject("event", eventById);

        return modelView;
    }

}