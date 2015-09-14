package com.sngt.taxis.stargui.web.dao;

import com.sngt.taxis.stargui.web.model.User;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by skiss on 14/09/2015.
 */
public interface UserDAOInterface extends CrudRepository<User, Integer> {

    User findByLogin(String login);
}
