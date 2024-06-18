package com.example.kursovanew.models;

import java.time.LocalDate;

public class Expense extends Record {
    private String description;
    private Integer amount;

    public Expense(Integer id, String description, Integer amount, Category category, Double suma, LocalDate date) {
        super(id, category, suma, date);
        this.description = description;
        this.amount = amount;
    }

    public Expense(String description, Integer amount, Category category, Double suma, LocalDate date) {
        super(category, suma, date);
        this.description = description;
        this.amount = amount;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getAmount() {
        return amount;
    }

    public void setAmount(Integer amount) {
        this.amount = amount;
    }

}