package com.example.kursovanew.models;

import java.time.LocalDate;

public abstract class Record {
    private Integer id;
    private Category category;
    private Double suma;
    private LocalDate date;

    public Record(Integer id, Category category, Double suma, LocalDate date) {
        this.id = id;
        this.category = category;
        this.suma = suma;
        this.date = date;
    }

    public Record(Category category, Double suma, LocalDate date) {
        this.category = category;
        this.suma = suma;
        this.date = date;
    }

    public int getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public double getSuma() {
        return suma;
    }

    public void setSuma(Double suma) {
        this.suma = suma;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }
}
