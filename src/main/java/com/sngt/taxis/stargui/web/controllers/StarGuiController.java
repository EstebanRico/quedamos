package com.sngt.taxis.stargui.web.controllers;

import com.sngt.taxis.stargui.web.WebSocketConfig;
import com.sngt.taxis.stargui.web.domain.amqp.TG7Message;
import com.sngt.taxis.stargui.web.domain.amqp.TG7MessageUtils;
import com.sngt.taxis.stargui.web.domain.ui.AckWSMessage;
import com.sngt.taxis.stargui.web.services.AMQPService;
import com.sngt.taxis.stargui.web.services.amqp.AMQPDataParser;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.web.bind.annotation.*;

import static com.sngt.taxis.stargui.web.StarGuiWebApplication.BASE_URL;

/**
 * Created by yvu on 18/08/2015.
 */
@RestController
public class StarGuiController {

    public static final Logger LOGGER = LoggerFactory.getLogger(StarGuiController.class);
    private static final String CHANNEL_URL = "channels";
    private static final String PARSE_URL = "parse";
    private static final String SEND_URL = "send";

    @Autowired
    private AMQPService amqpService;

    @RequestMapping(method = RequestMethod.POST, value = BASE_URL + CHANNEL_URL + "/{channel}")
    public void connectToChannel(@PathVariable String channel) {
        LOGGER.info("[IN] connectToChannel [{}]", channel);
        amqpService.startConsuming(channel);
        LOGGER.info("[OUT] connectToChannel", channel);
    }

    @RequestMapping(method = RequestMethod.DELETE, value = BASE_URL + CHANNEL_URL + "/{channel}")
    public void disconnectFromChannel(@PathVariable String channel) {
        LOGGER.info("[IN] disconnectFromChannel [{}]", channel);
        amqpService.stopConsuming(channel);
        LOGGER.info("[OUT] disconnectFromChannel", channel);
    }

    @RequestMapping(method = RequestMethod.GET, value = BASE_URL + PARSE_URL)
    public TG7Message parseMessage(@RequestBody String message) {
        LOGGER.debug("[IN] parseMessage [{}]", message);
        final AMQPDataParser amqpDataParser = new AMQPDataParser();
        final TG7Message tg7Message = amqpDataParser.parseIncommingMessage(message);
        LOGGER.debug("[OUT] parseMessage");
        return tg7Message;
    }

    @RequestMapping(method = RequestMethod.POST, value = BASE_URL + CHANNEL_URL + "/{channel}/" + SEND_URL)
    public void sendMessage(@PathVariable String channel, @RequestBody String message) {
        LOGGER.debug("[IN] sendMessage [{}]", message);
        amqpService.produceMessage(channel, addHeadingAndEnd(message));
        LOGGER.debug("[OUT] sendMessage");
//        return tg7Message;
    }

    @MessageMapping(WebSocketConfig.WSOCKS_PREFIX)
    public void ack(AckWSMessage ackWSMessage) {
        LOGGER.debug("[IN] ack message via websocket [{}]", ackWSMessage);
        amqpService.ackMessage(ackWSMessage.getChannel(),ackWSMessage.getType());
    }

    private String addHeadingAndEnd(String message) {
        return TG7MessageUtils.START_OF_HEADING + message + TG7MessageUtils.END_OF_TEXT;
    }
}