package io.github.madushanka.webmvc.business.custom;


import io.github.madushanka.webmvc.business.SuperBO;
import io.github.madushanka.webmvc.dto.ItemDTO;

import java.util.List;

public interface ItemBO extends SuperBO {

    void saveItem(ItemDTO itemDTO) ;

    void updateItem(ItemDTO item) ;

    void deleteItem(String itemCode);

    List<ItemDTO> findAllItems() ;

    String getLastItemCode() ;

    ItemDTO findItem(String itemCode) ;

    List<String> getAllItemCodes() ;

}
