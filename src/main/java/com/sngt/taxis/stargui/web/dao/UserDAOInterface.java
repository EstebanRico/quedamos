package com.sngt.taxis.stargui.web.dao;

import com.sngt.taxis.stargui.web.model.User;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

/**
 * Created by skiss on 14/09/2015.
 */
public interface UserDAOInterface extends CrudRepository<User, Integer> {

    User findByUserId(Integer userId);

    List<User> findByUserIdLike(Integer userId);

    User findByLogin(String login);

    List<User> findByLoginLike(String login);

    User findByMail(String mail);

}

