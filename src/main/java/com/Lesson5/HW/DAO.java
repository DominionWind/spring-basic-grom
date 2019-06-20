package com.Lesson5.HW;

import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

@Repository
@Transactional
public class DAO {

    @PersistenceContext
    private EntityManager entityManager;

    public Item save(Item item){
        entityManager.persist(item);
        return item;
    }

    public Item update(Item item){
        entityManager.merge(item);
        return item;
    }

    public void delete(Long id){
        entityManager.remove(getById(id));
    }

    public Item getById(Long id){
        return entityManager.find(Item.class, id);
    }
}
