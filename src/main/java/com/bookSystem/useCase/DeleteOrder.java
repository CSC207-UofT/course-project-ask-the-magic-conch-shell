package com.bookSystem.useCase;
import com.bookSystem.entity.Book.Book;
import com.bookSystem.entity.User.Student;


public abstract class DeleteOrder implements IUserLoginManager {
    private final Book book;
    public Student currentStudent;

    public DeleteOrder(Book book, Student student) {
        this.book = book;
        this.currentStudent = student;
    }

    public void execute() {
        book.DBbookManager.deleteOrder();
        currentStudent.DBUserManager.deleteOrder();

     /*
    Need to add addOrder() method in DBBookManager.
    1. update this book's mongodb book status using book.getID (method in DBBookManager)
    2. delete this book from userborrowing record
     */
    }
}





