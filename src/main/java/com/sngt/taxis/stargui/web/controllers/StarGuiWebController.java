package com.sngt.taxis.stargui.web.controllers;

import com.sngt.taxis.stargui.web.domain.amqp.TG7Message;
import com.sngt.taxis.stargui.web.domain.amqp.TG7MessageUtils;
import com.sngt.taxis.stargui.web.services.AMQPService;
import com.sngt.taxis.stargui.web.services.amqp.AMQPDataParser;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.Map;

import static com.sngt.taxis.stargui.web.StarGuiWebApplication.BASE_URL;

/**
 * Created by yvu on 18/08/2015.
 */
@Controller
public class StarGuiWebController {

    public static final Logger LOGGER = LoggerFactory.getLogger(StarGuiWebController.class);

    @RequestMapping(method = RequestMethod.GET, value = BASE_URL + "/")
    public String index(Map<String, Object> model) {
        LOGGER.debug("[IN] index (web)");
        LOGGER.debug("[OUT] index (web)");
        return "index";
    }
}