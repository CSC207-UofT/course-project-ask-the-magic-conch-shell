package User;
import User.User;
import Book_package.Book;

import java.util.ArrayList;


public class Student extends User {
    private int CreditScore;
    private ArrayList<Book> CurrentBorrowingRecords;


    public Student(String username){
        super(username);
        this.CurrentBorrowingRecords = new ArrayList<>();


    }
    public void CreditScoreSetter(int CreditScore){
        this.CreditScore = CreditScore;
    }

    public int CreditScoreGetter(){
        return this.CreditScore;
    }

    public boolean AddToCurrentBorrowingRecords(Book book){
        if (CurrentBorrowingRecords.size() >= 5){
            return false;
        }
        CurrentBorrowingRecords.add(book);
        return true;

    }

    public ArrayList<Book> CurrentBorrowingRecordsGetter(){
        return this.CurrentBorrowingRecords;
    }



}
