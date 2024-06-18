package com.example.kursovanew.models;

import java.time.LocalDate;

public class Income extends Record {

    public Income(Integer id, Category category, Double suma, LocalDate date) {
        super(id, category, suma, date);
    }

    public Income(Category category, Double suma, LocalDate date) {
        super(category, suma, date);
    }
}
