package io.github.madushanka.webmvc.dao.custom;


import io.github.madushanka.webmvc.dao.CrudDAO;
import io.github.madushanka.webmvc.entity.Item;

public interface ItemDAO extends CrudDAO<Item, String> {

    String getLastItemCode() ;
}
