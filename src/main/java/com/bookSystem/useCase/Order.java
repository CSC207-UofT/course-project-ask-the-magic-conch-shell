package com.bookSystem.useCase;
import com.bookSystem.entity.Book.Book;
import com.bookSystem.entity.User.Student;

import com.bookSystem.mongoDBGateway.IMongoDBBookMethods;
import com.bookSystem.mongoDBGateway.IMongoDBStudentMethods;
import com.bookSystem.mongoDBGateway.MongoDBBookMethods;
import com.bookSystem.mongoDBGateway.MongoDBStudentMethods;

/**
 * Part of the command design pattern, the Order base class that takes a book and a student. The execution would check
 * conditions of both student and the book to see whether the borrow is successful or not.
 */

public class Order {
    private final Book book;
    public Student currentStudent;
    IMongoDBBookMethods bookMethods = new MongoDBBookMethods();
    IMongoDBStudentMethods studentMethods = new MongoDBStudentMethods();

    IDBbookManager bookManager = new DBbookManager();
    IDBUserManager userManager = new DBUserManager();



    public Order(Book book, Student student){
        this.book = book;
        this.currentStudent = student;}


    /**
     * Decide whether the book can be borrowed by the student by checking conditions of both the student and the book.
     * @return true if the book can be lent by the student, false otherwise
     */
    public boolean execute(){
        boolean status = false;
        if (bookManager.checkBookStatus(book.getBookID(), bookMethods).equals(BookPositionStatus.UNLENDED)){
            if (this.currentStudent.getCreditScore() >= 80){
                if (this.currentStudent.getBorrowedBookAmount() < 5){
                    this.currentStudent.addToCurrentBorrowingRecords(this.book);
                    userManager.studentDBModifyBorrowRecord(this.currentStudent.getUsername(), this.currentStudent.getCurrentBorrowingRecords(), studentMethods);
                    bookManager.changeBookStatus(book.getBookID(), BookPositionStatus.LENDED, bookMethods);
                    status = true;
                }
            } else if ( this.currentStudent.getCreditScore() >= 50 ){
                if (this.currentStudent.getBorrowedBookAmount() < 4){
                    this.currentStudent.addToCurrentBorrowingRecords(this.book);
                    userManager.studentDBModifyBorrowRecord(this.currentStudent.getUsername(), this.currentStudent.getCurrentBorrowingRecords(), studentMethods);
                    bookManager.changeBookStatus(book.getBookID(), BookPositionStatus.LENDED, bookMethods);
                    status = true;

                }
            } else if ( this.currentStudent.getCreditScore() >= 10 ){
                if (this.currentStudent.getBorrowedBookAmount() < 1){
                    this.currentStudent.addToCurrentBorrowingRecords(this.book);
                    userManager.studentDBModifyBorrowRecord(this.currentStudent.getUsername(), this.currentStudent.getCurrentBorrowingRecords(), studentMethods);
                    bookManager.changeBookStatus(book.getBookID(), BookPositionStatus.LENDED, bookMethods);
                    status = true;

                }
            }
        }
        return status;
        }


    public String toString(){
        return this.book.getBookID() + ":" +this.book.getBookName();

    }
}


