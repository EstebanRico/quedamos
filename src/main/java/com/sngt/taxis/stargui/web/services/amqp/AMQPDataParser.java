package com.sngt.taxis.stargui.web.services.amqp;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.common.base.Charsets;
import com.rabbitmq.client.AMQP;
import com.rabbitmq.client.Envelope;
import com.sngt.taxis.stargui.web.domain.amqp.Header;
import com.sngt.taxis.stargui.web.domain.amqp.HeaderEnum;
import com.sngt.taxis.stargui.web.domain.amqp.TG7Message;
import com.sngt.taxis.stargui.web.domain.amqp.TG7MessageUtils;
import com.sngt.taxis.stargui.web.domain.messages.*;
import com.sngt.taxis.stargui.web.services.AMQPService;
import org.apache.commons.lang3.RandomUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.simp.SimpMessageSendingOperations;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.io.StringWriter;
import java.io.Writer;

/**
 * Created by yvu on 17/08/2015.
 */
@Component
public class AMQPDataParser {

    @Autowired
    private SimpMessageSendingOperations messagingTemplate;

    private ObjectMapper mapper = new ObjectMapper();

    public void doConsumeData(Envelope envelope, AMQP.BasicProperties basicproperties, Object message) {
        try {
//            mDispatcher.executeHandler(tg7Message);
//            AbstractFacadeSendMessage.RETRY_INF.sendACK(mApplicationContext, tg7Message.getHeader().getType(), l, EntityBuilder.getLastValidLocation(mApplicationContext));
            final TG7Message tg7Message = parseIncommingMessage((String) message);
            //send result to topic
            final String topic = "/topic/incoming/" + tg7Message.getHeader().getMid();
            this.messagingTemplate.convertAndSend(topic, tg7Message);
        }
        // Misplaced declaration of an exception variable
        catch (Exception e) {
            AMQPService.LOGGER.error("Exception !!!", e);
        }
    }

