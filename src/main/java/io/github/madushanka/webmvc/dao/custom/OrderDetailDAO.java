package io.github.madushanka.webmvc.dao.custom;

import io.github.madushanka.webmvc.dao.CrudDAO;
import io.github.madushanka.webmvc.entity.OrderDetail;
import io.github.madushanka.webmvc.entity.OrderDetailPK;

public interface OrderDetailDAO extends CrudDAO<OrderDetail, OrderDetailPK> {

    boolean existsByItemCode(String itemCode) throws Exception;

}
