package Mongodb;


import Book.Book;

import java.util.ArrayList;
import java.time.LocalDate;
import java.util.Objects;

public class test {
    public static void main(String[] args) {
        System.out.println(MongoDBStudentMethods.getPassword("amy"));
        ArrayList<Book> bookArray = new ArrayList<Book>();
        Book book = new Book(1006,"Computer","23135-asd564",LocalDate.now(),"Author1");
        bookArray.add(book);
        ArrayList<String> newArray = new ArrayList<>();
        newArray.add("1006");
        MongoDBStudentMethods.addStudent("Jason","abc",100, newArray);
//        MongoDBUserMethods.update("James", "updated2");
//        System.out.println(MongoDBUserMethods.getPassword("James"));
//        System.out.println(MongoDBUserMethods.getPassword("James"));
//        MongoDBUserMethods.update("James", "updated2");
//        System.out.println(MongoDBUserMethods.getPassword("James"));
//        MongoDBUserMethods.addUser("sky","beforeupdate");
//        System.out.println(MongoDBUserMethods.getPassword("sky"));
//        MongoDBUserMethods.update("James", "updated2");
//        System.out.println(MongoDBUserMethods.getPassword("James"));
//        MongoDBUserMethods.addUser("lily","yy11");
//        System.out.println(MongoDBUserMethods.getPassword("lily"));
//        System.out.println(MongoDBBookMethods.getAuthor("1006"));
//        MongoDBBookMethods.addBook("1001","book1","983-23-5326-324-1","2011","amy","fiction");
//        System.out.println(MongoDBBookMethods.getAuthor("1001"));
//        MongoDBBookMethods.update("1001","book1","983-23-5326-324-1","2011","james","fiction");
//        System.out.println(MongoDBBookMethods.getAuthor("1001"));
    }
}
