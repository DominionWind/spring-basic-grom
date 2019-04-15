package com.Lesson2.HW2;

import java.util.List;

public interface ItemService {
    Item addItem(Item item);
    void delete(long id);
    Item getByName(String name);
    Item updateItem(Item item);
    List<Item> getAll();
}
