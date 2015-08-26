package com.sngt.taxis.stargui.web;

import org.junit.Test;

import java.io.*;
import java.net.Socket;

/**
 * Created by yvu on 10/08/2015.
 */
public class WingClientTests {

//    @Test
//    public void connectTest() {
//        try (Socket socket = new Socket(
//                "172.27.30.20",
//                10000);
//             BufferedReader reader = new BufferedReader(
//                     new InputStreamReader(socket.getInputStream()));
//             PrintWriter writer = new PrintWriter(
//                     new BufferedWriter(new OutputStreamWriter(socket.getOutputStream())),
//                     false)
//        ) {
//            System.out.println("CONNECTED TO WING !!!");
//
//            final String signUp = "#01" + cchf + "*" + "1.17.04" + GPS_Msg(current_tab) + mdt[current_tab].meter_status;
//            final WingPacket wingPacket = new WingPacket(signUp, 1, (short) 1, WingMessageType.NULL_MSG, WingControl.NONE);
//            writer.println(wingPacket.toWingMessage());
//            writer.flush();
//
//            char[] cbufSize = new char[6];
//            reader.read(cbufSize, 0, 6);
//            int offset = 0;
//            while (cbufSize[offset] == '0') {
//                ++offset;
//            }
//            int bufSize = Integer.parseInt(new String(cbufSize, offset, 6 - offset));
//
//            char[] cbufData = new char[bufSize];
//            reader.read(cbufData, 0, bufSize);
//
//            final String response = (new String(cbufData, 0, bufSize)).replaceAll("\n", "");
//            System.out.println(response);
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//    }

    class WingPacket {
        private final int mdt; // 4
        private final short sequence; // 2
        private final WingMessageType type;// = WingMessageType.NULL_MSG; // 2
        private final WingControl control;// = WingControl.NONE; // 1
        private final String body;

        public String toWingMessage() {
            return mdt + body.length() + sequence + type.getFct() + control.getControl() + body;
        }

        public WingPacket(String body, int mdt, short sequence, WingMessageType type, WingControl control) {
            this.body = body;
            this.mdt = mdt;
            this.sequence = sequence;
            this.type = type;
            this.control = control;
        }
    }

    enum WingMessageType {
        NULL_MSG(0x1234);

        WingMessageType(int fct) {
            this.fct = (short) fct;
        }

        private short fct;

        public short getFct() {
            return fct;
        }
    }

    enum WingControl {
        NONE(0x00);

        WingControl(int control) {
            this.control = (byte) control;
        }

        private byte control;

        public byte getControl() {
            return control;
        }
    }
}

