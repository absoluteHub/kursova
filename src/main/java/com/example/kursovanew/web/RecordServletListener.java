package com.example.kursovanew.web;

import jakarta.servlet.ServletContextEvent;
import jakarta.servlet.ServletContextListener;
import com.example.kursovanew.dao.InMemoryRecordDao;
import com.example.kursovanew.dao.RecordDao;
import com.example.kursovanew.util.TestDataBaseCreator;

public class RecordServletListener implements ServletContextListener {

    @Override
    public void contextInitialized(ServletContextEvent sce) {
        RecordDao recordDao = new InMemoryRecordDao();
        TestDataBaseCreator.createTestDataBaseCreator(recordDao);
        sce.getServletContext().setAttribute("recordDao", recordDao);

    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {

    }
}
