package io.github.madushanka.webmvc.dao.custom;

import io.github.madushanka.webmvc.dao.SuperDAO;
import io.github.madushanka.webmvc.entity.CustomEntity;

import java.util.List;

public interface QueryDAO extends SuperDAO {

    List<CustomEntity> getOrderInfo() throws Exception;

}
