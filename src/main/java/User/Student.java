package User;
import Book_package.Book;

public class Student extends User{
    private int CreditScore;
    private Book[] CurrentBorrowingRecords;
    public void Student(String username){
        super.User(username);
        Book[] CurrentBorrowingRecords = new Book[5];
        this.CurrentBorrowingRecords = CurrentBorrowingRecords;


    }
    public void CreditScoreSetter(int CreditScore){
        this.CreditScore = CreditScore;
    }
    public int CreditScoreGetter(){
        return this.CreditScore;
    }
    public void CurrentBorrowingRecordsSetter(Book book){
        // TODO

    }
    public Book[] CurrentBorrowingRecordsGetter(){
        return this.CurrentBorrowingRecords;
    }



}
