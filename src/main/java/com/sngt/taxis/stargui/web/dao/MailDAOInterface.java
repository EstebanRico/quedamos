package com.sngt.taxis.stargui.web.dao;

import com.sngt.taxis.stargui.web.model.Event;
import com.sngt.taxis.stargui.web.model.Mail;
import com.sngt.taxis.stargui.web.model.User;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

/**
 * Created by skiss on 14/09/2015.
 */
public interface MailDAOInterface extends CrudRepository<Mail, Integer> {

    List<Mail> findByUser(User user);
}

