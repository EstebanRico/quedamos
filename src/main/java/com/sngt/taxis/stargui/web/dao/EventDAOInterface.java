package com.sngt.taxis.stargui.web.dao;

import com.sngt.taxis.stargui.web.model.Event;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

/**
 * Created by skiss on 14/09/2015.
 */
public interface EventDAOInterface extends CrudRepository<Event, Integer> {

    Event findByEventId(Integer eventId);

    List<Event> findByEventIdLike(Integer eventId);

    Event findByLocation(String location);

    List<Event> findByLocationLike(String location);

    List<Event> findByType(String type);


}

