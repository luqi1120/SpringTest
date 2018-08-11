package org.litespring.tx;

import org.litespring.utils.MessageTracker;

/**
 * 用来模式事务,日志之类的操作
 *
 * @author luqi
 * @data 2018/8/11
 */
public class TransactionManager {

    public void start() {
        System.out.println("start tx");
        MessageTracker.addMsg("start tx");
    }

    public void commit() {
        System.out.println("commit tx");
        MessageTracker.addMsg("commit tx");
    }

    public void rollback() {
        System.out.println("rollback tx");
        MessageTracker.addMsg("rollback tx");
    }
}
