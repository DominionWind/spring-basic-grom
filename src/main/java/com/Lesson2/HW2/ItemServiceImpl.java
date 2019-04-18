package com.Lesson2.HW2;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller
public class ItemServiceImpl implements ItemService {

    @Autowired
    private ItemRepository itemRepository;

    @Override
    public Item addItem(Item item) {
        Item saveItem = itemRepository.saveAndFlush(item);
        return saveItem;
    }

    @Override
    public void delete(long id) {
        itemRepository.delete(id);
    }

    @Override
    public Item getByName(String name) {
        return itemRepository.getByName(name);
    }

    @Override
    public Item updateItem(Item item) {
        return itemRepository.saveAndFlush(item);
    }

    @Override
    public List<Item> getAll() {
        return itemRepository.findAll();
    }

}
