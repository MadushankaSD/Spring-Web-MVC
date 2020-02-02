package io.github.madushanka.webmvc.dao.custom.impl;

import io.github.madushanka.webmvc.dao.CrudDAOImpl;
import io.github.madushanka.webmvc.dao.custom.ItemDAO;
import io.github.madushanka.webmvc.entity.Item;
import org.springframework.stereotype.Repository;

@Repository
public class ItemDAOImpl extends CrudDAOImpl<Item,String> implements ItemDAO {

    @Override
    public String getLastItemCode() throws Exception {
       return (String) getSession().createNativeQuery("SELECT code FROM Item ORDER BY code DESC LIMIT 1").uniqueResult();
    }

}
