package com.projects.toDoList.toDoList.config;

import jakarta.persistence.*;

import java.util.Date;

@Entity
@Table
public class Item {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String itemLabel;

    private String itemDescription;

    private Date dueDate;

    protected Item() {

    }

    public Item(String itemLabel, String itemDescription, Date dueDate) {
        this.itemLabel = itemLabel;
        this.itemDescription = itemDescription;
        this.dueDate = dueDate;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getItemLabel() {
        return itemLabel;
    }

    public void setItemLabel(String itemLabel) {
        this.itemLabel = itemLabel;
    }

    public String getItemDescription() {
        return itemDescription;
    }

    public void setItemDescription(String itemDescription) {
        this.itemDescription = itemDescription;
    }

    public Date getDueDate() {
        return dueDate;
    }

    public void setDueDate(Date dueDate) {
        this.dueDate = dueDate;
    }
}
