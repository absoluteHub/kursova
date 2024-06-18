package com.example.kursovanew.util;

import com.example.kursovanew.dao.RecordDao;
import com.example.kursovanew.models.Category;
import com.example.kursovanew.models.Expense;
import com.example.kursovanew.models.Income;

import java.time.LocalDate;

public class TestDataBaseCreator {

    public static void createTestDataBaseCreator(RecordDao recordDao) {
        recordDao.create(new Income(Category.ЗАРПЛАТА, 500.0,
                LocalDate.of(2024, 6, 20)));
        recordDao.create(new Income(Category.ПОДАРУНОК, 25.0,
                LocalDate.of(2024, 6, 23)));
        recordDao.create(new Expense("мешок картошки", 2,
                Category.ШОПІНГ, 150.0, LocalDate.of(2024, 6, 17)));
        recordDao.create(new Expense("клавіатура", 1,
                Category.РОЗВАГИ, 200.0, LocalDate.of(2024, 6, 17)));
    }
}
