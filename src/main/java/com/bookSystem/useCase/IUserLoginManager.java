package com.bookSystem.useCase;

import com.bookSystem.entity.Book.Book;
import com.bookSystem.entity.User.Staff;
import com.bookSystem.entity.User.Student;
import org.springframework.stereotype.Component;

import java.util.ArrayList;


public interface IUserLoginManager {

    /**
     * Public interface of UserLoginManager.
     */

    Student getCurrentStudent();

    Staff getCurrentStaff();

    void modifyCreditScore(int changeBy);

    void studentModifyPassword(String username, String oldPassword, String newPassword);

    void staffModifyPassword(String username, String oldPassword, String newPassword);

    int borrowedBookAmount();

    void addToBookList(Book book);

    ArrayList<Book> getBookList();

    void addToCart(Order order);

    ArrayList<Boolean> placeOrders();

    void setCurrentStudent(Student currentStudent);

    void setCurrentStaff(Staff currentStaff);

    ArrayList<Order> getCart();


}
