package com.example.kursovanew.controllers;

import com.example.kursovanew.dao.RecordDao;
import com.example.kursovanew.models.Category;
import com.example.kursovanew.models.Expense;
import com.example.kursovanew.models.Income;
import com.example.kursovanew.models.Record;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.time.LocalDate;
import java.util.Collection;

@WebServlet(name = "RecordController", urlPatterns = {"/records", "/index.jsp"})
public class RecordController extends HttpServlet {

    private RecordDao recordDao;

    @Override
    public void init() throws ServletException {
        super.init();
        recordDao = (RecordDao) getServletContext().getAttribute("recordDao");
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String command = request.getParameter("command");
        if (command == null) {
            command = "showDashboard";
        }
        switch (command) {
            case "createIncome":
                request.getRequestDispatcher("WEB-INF/jsp/createIncome.jsp").forward(request, response);
                break;
            case "createExpense":
                request.getRequestDispatcher("WEB-INF/jsp/createExpense.jsp").forward(request, response);
                break;
            case "edit":
                showEditForm(request, response);
                break;
            case "filterRecords":
                request.getRequestDispatcher("WEB-INF/jsp/filterRecords.jsp").forward(request,response);
                break;
            case "viewPeriod":
                viewPeriod(request, response);
                break;
            case "viewCategory":
                viewCategory(request, response);
                break;
            case "showDashboard":
            default:
                showDashboard(request, response);
                break;
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String command = request.getParameter("command");
        if (command == null) {
            response.sendError(400, "parameter command not found");
            return;
        }
        switch (command) {
            case "delete":
                delete(request, response);
                break;
            case "save":
                save(request, response);
                break;
            case "create":
                create(request, response);
                break;
            default:
                response.sendError(400, "wrong command");
        }
    }

    private void delete(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            Integer id = Integer.valueOf(request.getParameter("id"));
            recordDao.delete(id);
            response.sendRedirect("records");
        } catch (Exception e) {
            response.sendError(400, "bad parameter");
        }
    }

    private void create(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            Category category = Category.valueOf(request.getParameter("category"));
            Double suma = Double.valueOf(request.getParameter("suma"));
            LocalDate date = LocalDate.parse(request.getParameter("date"));
            String type = request.getParameter("type");
            Record record;
            if ("expense".equalsIgnoreCase(type)) {
                String description = request.getParameter("description");
                Integer amount = Integer.valueOf(request.getParameter("amount"));

                record = new Expense(description, amount, category, suma, date);
            } else {
                record = new Income(category, suma, date);
            }

            recordDao.create(record);
            response.sendRedirect("records");
        } catch (Exception e) {
            response.sendError(400, "bad parameter");
        }
    }

    private void save(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            Integer id = Integer.valueOf(request.getParameter("id"));
            Category category = Category.valueOf(request.getParameter("category"));
            Double suma = Double.valueOf(request.getParameter("suma"));
            LocalDate date = LocalDate.parse(request.getParameter("date"));
            String type = request.getParameter("type");
            Record record;
            if ("expense".equalsIgnoreCase(type)) {
                String description = request.getParameter("description");
                Integer amount = Integer.valueOf(request.getParameter("amount"));
                record = new Expense(id, description, amount, category, suma, date);
            } else {
                record = new Income(id, category, suma, date);
            }
            recordDao.update(record);
            response.sendRedirect("records");
        } catch (Exception e) {
            response.sendError(400, e.getMessage());
        }
    }

    private void showDashboard(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.setAttribute("incomes", recordDao.findAllIncome());
        request.setAttribute("expenses", recordDao.findAllExpense());
        request.getRequestDispatcher("WEB-INF/jsp/dashboard.jsp").forward(request, response);
    }

    private void showEditForm(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            Integer id = Integer.valueOf(request.getParameter("id"));
            Record record = recordDao.findById(id);
            request.setAttribute("record", record);
            if (request.getParameter("type").equals("income")) {
                request.getRequestDispatcher("WEB-INF/jsp/editIncome.jsp").forward(request, response);
            } else {
                request.getRequestDispatcher("WEB-INF/jsp/editExpense.jsp").forward(request, response);
            }
        } catch (Exception e) {
            response.sendError(400);
        }
    }

    private void viewPeriod(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            LocalDate startDate = LocalDate.parse(request.getParameter("startDate"));
            LocalDate endDate = LocalDate.parse(request.getParameter("endDate"));

            Collection<Income> incomesDate = recordDao.findIncomesByPeriod(startDate, endDate);
            Collection<Expense> expensesDate = recordDao.findExpensesByPeriod(startDate, endDate);

            request.setAttribute("incomesDate", incomesDate);
            request.setAttribute("expensesDate", expensesDate);
            request.getRequestDispatcher("WEB-INF/jsp/recordByPeriod.jsp").forward(request, response);
        } catch (Exception e) {
            response.sendError(400, "bad parameter");
        }
    }

    private void viewCategory(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            Category category = Category.valueOf(request.getParameter("category"));

            Collection<Income> incomesCategory = recordDao.findIncomesByCategory(category);
            Collection<Expense> expensesCategory = recordDao.findExpensesByCategory(category);

            request.setAttribute("incomesCategory", incomesCategory);
            request.setAttribute("expensesCategory", expensesCategory);
            request.getRequestDispatcher("WEB-INF/jsp/recordByCategory.jsp").forward(request, response);
        } catch (Exception e) {
            response.sendError(400, "bad parameter");
        }
    }
}
