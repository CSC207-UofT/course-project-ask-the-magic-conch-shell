package MongoDBGateway;


import Book.subclasses.Magazine;
import UseCase.DBbookManager;

import java.time.LocalDate;
import java.util.ArrayList;

public class test {
    public static void main(String[] args) {
//        ArrayList<String> newArray = new ArrayList<>();
//        newArray.add("1006");
//        newArray.add("1007");
//        IMongoDBStudentMethods.addStudent("Mike","123456",100, newArray);

//          System.out.println(IMongoDBBookMethods.searchByISBN("9781319120054"));

///        MongoDBStaffMethods.addStaff("Leo","abb123");
        String n = "1bc123";
        long nl = Long.parseLong(n);
        System.out.println(nl);
        ArrayList<String> newArray = new ArrayList<>();
        newArray.add("1006");
//        newArray.add("1007");
//        MongoDBStudentMethods.addStudent("amy","123",100, newArray);
//        MongoDBBookMethods.addBook("1001","book1","983-23-5326-324-1","2011","james","fiction");
//        MongoDBStudentMethods.deleteStudent("Jason");
        MongoDBStudentMethods a = new MongoDBStudentMethods();
        System.out.println(a.checkStudent("Mike"));
        a.addStudent("test","1234",90,newArray);
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
//        MongoDBBookMethods.addBook("1001","book1","983-23-5326-324-1","2011","amy","fiction");
//        System.out.println(MongoDBBookMethods.getAuthor("1001"));
//        MongoDBBookMethods.update("1001","book1","983-23-5326-324-1","2011","james","fiction");
//        System.out.println(MongoDBBookMethods.getAuthor("1001"));
    }
}
