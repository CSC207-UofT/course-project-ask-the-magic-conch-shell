package MongoDBGateway;

import UseCase.BookPositionStatus;
import com.mongodb.BasicDBObject;
import com.mongodb.DBObject;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Objects;

public interface IMongoDBBookMethods {
    public void update(String bookID, String name, String ISBN, String publishDate, String author, String status, String returnDate, String dynamic);


    /**
     **The overloaded update() method provides a way for people to update the book the same as that in the package subclasses in which one don't need to specify the type.
     **/
    public void update(String bookID, String name, String ISBN, String publishDate, String author, String status, String returnDate, String seriesname, String category);

    public void update(String bookID, String name, String ISBN, String publishDate, String author, String status, String returnDate, String language, String subject, String peerstatus);

    public String getName(String bookID);

    public String getISBN(String bookID);

    public ArrayList<Integer> searchByISBN(String ISBN);

    public ArrayList<Integer> searchByAuthor(String author);

    public ArrayList<Integer> searchByType(String type);

    public LocalDate getPublishDate(String bookID);

    public String getAuthor(String bookID);

    public BookPositionStatus getStatus(String bookID);

    public LocalDate getReturnDate(String bookID);

    public String getType(String bookID);

    public String getLanguage(String bookID);

    public String getSubject(String bookID);

    public String getSeriesName(String bookID);

    public String getCategory(String bookID);

    public String getPeriod(String bookID);

    public Comparable<Boolean> getPeerstatus(String bookID);

    public void addBook(String bookID, String name, String ISBN, String publishDate, String author, String status, String returnDate, String type);


    public void deleteDBBook(String bookID);

    public boolean checkBook(String bookID);
}
