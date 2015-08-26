package com.sngt.taxis.stargui.web.services.amqp;

import com.sngt.taxis.stargui.web.domain.amqp.TG7Message;
import com.sngt.taxis.stargui.web.domain.amqp.TG7MessageUtils;
import com.sngt.taxis.stargui.web.domain.messages.MQMessageType;
import org.junit.Before;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;


/**
 * Created by yvu on 19/08/2015.
 */
public class AMQPDataParserTest {

    private AMQPDataParser amqpDataParser;

    @Before
    public void setUp() throws Exception {
        amqpDataParser = new AMQPDataParser();
    }

    @Test
    public void sign_in() {
        final String input = addHeadingAndEnd(
                "0C3004CF00210000{\"loc\":{\"d\":39291,\"L\":48.8990194,\"l\":2.304231},\"s\":39301,\"t\":\"I\",\"cv\":\"cartoVersion\",\"c\":1,\"stv\":\"starVersion\",\"sydv\":\"sygicSdkVersion\",\"syv\":\"sygicVersion\",\"tpev\":\"tpeVersion\"}"
        );
        final TG7Message tg7Message = amqpDataParser.parseIncommingMessage(input);
        assertThat(tg7Message.getMsgType()).isEqualTo(MQMessageType.SIGN_IN);
    }


    @Test
    public void hia() {
        final String input = addHeadingAndEnd(
                "0720079F00320000{\"loc\":{\"d\":52974,\"L\":48.8989276,\"l\":2.3033609},\"s\":53003,\"t\":\"I\",\"st\":\"D\",\"op\":208016303599212}"
        );
        final TG7Message tg7Message = amqpDataParser.parseIncommingMessage(input);
        assertThat(tg7Message.getMsgType()).isEqualTo(MQMessageType.HIA);
    }

    @Test
    public void wut() {
        final String input = addHeadingAndEnd(
                "029004D200220600{\"p\":\"A\",\"m\":\"PRESENT\"}"
        );
        final TG7Message tg7Message = amqpDataParser.parseIncommingMessage(input);
//        assertThat(tg7Message.getMsgType()).isEqualTo(MQMessageType.HIA);
    }

    private String addHeadingAndEnd(String message) {
        return TG7MessageUtils.START_OF_HEADING + message + TG7MessageUtils.END_OF_TEXT;
    }


    /**
     * PROXY_D :: To TAXIPACK << 072004CF00320000{"loc":{"d":51494,"L":48.8990126,"l":2.3042821},"s":51551,"t":"I","st":"S","op":208016303599213}
     2015-08-19 14:19:15.144  - PROXY_D :: FROM START2015 >> MID [1231]  CONNECTING...
     2015-08-19 14:19:15.304  - PROXY_D :: FROM START2015 >> MID [1231]  CONNECTED
     2015-08-19 14:19:35.166  - PROXY_D :: To TAXIPACK << 0C4004CF00210000{"loc":{"d":51494,"L":48.8990126,"l":2.3042821},"s":51573,"t":"I","cv":"cartoVersion","c":1,"stv":"starVersion","sydv":"sygicSdkVersion","syv":"sygicVersion","tpev":"tpeVersion"}
     2015-08-19 14:19:35.370  - PROXY_D :: FROM TAXIPACK >> 051004CF00021001{"fl":2,"co":"jour","navi":{"nav":false,"cy":false,"ht":false}}
     2015-08-19 14:19:35.379  - [ ack for message:[deliveryTag =85]
     2015-08-19 14:19:35.688  - PROXY_D :: To TAXIPACK << 060004CF00400000{"loc":{"d":51494,"L":48.8990126,"l":2.3042821},"s":51574,"t":"I","mt":"0210"}
     */

/**
    2015-08-20 13:34:26.400  - PROXY_D :: To TAXIPACK << 0C4004D200210000{"loc":{"d":51494,"L":48.8990126,"l":2.3042821},"s":51573,"t":"I","cv":"cartoVersion","c":1,"stv":"starVersion","sydv":"sygicSdkVersion","syv":"sygicVersion","tpev":"tpeVersion"}
    2015-08-20 13:34:27.212  - PROXY_D :: FROM TAXIPACK >> 0ae004D200021001{"fl":5,"co":"jour","navi":{"nav":false,"cy":false,"ht":false},"cpam":true,"n":"REGGAD","p":"RACHID","id":"752579136","im":"AR143WX","
        li":"6219","fa":"335"}
        2015-08-20 13:34:27.213  - [ ack for message:[deliveryTag =89]
        2015-08-20 13:34:27.214  - PROXY_D :: FROM TAXIPACK >> 029004D200220600{"p":"A","m":"PRESENT"}
        2015-08-20 13:34:27.215  - [ ack for message:[deliveryTag =90]
 */
}