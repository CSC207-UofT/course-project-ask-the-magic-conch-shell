package Mongodb;

public class test {
    public static void main(String[] args) {
        System.out.println(MongoDBUserMethods.getPassword("sky"));
        //System.out.println("1");
        MongoDBUserMethods.addUser("lily","yy11");
        System.out.println(MongoDBUserMethods.getPassword("lily"));
        System.out.println(MongoDBBookMethods.getAuthor("lives"));
        MongoDBBookMethods.addBook("book1","983-23-5326-324-1","2011","amy");
        System.out.println(MongoDBBookMethods.getAuthor("book1"));
    }
}