    public TG7Message parseIncommingMessage(final String message) {
        final TG7Message tg7msg = TG7MessageUtils.buildTG7Message(message);
        AMQPService.LOGGER.info("message consumed : {}", tg7msg);
        final String payload = tg7msg.getPayload();
        final MQMessageType msgType = tg7msg.getMsgType();
        final String enteteTrace = "mid[" + tg7msg.getHeader().getMid() + "] " + msgType + " message[{}]";
        try {
            switch (msgType) {
//                case 1: {
//                    break;
//                }
                /**
                 * message vers taxipak
                 */
                case SIGN_OFF: {
                    final SignOffEntity signOffEntity = mapper.readValue(payload, SignOffEntity.class);
                    tg7msg.setEntity(signOffEntity);
                    AMQPService.LOGGER.info(enteteTrace, signOffEntity);
                    break;
                }
                case ZONE_INFO: {
                    final ZoneInfoEntity zoneInfoEntity = mapper.readValue(payload, ZoneInfoEntity.class);
                    tg7msg.setEntity(zoneInfoEntity);
                    AMQPService.LOGGER.info(enteteTrace, zoneInfoEntity);
                    break;
                }
                case ACK: {
                    final ACKEntity ackEntity = mapper.readValue(payload, ACKEntity.class);
                    tg7msg.setEntity(ackEntity);
                    AMQPService.LOGGER.info(enteteTrace, ackEntity);
                    break;
                }
                case BOOK_IN: {
//                    final TaxiModel taxi = this.findTaxi(tg7msg);
//                    if (taxi != null) {
//                        try {
//                            final JSONObject jsonObj = new JSONObject(payload);
//                            final String zone = jsonObj.get("an");
                    final BookInEntity bookInEntity = mapper.readValue(payload, BookInEntity.class);
                    tg7msg.setEntity(bookInEntity);
//                            if (taxi.getStatus().equals(MQMessageType.PAUSE.getLibelle())) {
//                                taxi.setStatus("Occup\u00e9");
//                                AMQPService.LOGGER.info("Occupe" + bookInEntity);
//                            } else {
//                                taxi.setStatus(MQMessageType.BOOK_IN.getStatus() + zone);
//                                taxi.setZone(zone);
                    AMQPService.LOGGER.info(enteteTrace, bookInEntity);
//                            }
//                        } catch (JSONException e1) {
//                            AMQPService.LOGGER.error("erreur Inscription en zone :" + e1);
//                        }
//                        break;
//                    }
//                    AMQPService.LOGGER.warn("Le taxi MID=" + tg7msg.getHeader().getMid() + " Tente de s'inscrire en zone sans etre identifi\u00e9 ");
                    break;
                }
                case BOOK_OFF: {
                    final BookOffEntity bookOffEntity = mapper.readValue(payload, BookOffEntity.class);
                    tg7msg.setEntity(bookOffEntity);
                    AMQPService.LOGGER.info(enteteTrace, bookOffEntity);
//                    final TaxiModel taxi = this.findTaxi(tg7msg);
//                    if (taxi != null) {
//                        taxi.setStatus(MQMessageType.SIGN_IN.getStatus());
//                        break;
//                    }
//                    AMQPService.LOGGER.warn(enteteTrace + tg7msg.getHeader().getMid() + "] Tente d'envoyer un message \"BOOK_OFF\" sans etre identifi\u00e9 ");
                    break;
                }
                case ENDIRECTION: {
//                    final TaxiModel taxi = this.findTaxi(tg7msg);
//                    if (taxi != null) {
//                        try {
                    final EnDirectionEntity enDirectionEntity = mapper.readValue(payload, EnDirectionEntity.class);
                    tg7msg.setEntity(enDirectionEntity);
//                            final JSONObject jsonObj = new JSONObject(payload);
//                            final String zone = jsonObj.get("an");
//                            if (zone.equals("60")) {
//                                taxi.setStatus(taxi.getStatus() + " * ");
//                                AMQPService.LOGGER.info(enteteTrace + " Using Bonus ...");
//                            } else {
//                                if (taxi.getStatus().contains(" * ")) {
//                                    taxi.setStatus(MQMessageType.ENDIRECTION.getStatus() + zone + " Use Bonus ");
//                                } else {
//                                    taxi.setStatus(MQMessageType.ENDIRECTION.getStatus() + zone);
//                                }
//                                taxi.setZone(zone);
                    AMQPService.LOGGER.info(enteteTrace, enDirectionEntity);
//                            }
//                        } catch (JSONException e1) {
//                            AMQPService.LOGGER.error("erreur Pr\u00e9inscription en zone :" + e1);
//                        }
//                        break;
//                    }
//                    AMQPService.LOGGER.warn("Le taxi MID=" + tg7msg.getHeader().getMid() + " Tente de se pr\u00e9inscrir en zone sans etre identifi\u00e9 ");
                    break;
                }
                case GPS_UPDATE: {
                    final GPSUpdateEntity gpsUpdateEntity = mapper.readValue(payload, GPSUpdateEntity.class);
                    tg7msg.setEntity(gpsUpdateEntity);
                    AMQPService.LOGGER.info(enteteTrace, gpsUpdateEntity);
                    break;
                }
                case REJECT_OFFER: {
                    final RejectOfferEntity rejectOfferEntity = mapper.readValue(payload, RejectOfferEntity.class);
                    tg7msg.setEntity(rejectOfferEntity);
                    AMQPService.LOGGER.info(enteteTrace, rejectOfferEntity);
//                    final TaxiModel taxi = this.findTaxi(tg7msg);
//                    if (taxi != null) {
//                        taxi.setStatus(MQMessageType.BOOK_IN.getStatus() + " (Apres REJECT_OFFER)");
//                        break;
//                    }
//                    AMQPService.LOGGER.warn("Le taxi MID[" + tg7msg.getHeader().getMid() + "] Tente de passer \"en REJECT_OFFER\" sans etre identifi\u00e9 ");
                    break;
                }
                case SIGN_IN: {
                    final SignInEntity signInEntity = mapper.readValue(payload, SignInEntity.class);
                    tg7msg.setEntity(signInEntity);
                    AMQPService.LOGGER.info(enteteTrace, signInEntity);
//                    TaxiModel taxi = this.findTaxi(tg7msg);
//                    if (taxi == null) {
//                        taxi = new TaxiModel();
//                        taxi.getFlottes().add("Entiere");
//                        taxi.setFlotte("Entiere");
//                        taxi.setMid(String.valueOf(tg7msg.getHeader().getMid()));
//                        taxi.setTaximetreState("Libre");
//                    } else {
//                        AMQPService.LOGGER.info(enteteTrace + " Attention, votre session precedente n'a pas ete traite proprement (Veuillez prochainement faire un DEAUTH proprement)");
//                    }
//                    taxi.setStatus("Demande d'identification");
//                    taxi.setZone("NA");
//                    this.taxiList.add(taxi);
                    break;
                }
                case NO_ACCEPT: {
                    final NonAcceptEntity nonAcceptEntity = mapper.readValue(payload, NonAcceptEntity.class);
                    tg7msg.setEntity(nonAcceptEntity);
                    AMQPService.LOGGER.info(enteteTrace, nonAcceptEntity);
//                    final TaxiModel taxi = this.findTaxi(tg7msg);
//                    if (taxi != null) {
//                        taxi.setStatus(MQMessageType.SIGN_IN.getStatus());
//                        break;
//                    }
//                    AMQPService.LOGGER.warn(enteteTrace + tg7msg.getHeader().getMid() + "] Tente d'envoyer un message \"NO_ACCEPT\" sans etre identifi\u00e9 ");
                    break;
                }
                case ACCEPT: {
                    final AcceptEntity acceptEntity = mapper.readValue(payload, AcceptEntity.class);
                    tg7msg.setEntity(acceptEntity);
                    AMQPService.LOGGER.info(enteteTrace, acceptEntity);
//                    final TaxiModel taxi = this.findTaxi(tg7msg);
//                    if (taxi == null) {
//                        AMQPService.LOGGER.warn("Le taxi MID[" + tg7msg.getHeader().getMid() + "] Tente de passer \"en offre\" sans etre identifi\u00e9 ");
//                        break;
//                    }
                    break;
                }
                case DELAI: {
                    final DelaiEntity delai = mapper.readValue(payload, DelaiEntity.class);
                    tg7msg.setEntity(delai);
                    AMQPService.LOGGER.info(enteteTrace, delai);
//                    final TaxiModel taxi = this.findTaxi(tg7msg);
//                    if (taxi != null) {
//                        taxi.setDelai(delai.getTimeToGo() + " mn");
//                        break;
//                    }
//                    AMQPService.LOGGER.warn("Le taxi MID[" + tg7msg.getHeader().getMid() + "] Tente de publier \"DELAIS\" sans etre identifi\u00e9 ");
                    break;
                }
                case PAUSE: {
                    final PauseEntity pauseEntity = mapper.readValue(payload, PauseEntity.class);
                    tg7msg.setEntity(pauseEntity);
                    AMQPService.LOGGER.info(enteteTrace, pauseEntity);
//                    final TaxiModel taxi = this.findTaxi(tg7msg);
//                    if (taxi == null) {
//                        AMQPService.LOGGER.warn("Le taxi MID[" + tg7msg.getHeader().getMid() + "] Tente de passer en pause sans etre identifi\u00e9 ");
//                        break;
//                    }
//                    if (taxi.getStatus().contains(" * ")) {
//                        taxi.setStatus(MQMessageType.PAUSE.getStatus() + " Use Bonus ");
//                        break;
//                    }
//                    taxi.setStatus(MQMessageType.PAUSE.getStatus());
                    break;
                }
                case RANG: {
                    final RangEntity rangEntity = mapper.readValue(payload, RangEntity.class);
                    tg7msg.setEntity(rangEntity);
                    AMQPService.LOGGER.info(enteteTrace, rangEntity);
                    break;
                }
                case BASCULE: {
                    final BasculeEntity basculeEntity = mapper.readValue(payload, BasculeEntity.class);
                    tg7msg.setEntity(basculeEntity);
                    AMQPService.LOGGER.info(enteteTrace, basculeEntity);
//                    final TaxiModel taxi = this.findTaxi(tg7msg);
//                    if (taxi != null) {
//                        final String[] flottes = taxi.getFlotte().split(",");
//                        if (taxi.getFlottes().size() == 2) {
//                            if (flottes.length == 2) {
//                                taxi.setFlotte((String) taxi.getFlottes().get(1));
//                            } else {
//                                taxi.setFlotte(taxi.getFlottes().get(0) + "," + taxi.getFlottes().get(1));
//                            }
//                        }
//                        break;
//                    }
                    break;
                }
                case SUR_PLACE: {
                    final SurPlace surPlace = mapper.readValue(payload, SurPlace.class);
                    tg7msg.setEntity(surPlace);
                    AMQPService.LOGGER.info(enteteTrace, surPlace);
//                    final TaxiModel taxi = this.findTaxi(tg7msg);
//                    if (taxi != null) {
//                        taxi.setStatus(MQMessageType.SUR_PLACE.getStatus());
//                        break;
//                    }
//                    AMQPService.LOGGER.warn("Le taxi MID[" + tg7msg.getHeader().getMid() + "] Tente de passer \"Sur Place\" sans etre identifi\u00e9 ");
                    break;
                }
                case NON_CHARGE: {
                    final NonCharge nonCharge = mapper.readValue(payload, NonCharge.class);
                    tg7msg.setEntity(nonCharge);
                    AMQPService.LOGGER.info(enteteTrace, nonCharge);
//                    final TaxiModel taxi = this.findTaxi(tg7msg);
//                    if (taxi == null) {
//                        AMQPService.LOGGER.warn("Le taxi MID[" + tg7msg.getHeader().getMid() + "] Tente de passer en \"Non Charge\" sans etre identifi\u00e9 ");
//                        break;
//                    }
                    break;
                }
                case CLIENT_A_BORD: {
                    final ClientABordEntity clientABordEntity = mapper.readValue(payload, ClientABordEntity.class);
                    tg7msg.setEntity(clientABordEntity);
                    AMQPService.LOGGER.info(enteteTrace, clientABordEntity);
//                    final TaxiModel taxi = this.findTaxi(tg7msg);
//                    if (taxi != null) {
//                        taxi.setStatus(MQMessageType.CLIENT_A_BORD.getStatus());
//                        break;
//                    }
//                    AMQPService.LOGGER.warn("Le taxi MID[" + tg7msg.getHeader().getMid() + "] Tente de passer en \"Client \u00e0 bord\" sans etre identifi\u00e9 ");
                    break;
                }
                case MESSAGE: {
                    final MessageEntity messageEntity = mapper.readValue(payload, MessageEntity.class);
                    tg7msg.setEntity(messageEntity);
                    AMQPService.LOGGER.info(enteteTrace, messageEntity);
//                    final TaxiModel taxi = this.findTaxi(tg7msg);
//                    if (taxi != null) {
//                        final JSONObject jsonObj2 = new JSONObject(payload);
//                        final String num = jsonObj2.get("n");
//                        if ("3".equals(num)) {
//                            AMQPService.LOGGER.info(enteteTrace + " Abandon de course :" + ((MessageEntity) mapper.readValue(payload,  MessageEntity.class)));
//                            taxi.setStatus("Abandon de course");
//                        } else if ("4".equals(num)) {
//                            AMQPService.LOGGER.info(enteteTrace + " Impossible de stationner :" + ((MessageEntity) mapper.readValue(payload,  MessageEntity.class)));
//                            taxi.setStatus("Impossible de stationner");
//                        } else if ("5".equals(num)) {
//                            AMQPService.LOGGER.info(enteteTrace + " Detail de course non recu :" + ((MessageEntity) mapper.readValue(payload,  MessageEntity.class)));
//                            taxi.setStatus("D\u00e9tail de course non re\u00e7u");
//                        }
//                        break;
//                    }
//                    AMQPService.LOGGER.warn("Le taxi MID[" + tg7msg.getHeader().getMid() + "] Tente de passer en \" Abandon de course ou Impossible de stationner\" sans etre identifi\u00e9 ");
                    break;
                }
                case VEH_IN: {
                    final RetourVehicule retourVehicule = mapper.readValue(payload, RetourVehicule.class);
                    tg7msg.setEntity(retourVehicule);
                    AMQPService.LOGGER.info(enteteTrace, retourVehicule);
//                    final TaxiModel taxi = this.findTaxi(tg7msg);
//                    if (taxi != null) {
//                        taxi.setStatus(MQMessageType.VEH_IN.getStatus());
//                        break;
//                    }
//                    AMQPService.LOGGER.warn("Le taxi MID[" + tg7msg.getHeader().getMid() + "] Tente de passer en \"Retour vehicule\" sans etre identifi\u00e9 ");
                    break;
                }
                case VEH_OUT: {
                    final VehOutEntity vehOutEntity = mapper.readValue(payload, VehOutEntity.class);
                    tg7msg.setEntity(vehOutEntity);
                    AMQPService.LOGGER.info(enteteTrace, vehOutEntity);
//                    final TaxiModel taxi = this.findTaxi(tg7msg);
//                    if (taxi != null) {
//                        taxi.setStatus(MQMessageType.VEH_OUT.getStatus());
//                        break;
//                    }
//                    AMQPService.LOGGER.warn("Le taxi MID[" + tg7msg.getHeader().getMid() + "] Tente de passer en \"Retour vehicule\" sans etre identifi\u00e9 ");
                    break;
                }
                case METTER: {
                    final Metter metter = mapper.readValue(payload, Metter.class);
                    tg7msg.setEntity(metter);
                    AMQPService.LOGGER.info(enteteTrace, metter);
//                    if (metter == null) {
//                        break;
//                    }
//                    final TaxiModel taxi = this.findTaxi(tg7msg);
//                    if (taxi == null) {
//                        break;
//                    }
//                    if (CharUtils.toString(metter.getTaximeterState()).equals("L")) {
//                        taxi.setTaximetreState("Libre");
//                        break;
//                    }
//                    if (CharUtils.toString(metter.getTaximeterState()).equals("C")) {
//                        if (taxi.getStatus().equals(MQMessageType.SIGN_IN.getStatus()) || taxi.getStatus().equals(MQMessageType.BOOK_IN.getStatus()) || taxi.getStatus().equals(MQMessageType.ENDIRECTION.getStatus())) {
//                            taxi.setTaximetreState("Occup\u00e9");
//                            taxi.setStatus("Client \u00e0 bord");
//                            break;
//                        }
//                        break;
//                    } else {
//                        if (CharUtils.toString(metter.getTaximeterState()).equals("D")) {
//                            taxi.setTaximetreState("D\u00fb");
//                            break;
//                        }
//                        break;
//                    }
                    break;
                }
                case RLV_NEW: {
                    final RLVNewEntity rlvNewEntity = mapper.readValue(payload, RLVNewEntity.class);
                    tg7msg.setEntity(rlvNewEntity);
                    AMQPService.LOGGER.info(enteteTrace, rlvNewEntity);
                    break;
                }
                case HIA: {
                    final HIAEntity hiaEntity = mapper.readValue(payload, HIAEntity.class);
                    tg7msg.setEntity(hiaEntity);
                    AMQPService.LOGGER.info(enteteTrace, hiaEntity);
                    break;
                }
                case DRIVER_QUERY: {
                    final DriverQueryEntity driverQueryEntity = mapper.readValue(payload, DriverQueryEntity.class);
                    tg7msg.setEntity(driverQueryEntity);
                    AMQPService.LOGGER.info(enteteTrace, driverQueryEntity);
                    break;
                }
                case CPAM_REQUEST: {
                    final CPAMRequestEntity cpamRequestEntity = mapper.readValue(payload, CPAMRequestEntity.class);
                    tg7msg.setEntity(cpamRequestEntity);
                    AMQPService.LOGGER.info(enteteTrace, cpamRequestEntity);
                    break;
                }
                case ALARME: {
                    final AlarmeEntity alarmeEntity = mapper.readValue(payload, AlarmeEntity.class);
                    tg7msg.setEntity(alarmeEntity);
                    AMQPService.LOGGER.info(enteteTrace, alarmeEntity);
                    break;
                }
//                case 29: {
//                    AMQPService.LOGGER.info(enteteTrace);
//                    break;
//                }
//                case 30: {
//                    AMQPService.LOGGER.info(enteteTrace);
//                    break;
//                }
//                case 31: {
//                    AMQPService.LOGGER.info(enteteTrace + " [RESP=" + tg7msg.getHeader().getIdResponse() + "]");
//                    break;
//                }
                case ABANDON_COURSE: {
                    final AbandonCourseEntity abandonCourseEntity = mapper.readValue(payload, AbandonCourseEntity.class);
                    tg7msg.setEntity(abandonCourseEntity);
                    AMQPService.LOGGER.info(enteteTrace, abandonCourseEntity);
                    break;
                }
                case STATIONNEMENT_IMPOSSIBLE: {
                    final StationnementImpossibleEntity stationnementImpossibleEntity = mapper.readValue(payload, StationnementImpossibleEntity.class);
                    tg7msg.setEntity(stationnementImpossibleEntity);
                    AMQPService.LOGGER.info(enteteTrace, stationnementImpossibleEntity);
                    break;
                }
                case RLV_CPAM: {
                    final RLVCPAMEntity rlvcpamEntity = mapper.readValue(payload, RLVCPAMEntity.class);
                    tg7msg.setEntity(rlvcpamEntity);
                    AMQPService.LOGGER.info(enteteTrace, rlvcpamEntity);
                    break;
                }
                case ENCHERE_ACCEPT: {
                    final EnchereAcceptEntity enchereAcceptEntity = mapper.readValue(payload, EnchereAcceptEntity.class);
                    tg7msg.setEntity(enchereAcceptEntity);
                    AMQPService.LOGGER.info(enteteTrace, enchereAcceptEntity);
                    break;
                }
                case STAT_DIST: {
                    final StatDistEntity statDistEntity = mapper.readValue(payload, StatDistEntity.class);
                    tg7msg.setEntity(statDistEntity);
                    AMQPService.LOGGER.info(enteteTrace, statDistEntity);
                    break;
                }
                /***
                 * messages de taxipak
                 */
                case ASSIGN_DISP: {
                    final AssignDispEntity assignDispEntity = mapper.readValue(payload, AssignDispEntity.class);
                    tg7msg.setEntity(assignDispEntity);
                    AMQPService.LOGGER.info(enteteTrace, assignDispEntity);
//                    final TaxiModel taxi = this.findTaxi(tg7Message);
//                    if (taxi != null) {
//                        taxi.setStatus(MQMessageType.ACCEPT.getStatus());
//                        break;
//                    }
                    break;
                }
                case STATUS_DISP: {
                    final StatusDispEntity statusDispEntity = mapper.readValue(payload, StatusDispEntity.class);
                    tg7msg.setEntity(statusDispEntity);
                    AMQPService.LOGGER.info(enteteTrace, statusDispEntity);
//                    AMQPService.LOGGER.info(logHead + statusDispEntity.toString());
//                    final TaxiModel taxi = this.findTaxi(tg7Message);
//                    if (taxi == null) {
//                        break;
//                    }
//                    if (taxi.getFlottes().size() == 2 && statusDispEntity.getRangAllFleet() != null) {
//                        taxi.setFlotte(taxi.getFlottes().get(0) + "," + taxi.getFlottes().get(1));
//                    }
//                    if (taxi.getStatus().equals(MQMessageType.PAUSE.getLibelle()) || taxi.getStatus().equals(MQMessageType.ENDIRECTION.getLibelle())) {
//                        taxi.setStatus(MQMessageType.ENDIRECTION.getStatus() + statusDispEntity.getZoneNumber());
//                        break;
//                    }
                    break;
                }
                case OFFER_DISP: {
                    final OfferDispEntity offerDispEntity = mapper.readValue(payload, OfferDispEntity.class);
                    tg7msg.setEntity(offerDispEntity);
                    AMQPService.LOGGER.info(enteteTrace, offerDispEntity);
//                    final TaxiModel taxi = this.findTaxi(tg7Message);
//                    if (taxi != null) {
//                        taxi.setStatus(MQMessageType.OFFER_DISP.getStatus());
//                        break;
//                    }
                    break;
                }
                case ACK_CENTRAL: {
                    final AckCentralEntity ackCentralEntity = mapper.readValue(payload, AckCentralEntity.class);
                    tg7msg.setEntity(ackCentralEntity);
                    AMQPService.LOGGER.info(enteteTrace, ackCentralEntity);
                    break;
                }
                case CHRONOMETER: {
                    final ChronometerEntity chronometerEntity = mapper.readValue(payload, ChronometerEntity.class);
                    tg7msg.setEntity(chronometerEntity);
                    AMQPService.LOGGER.info(enteteTrace, chronometerEntity);
                    break;
                }
                case PROMPT_DISP: {
                    final PromptDispEntity promptDispEntity = mapper.readValue(payload, PromptDispEntity.class);
                    tg7msg.setEntity(promptDispEntity);
                    AMQPService.LOGGER.info(enteteTrace, promptDispEntity);
                    break;
                }
                case INFO_CHAUFFEUR: {
                    final InfoChauffeurEntity infoChauffeurEntity = mapper.readValue(payload, InfoChauffeurEntity.class);
                    tg7msg.setEntity(infoChauffeurEntity);
                    AMQPService.LOGGER.info(enteteTrace, infoChauffeurEntity);
                    break;
                }
                case JOB_CPLT: {
                    final JobComplementEntity jobComplementEntity = mapper.readValue(payload, JobComplementEntity.class);
                    tg7msg.setEntity(jobComplementEntity);
                    AMQPService.LOGGER.info(enteteTrace, jobComplementEntity);
                    break;
                }
                case BONUS: {
                    final BonusEntity bonusEntity = mapper.readValue(payload, BonusEntity.class);
                    tg7msg.setEntity(bonusEntity);
                    AMQPService.LOGGER.info(enteteTrace, bonusEntity);
                    break;
                }
                case AUTORISE: {
                    final AutoriseEntity autorise = mapper.readValue(payload, AutoriseEntity.class);
                    tg7msg.setEntity(autorise);
                    AMQPService.LOGGER.info(enteteTrace, autorise);
//                    final TaxiModel taxi = this.findTaxi(tg7Message);
//                    taxi.setFlotte("Entiere");
//                    taxi.setStatus(MQMessageType.SIGN_IN.getStatus());
//                    if (autorise.getFlotte() != null && autorise.getFlotte() > 0) {
//                        taxi.getFlottes().add(FlottesEnum.getLibelleByIndex(autorise.getFlotte()).getLibelle());
//                        taxi.setFlotte(taxi.getFlotte() + "," + FlottesEnum.getLibelleByIndex(autorise.getFlotte()).getLibelle());
//                        break;
//                    }
                    break;
                }
                case EXPIRE: {
                    final ExpireEntity expireEntity = mapper.readValue(payload, ExpireEntity.class);
                    tg7msg.setEntity(expireEntity);
                    AMQPService.LOGGER.info(enteteTrace, expireEntity);
                    break;
                }
                case DEAUTH: {
                    final DEAuthEntity deAuthEntity = mapper.readValue(payload, DEAuthEntity.class);
                    tg7msg.setEntity(deAuthEntity);
                    AMQPService.LOGGER.info(enteteTrace, deAuthEntity);
//                    final TaxiModel taxi = this.findTaxi(tg7Message);
//                    if (taxi != null) {
//                        this.taxiList.remove(taxi);
//                        break;
//                    }
                    break;
                }
                case COURSE_ANNULEE: {
                    final CourseAnnuleeEntity courseAnnuleeEntity = mapper.readValue(payload, CourseAnnuleeEntity.class);
                    tg7msg.setEntity(courseAnnuleeEntity);
                    AMQPService.LOGGER.info(enteteTrace, courseAnnuleeEntity);
//                    final TaxiModel taxi = this.findTaxi(tg7Message);
//                    if (taxi != null) {
//                        taxi.setStatus(MQMessageType.COURSE_ANNULEE.getStatus());
//                        break;
//                    }
                    break;
                }
                case REDISPATCH: {
                    final RedispatchEntity redispatchEntity = mapper.readValue(payload, RedispatchEntity.class);
                    tg7msg.setEntity(redispatchEntity);
                    AMQPService.LOGGER.info(enteteTrace, redispatchEntity);
                    break;
                }
                case CPAM_REPLY: {
                    final CPAMReplyEntity cpamReplyEntity = mapper.readValue(payload, CPAMReplyEntity.class);
                    tg7msg.setEntity(cpamReplyEntity);
                    AMQPService.LOGGER.info(enteteTrace, cpamReplyEntity);
                    break;
                }
                case ZONE_BCST: {
                    final ZoneBcstEntity zoneBcstEntity = mapper.readValue(payload, ZoneBcstEntity.class);
                    tg7msg.setEntity(zoneBcstEntity);
                    AMQPService.LOGGER.info(enteteTrace, zoneBcstEntity);
                    break;
                }
                case PALMARES: {
                    final PalmaresListEntity palmaresListEntity = mapper.readValue(payload, PalmaresListEntity.class);
                    tg7msg.setEntity(palmaresListEntity);
                    AMQPService.LOGGER.info(enteteTrace, palmaresListEntity);
                    break;
                }
                case PRINT: {
                    final PrintEntity printEntity = mapper.readValue(payload, PrintEntity.class);
                    tg7msg.setEntity(printEntity);
                    AMQPService.LOGGER.info(enteteTrace, printEntity);
                    break;
                }
                case REFUS: {
                    final RefusEntity refusEntity = mapper.readValue(payload, RefusEntity.class);
                    tg7msg.setEntity(refusEntity);
                    AMQPService.LOGGER.info(enteteTrace, refusEntity);
                    break;
                }

                default: {
                    AMQPService.LOGGER.error("Unknown message" + enteteTrace);
                    break;
                }
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }

        return tg7msg;
    }

    public String convertToMessage(AbstractEntity entity) {
        final Writer writer = new StringWriter();
        final TG7Message tg7Message = new TG7Message();
        try {
            mapper.writeValue(writer, entity);
            final String payload = writer.toString();
            final Header head = new Header();
            head.setMid((long) entity.getMid());
            head.setIdPackage(RandomUtils.nextLong(1, 0xFF));
            head.setType(entity.getMessageType());
            head.setIdResponse(0L);
            head.setSize((long) (payload.getBytes(Charsets.UTF_8).length + HeaderEnum.getHeaderCharNumber() + 2));
            tg7Message.setHeader(head);
            tg7Message.setPayload(payload);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return TG7MessageUtils.buildBrokerMessage(tg7Message);
    }
}
