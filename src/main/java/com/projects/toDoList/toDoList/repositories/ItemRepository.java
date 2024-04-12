package com.projects.toDoList.toDoList.repositories;

import com.projects.toDoList.toDoList.config.Item;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ItemRepository extends JpaRepository<Item, Long> {
}
