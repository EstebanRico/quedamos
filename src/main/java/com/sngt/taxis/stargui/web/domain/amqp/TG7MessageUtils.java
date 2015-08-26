package com.sngt.taxis.stargui.web.domain.amqp;

import com.sngt.taxis.stargui.web.domain.messages.MQMessageType;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public final class TG7MessageUtils {
    private static final Logger LOGGER = LoggerFactory.getLogger(TG7MessageUtils.class);
    public static final int FIRST_INDEX = 0;
    public static final int BASE16 = 16;
    public static final String JSON_START_DELIMITER = "{";
    public static final String JSON_END_DELIMITER = "}";
    public static final int MID_BEGIN_INDEX = 4;
    public static final String HEXASUFIX = "X";
    public static final String HEXAPREFIX = "%0";
    public static final char START_OF_HEADING = 1;
    public static final char END_OF_TEXT = 3;

    private static void buildHeader(final HeaderEnum headEnum, final Header header, final String value) {
        switch (headEnum) {
            case SIZE: {
                header.setSize(Long.parseLong(value, BASE16));
                break;
            }
            case MID: {
                header.setMid(Long.parseLong(value, BASE16));
                break;
            }
            case PACKID: {
                header.setIdPackage(Long.parseLong(value, BASE16));
                break;
            }
            case TYPE: {
                header.setType(value);
                break;
            }
            case RESP: {
                header.setIdResponse(Long.parseLong(value, BASE16));
                break;
            }
        }
    }

    private static String encodeHeader(final Header header) {
        final StringBuilder sb = new StringBuilder();
        sb.append(String.format(HEXAPREFIX + HeaderEnum.SIZE.getCharNumber() + HEXASUFIX, header.getSize()));
        sb.append(String.format(HEXAPREFIX + HeaderEnum.MID.getCharNumber() + HEXASUFIX, header.getMid()));
        sb.append(String.format(HEXAPREFIX + HeaderEnum.PACKID.getCharNumber() + HEXASUFIX, header.getIdPackage()));
        sb.append(header.getType());
        sb.append(String.format(HEXAPREFIX + HeaderEnum.RESP.getCharNumber() + HEXASUFIX, header.getIdResponse()));
        validateHeader(sb.toString());
        return sb.toString();
    }

    public static Header decodeHeader(final String header) {
        final Header head = new Header();
        String headerVal = header;
        for (final HeaderEnum element : HeaderEnum.values()) {
            final String value = headerVal.substring(FIRST_INDEX, element.getCharNumber());
            headerVal = headerVal.substring(element.getCharNumber());
            buildHeader(element, head, value);
        }
        return head;
    }

    private static void validateHeader(final String header) {
        if (header.length() != HeaderEnum.getHeaderCharNumber()) {
            throw new RuntimeException("longeur de l'entete non conforme aux " + HeaderEnum.getHeaderCharNumber() + "caracteres attendus");
        }
    }

    public static String decodeMobileId(final String message) {
        final String mid = message.substring(MID_BEGIN_INDEX, HeaderEnum.MID.getCharNumber() + MID_BEGIN_INDEX);
        return String.valueOf(Long.parseLong(mid, BASE16));
    }

    public static TG7Message buildTG7Message(final String message) {
        if (message == null) {
            TG7MessageUtils.LOGGER.error("Error message null");
            return null;
        }
        if (StringUtils.isEmpty(message)) {
            TG7MessageUtils.LOGGER.error("Error message vide");
            return null;
        }
        if (message.length() < HeaderEnum.getHeaderCharNumber() + 2) {
            TG7MessageUtils.LOGGER.error("Error ::longueur minimale non respectee");
            return null;
        }
        if (!message.contains(JSON_START_DELIMITER) && !message.contains(JSON_END_DELIMITER)) {
            TG7MessageUtils.LOGGER.error("Error ::Le format de votre message est incorrect [" + message + "]");
            return null;
        }
        final TG7Message tgMsg = new TG7Message();
        final String stringHeader = message.substring(1, message.indexOf(JSON_START_DELIMITER));
        final String payloadAndExt = message.substring(HeaderEnum.getHeaderCharNumber() + 1);
        validateHeader(stringHeader);
        final Header header = decodeHeader(stringHeader);
        tgMsg.setHeader(header);
        tgMsg.setMsgType(MQMessageType.getMQMessageType(header.getType()));
        tgMsg.setPayload(payloadAndExt.substring(FIRST_INDEX, payloadAndExt.length() - 1));
        return tgMsg;
    }

    public static String buildBrokerMessage(final TG7Message tg7Message) {
        final String stringHeader = encodeHeader(tg7Message.getHeader());
        final String payload = tg7Message.getPayload();
        return TG7MessageUtils.START_OF_HEADING + stringHeader + payload + TG7MessageUtils.END_OF_TEXT;
    }
}
