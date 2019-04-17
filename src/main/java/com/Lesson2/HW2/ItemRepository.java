package com.Lesson2.HW2;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface ItemRepository extends JpaRepository<Item, Long> {

    @Query("SELECT item FROM Item WHERE item.name=:name")
    Item getByName(@Param("name") String name);

    @Query("DELETE FROM Item WHERE item.id=:id")
    void  delete(@Param("id") Long id);
}
