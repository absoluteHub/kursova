package com.example.kursovanew.dao;

import com.example.kursovanew.models.Category;
import com.example.kursovanew.models.Expense;
import com.example.kursovanew.models.Income;
import com.example.kursovanew.models.Record;

import java.time.LocalDate;
import java.util.Collection;

public interface RecordDao {
    void create(Record record);

    Record findById(Integer id);

    Collection<Record> findAll();

    Collection<Expense> findAllExpense();

    Collection<Income> findAllIncome();

    void update(Record record);

    void delete(Integer id);

    Collection<Expense> findExpensesByPeriod(LocalDate startDate, LocalDate endDate);

    Collection<Expense> findExpensesByCategory(Category category);

    Collection<Income> findIncomesByPeriod(LocalDate startDate, LocalDate endDate);

    Collection<Income> findIncomesByCategory(Category category);
}
