package io.github.madushanka.webmvc.dao.custom.impl;



import io.github.madushanka.webmvc.dao.custom.QueryDAO;
import io.github.madushanka.webmvc.entity.CustomEntity;
import io.github.madushanka.webmvc.entity.OrderDetail;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.NativeQuery;
import org.hibernate.query.Query;
import org.hibernate.transform.Transformers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class QueryDAOImpl implements QueryDAO {

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public List<CustomEntity> getOrderInfo(String query)  {
        NativeQuery ps = getSession().createNativeQuery("SELECT OD.Order_id as orderId, o.date as orderDate , C.customerId as customerId , C.name as customerName , (OD.qty*OD.unitPrice) AS orderTotal FROM Customer C INNER JOIN `order` o on C.customerId = o.customerID INNER JOIN OrderDetail OD on o.id = OD.Order_id INNER JOIN Item I on OD.Item_id = I.code WHERE o.id LIKE ? OR C.customerId LIKE ? OR C.name LIKE ? OR o.date LIKE ?");
        ps.setParameter(1, "%" + query + "%");
        ps.setParameter(2, "%" + query + "%");
        ps.setParameter(3, "%" + query + "%");
        ps.setParameter(4, "%" + query + "%");

        Query<CustomEntity> dta = ps.setResultTransformer(Transformers.aliasToBean(CustomEntity.class));
        List<CustomEntity> list = dta.list();
        return list;
}
    @Override
    public Session getSession() {
        return sessionFactory.getCurrentSession();
    }
}
