package org.litespring.utils;

import java.util.ArrayList;
import java.util.List;

/**
 * @author luqi
 * @data 2018/8/11
 */
public class MessageTracker {

    private static List<String> MESSAGES = new ArrayList<String>();

    public static void addMsg(String msg) {
        MESSAGES.add(msg);
    }

    public static void clearMsgs() {
        MESSAGES.clear();
    }

    public static List<String> getMsgs() {
        return MESSAGES;
    }
}
