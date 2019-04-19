package com.Lesson2.HW2;
import java.util.List;

public class ItemService {

    private ItemDAO itemDAO = new ItemDAO();

    public Item saveI(Item item){
        return itemDAO.save(item);
    }

    public Item updateI(Item item){
        return itemDAO.update(item);
    }

    public void deleteI(long id)throws Exception{
        itemDAO.delete(id);
    }

    public Item findByIdI(long id) throws Exception{
        return itemDAO.findById(id);
    }

    public List<Item> getAllI(){
        return itemDAO.getAllItem();
    }
}
