package com.bookSystem.useCase;
import com.bookSystem.entity.Book.Book;
import com.bookSystem.entity.User.Student;


public abstract class AddOrder implements IUserLoginManager{
    private final Book book;
    public Student currentStudent;

    public AddOrder(Book book, Student student){
        this.book = book;
        this.currentStudent = student;}

    public void execute(){
        book.DBbookManager.addOrder();
        currentStudent.DBUserManager.addOrder();
    }
    }
    /*
    Need to add addOrder() method in DBBookManager.
     */



