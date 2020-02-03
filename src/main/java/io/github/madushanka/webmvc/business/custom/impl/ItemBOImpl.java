package io.github.madushanka.webmvc.business.custom.impl;

import io.github.madushanka.webmvc.business.custom.ItemBO;
import io.github.madushanka.webmvc.dao.custom.ItemDAO;
import io.github.madushanka.webmvc.dao.custom.OrderDetailDAO;
import io.github.madushanka.webmvc.dto.ItemDTO;
import io.github.madushanka.webmvc.entity.Item;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Transactional
@Component
public class ItemBOImpl implements ItemBO {

    @Autowired
    private OrderDetailDAO orderDetailDAO ;
    @Autowired
    private ItemDAO itemDAO ;

    @Override
    public void saveItem(ItemDTO item)  {
            itemDAO.save(new Item(item.getCode(),
                    item.getDescription(), item.getUnitPrice(), item.getQtyOnHand()));

    }

    @Override
    public void updateItem(ItemDTO item)  {

            itemDAO.update(new Item(item.getCode(),
                    item.getDescription(), item.getUnitPrice(), item.getQtyOnHand()));
    }

    @Override
    public void deleteItem(String itemCode)  {

            if (orderDetailDAO.existsByItemCode(itemCode)) {
                new Alert(Alert.AlertType.WARNING,"Item already exists in an order, hence unable to delete", ButtonType.OK).show();
            }
            else {
                itemDAO.delete(itemCode);
            }
    }

    @Override
    public List<ItemDTO> findAllItems()  {
            List<Item> allItems = itemDAO.findAll();
            List<ItemDTO> dtos = new ArrayList<>();
            for (Item item : allItems) {
                dtos.add(new ItemDTO(item.getCode(),
                        item.getDescription(),
                        item.getQtyOnHand(),
                        item.getUnitPrice()));
            }

            return dtos;

    }

    @Override
    public String getLastItemCode()  {
            String lastItemCode = itemDAO.getLastItemCode();
            return lastItemCode;
    }

    @Override
    public ItemDTO findItem(String itemCode)  {

            Item item = itemDAO.find(itemCode);

            return item!=null?new ItemDTO(item.getCode(),
                    item.getDescription(),
                    item.getQtyOnHand(),
                    item.getUnitPrice()):null;

    }

    @Override
    public List<String> getAllItemCodes()  {
            List<Item> allItems = itemDAO.findAll();

            List<String> codes = new ArrayList<>();
            for (Item item : allItems) {
                codes.add(item.getCode());
            }
            return codes;
    }
}
