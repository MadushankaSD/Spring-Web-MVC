package io.github.madushanka.webmvc.controller;

import io.github.madushanka.webmvc.business.custom.ItemBO;
import io.github.madushanka.webmvc.dto.CustomerDTO;
import io.github.madushanka.webmvc.dto.ItemDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("api/v1/items")
public class ItemController {

    @Autowired
    private ItemBO itemBO;

    @PutMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public void saveItem(@RequestBody ItemDTO item) {
        itemBO.saveItem(item);
    }

    @GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ItemDTO getItem(@PathVariable String id) {
        return itemBO.findItem(id);
    }

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public List<ItemDTO> getAllItems() {
        return itemBO.findAllItems();
    }

    @DeleteMapping(value = "/{id}")
    public void deleteItem(@PathVariable String id) {
        itemBO.deleteItem(id);
    }

    @PutMapping(value = "/{id}", consumes = MediaType.APPLICATION_JSON_VALUE)
    public void updateItem( @RequestBody ItemDTO item) {
        itemBO.updateItem(item);
    }

    @GetMapping(params = {"last"})
    public String getLastItemId() {
        return itemBO.getLastItemCode();
    }

    @GetMapping(params = {"full"})
    public List<String> getAllId() {
        return itemBO.getAllItemCodes();
    }
}
