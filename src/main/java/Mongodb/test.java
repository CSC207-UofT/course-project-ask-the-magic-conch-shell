package Mongodb;


import Book.Book;

import java.util.ArrayList;
import java.time.LocalDate;
import java.util.Objects;

public class test {
    public static void main(String[] args) {

        MongoDBUserMethods.addUser("Leo","abb123");
        ArrayList<String> newArray = new ArrayList<>();
        newArray.add("1006");
        newArray.add("1007");
        MongoDBStudentMethods.addStudent("amy","123",100, newArray);
        MongoDBBookMethods.addBook("1001","book1","983-23-5326-324-1","2011","james","fiction");
//        MongoDBStudentMethods.deleteStudent("Jason");
//        System.out.println(MongoDBStudentMethods.checkStudent("Jason"));
//        System.out.println(MongoDBStudentMethods.getPassword("Jason"));
//        System.out.println(MongoDBStudentMethods.checkStudent("amy"));
//        MongoDBStudentMethods.addStudent("amy","123",100, newArray);
//        System.out.println(MongoDBStudentMethods.getBorrowingHistory("Jason"));
//        MongoDBStudentMethods.deleteStudent("Jason");
//        MongoDBStudentMethods.deleteStudent("Jason");
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
