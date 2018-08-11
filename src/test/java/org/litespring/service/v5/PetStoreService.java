package org.litespring.service.v5;

import org.litespring.beans.factory.annotation.Autowired;
import org.litespring.dao.v4.AccountDao;
import org.litespring.dao.v4.ItemDao;
import org.litespring.stereotype.Component;
import org.litespring.utils.MessageTracker;

@Component(value = "petStore")
public class PetStoreService {

    @Autowired
    AccountDao accountDao;

    @Autowired
    ItemDao itemDao;

    public PetStoreService() {

    }

    public ItemDao getItemDao() {
        return itemDao;
    }

    public AccountDao getAccountDao() {
        return accountDao;
    }

    /**
     * 新增加一个方法，表明这里要执行业务逻辑
     */
    public void placeOrder() {
        System.out.println("place order");
        MessageTracker.addMsg("place order");
    }


}