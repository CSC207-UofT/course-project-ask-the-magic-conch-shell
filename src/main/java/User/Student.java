package User;
import Book.Book;

import java.util.ArrayList;


public class Student extends User {
    /**
     * The credit score
     */
    private int CreditScore = 100;
    /**
     * An arraylist of current borrowing records
     */
    private ArrayList<Book> CurrentBorrowingRecords;

    /**
     *
     * @param username the username
     */


    public Student(String username){
        super(username);
        this.CurrentBorrowingRecords = new ArrayList<>();

    }

    /**
     *
     * @param CreditScore the credit score
     */
    public void CreditScoreSetter(int CreditScore){
        this.CreditScore = CreditScore;
    }

    /**
     *
     * @return student's credit score
     */
    public int CreditScoreGetter(){
        return this.CreditScore;
    }

    /**
     *
     * @param book a book
     * @return whether the student is able to borrow a new book base on numbers of book the student
     * currently owns
     */
    public boolean AddToCurrentBorrowingRecords(Book book){
        if (CurrentBorrowingRecords.size() >= 5){
            return false;
        }
        CurrentBorrowingRecords.add(book);
        return true;

    }

    /**
     *
     * @return student's current borrowing records
     */
    public ArrayList<Book> CurrentBorrowingRecordsGetter(){
        return this.CurrentBorrowingRecords;
    }



}
