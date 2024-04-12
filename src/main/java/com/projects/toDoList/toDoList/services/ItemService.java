package com.projects.toDoList.toDoList.services;

import com.projects.toDoList.toDoList.config.Item;
import com.projects.toDoList.toDoList.exception.ItemNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.projects.toDoList.toDoList.repositories.ItemRepository;

import java.util.List;
import java.util.Optional;

@Service
public class ItemService {

    final private ItemRepository itemRepository;

    @Autowired
    public ItemService(ItemRepository itemRepository) {
        this.itemRepository = itemRepository;
    }

    public List<Item> getAllItems() {
        return itemRepository.findAll();
    }

    public Item getItemById(Long itemId) {
        Optional<Item> itemOptional = itemRepository.findById(itemId);
        return itemOptional.orElseThrow(() -> new ItemNotFoundException("Item with id" + itemId + "not found"));
    }

    public void updateItem(Long itemId, Item updatedItem) {
        Optional<Item> itemOptional = itemRepository.findById(itemId);
        if (itemOptional.isPresent()) {
            Item existingItem = itemOptional.get();
            existingItem.setItemLabel(updatedItem.getItemLabel());
            existingItem.setItemDescription(updatedItem.getItemDescription());
            existingItem.setDueDate(updatedItem.getDueDate());

            itemRepository.save(existingItem);
        } else {
            throw new ItemNotFoundException("Item with that id does not exist");
        }
    }

    public void deleteItem(Long itemId) {
        Optional<Item> itemOptional = itemRepository.findById(itemId);
        if (itemOptional.isPresent()) {
            itemRepository.deleteById(itemId);
        } else {
            throw new ItemNotFoundException("Item with that id does not exist");
        }
    }

    public void addItem(Item item) {
        itemRepository.save(item);
    }
}
