package Mongodb;

public interface MongoDBInterface {
    public void update(String userName, String passWord);
    //public String getPassword(String userName);
    public void addUser(String userName, String passWord);

}
