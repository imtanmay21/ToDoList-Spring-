package com.projects.toDoList.toDoList.controllers;

import com.projects.toDoList.toDoList.config.Item;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.projects.toDoList.toDoList.services.ItemService;

import java.util.List;

@RestController
@RequestMapping(path = "/api/v1/items")
public class ItemController {

    final private ItemService itemService;

    @Autowired
    public ItemController(ItemService itemService) {
        this.itemService = itemService;
    }

    @GetMapping
    public List<Item> getAllItems() {
        return itemService.getAllItems();
    }

    @GetMapping("{itemId}")
    public ResponseEntity<?> getItemById(@PathVariable String itemId) {
        try {
            Long id = Long.parseLong(itemId);
            Item item = itemService.getItemById(id);
            return ResponseEntity.ok(item);
        } catch (NumberFormatException e) {
            return ResponseEntity.badRequest().body("Item ID must be a number.");
        }
    }

    @PutMapping("{itemId}")
    public void updateItem(@PathVariable Long itemId, @RequestBody Item item) {
        itemService.updateItem(itemId, item);
    }

    @PostMapping
    public void addItem(@RequestBody Item item) {
        itemService.addItem(item);
    }

    @DeleteMapping("{itemId}")
    public void deleteItem(@PathVariable Long itemId) {
        itemService.deleteItem(itemId);
    }
}
