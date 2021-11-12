package Mongodb;


import Book.Book;

import java.util.ArrayList;
import java.time.LocalDate;
import java.util.Objects;

public class test {
    public static void main(String[] args) {
//        MongoDBStaffMethods.addUser("Leo","abb123");
//        String s = MongoDBStaffMethods.getPassword("Leo");
//        ArrayList<String> newArray = new ArrayList<>();
//        newArray.add("1006");
//        newArray.add("1007");
//        MongoDBStudentMethods.addStudent("amy","123",100, newArray);
//        MongoDBBookMethods.addBook("1001","book1","983-23-5326-324-1","2011","james","fiction");
//        MongoDBStudentMethods.deleteStudent("amy");
//        System.out.println(MongoDBStudentMethods.checkStudent("Jason"));
//        System.out.println(MongoDBStudentMethods.getPassword("Jason"));
//        System.out.println(MongoDBStudentMethods.checkStudent("amy"));
//        MongoDBStudentMethods.addStudent("amy","123",100, newArray);
//        System.out.println(MongoDBStudentMethods.getBorrowingHistory("Jason"));
//        MongoDBStudentMethods.deleteStudent("Jason");
//        MongoDBStudentMethods.deleteStudent("Jason");
//        MongoDBStaffMethods.update("James", "updated2");
//        System.out.println(MongoDBStaffMethods.getPassword("James"));
//        MongoDBStaffMethods.update("James", "updated2");
//        System.out.println(MongoDBStaffMethods.getPassword("James"));
//        System.out.println(MongoDBStaffMethods.getPassword("lily"));
//        System.out.println(MongoDBBookMethods.getAuthor("1006"));
        MongoDBBookMethods.addBook("1001","book1","983-23-5326-324-1","2011","amy","UNLENDED", "2021-10-10","Dictionary");
        System.out.println(MongoDBBookMethods.checkBook("1001"));
        MongoDBBookMethods.update("1001","book1","983-23-5326-324-1","2011","amy","UNLENDED", "2021-10-10","Textbook");
        System.out.println(MongoDBBookMethods.getType("1001"));
        MongoDBBookMethods.update("1001","book1","983-23-5326-324-1","2011","John","UNLENDED", "2021-10-10","Mathematics");
        System.out.println(MongoDBBookMethods.getSubject("1001"));
//        System.out.println(MongoDBBookMethods.getAuthor("1001"));
//        MongoDBBookMethods.update("1001","book1","983-23-5326-324-1","2011","james","fiction");
//        System.out.println(MongoDBBookMethods.getAuthor("1001"));
    }
}
