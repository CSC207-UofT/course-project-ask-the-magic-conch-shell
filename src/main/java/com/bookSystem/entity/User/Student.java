package com.bookSystem.entity.User;
import com.bookSystem.entity.Book.Book;

import java.util.ArrayList;

/**
 * A subclass of User
 */
public class Student extends User {
    /**
     * A newly registered Student would initially have 100 credit score
     */
    private int CreditScore = 100;
    /**
     * An arraylist of a Student's current borrowing records
     */
    private ArrayList<Integer> CurrentBorrowingRecords;


    /**
     * Constructs an instance of Student based on Strings of username
     * @param username student's username
     */
    public Student(String username){
        super(username);
        this.CurrentBorrowingRecords = new ArrayList<>();
    }

    /**
     * To set up Student's credit score based on the input CreditScore
     * @param CreditScore the credit score
     */
    public void CreditScoreSetter(int CreditScore){
        this.CreditScore = CreditScore;
    }

    /**
     * Return Student's credit score
     * @return student's credit score
     */
    public int CreditScoreGetter(){
        return this.CreditScore;
    }

    /**
     * To check if a student is able to borrow a new book based on numbers of book a Student
     * currently owned
     * @param book a book
     * @return false if the Student has 5 or more books, otherwise true
     */
    public boolean AddToCurrentBorrowingRecords(Book book){
        if (CurrentBorrowingRecords.size() >= 5){
            return false;
        }
        CurrentBorrowingRecords.add(book.getBookID());
        return true;

    }

    /**
     * Return a list of books a Student currently owned
     * @return an arraylist of Books a student is borrowing
     */
    public ArrayList<Integer> CurrentBorrowingRecordsGetter(){return this.CurrentBorrowingRecords;
    }

    public void borrowingRecordsSetter(ArrayList<Integer> br){
        this.CurrentBorrowingRecords = br;

    }

}
