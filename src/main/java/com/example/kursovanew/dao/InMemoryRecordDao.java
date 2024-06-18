package com.example.kursovanew.dao;

import com.example.kursovanew.models.Category;
import com.example.kursovanew.models.Expense;
import com.example.kursovanew.models.Income;
import com.example.kursovanew.models.Record;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collection;
import java.util.TreeMap;


public class InMemoryRecordDao implements RecordDao {

    TreeMap<Integer, Record> records = new TreeMap<>();

    @Override
    public void create(Record record) {
        int id = records.isEmpty() ? 1 : records.lastKey() + 1;
        record.setId(id);
        records.put(id, record);
    }

    @Override
    public Record findById(Integer id) {
        return records.get(id);
    }

    @Override
    public Collection<Record> findAll() {
        return records.values();
    }

    public Collection<Expense> findAllExpense() {
        Collection<Expense> expenses = new ArrayList<>();
        for (Record record : records.values()) {
            if (record instanceof Expense) {
                expenses.add((Expense) record);
            }
        }
        return expenses;
    }

    public Collection<Income> findAllIncome() {
        Collection<Income> incomes = new ArrayList<>();
        for (Record record : records.values()) {
            if (record instanceof Income) {
                incomes.add((Income) record);
            }
        }
        return incomes;
    }

    @Override
    public void update(Record record) {
        records.put(record.getId(), record);
    }

    @Override
    public void delete(Integer id) {
        records.remove(id);
    }

    @Override
    public Collection<Expense> findExpensesByPeriod(LocalDate startDate, LocalDate endDate) {
        Collection<Expense> expenses = new ArrayList<>();
        for (Record record : records.values()) {
            if (record instanceof Expense) {
                Expense expense = (Expense) record;
                LocalDate expenseDate = expense.getDate();
                if (expenseDate.compareTo(startDate) >= 0 && expenseDate.compareTo(endDate) <= 0) {
                    expenses.add(expense);
                }
            }
        }
        return expenses;
    }

    @Override
    public Collection<Expense> findExpensesByCategory(Category category) {
        Collection<Expense> expenses = new ArrayList<>();
        for (Record record : records.values()) {
            if (record instanceof Expense) {
                Expense expense = (Expense) record;
                if (expense.getCategory() == category) {
                    expenses.add(expense);
                }
            }
        }
        return expenses;
    }

    @Override
    public Collection<Income> findIncomesByPeriod(LocalDate startDate, LocalDate endDate) {
        Collection<Income> incomes = new ArrayList<>();
        for (Record record : records.values()) {
            if (record instanceof Income) {
                Income income = (Income) record;
                LocalDate incomeDateDate = income.getDate();
                if (incomeDateDate.compareTo(startDate) >= 0 && incomeDateDate.compareTo(endDate) <= 0) {
                    incomes.add(income);
                }
            }
        }
        return incomes;
    }

    @Override
    public Collection<Income> findIncomesByCategory(Category category) {
        Collection<Income> incomes = new ArrayList<>();
        for (Record record : records.values()) {
            if (record instanceof Income) {
                Income income = (Income) record;
                if (income.getCategory() == category) {
                    incomes.add(income);
                }
            }
        }
        return incomes;
    }

}
