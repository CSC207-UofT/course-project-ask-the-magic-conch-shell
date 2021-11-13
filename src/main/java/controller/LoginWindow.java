package controller;
import MongoDBGateway.IMongoDBStaffMethods;
import MongoDBGateway.IMongoDBStudentMethods;

import java.util.ArrayList;
import java.util.Objects;
import java.util.Random;

public class LoginWindow {
    public void creatNewUser(String user_type, String username){
        if (Objects.equals(user_type, "Student")){
            String pass = randomPasswordGenerator();
            ArrayList<String> borrow_records = new ArrayList<>();
            IMongoDBStudentMethods.addStudent(username, pass, 100, borrow_records);
        }
        else if (Objects.equals(user_type, "Staff")){
            String pass = randomPasswordGenerator();
            ArrayList<String> borrow_records = new ArrayList<>();
            IMongoDBStaffMethods.addStaff(username, pass);
    }}

    // login method will return true if the username exist in the database and the input password matches the record
    // in the database, else return false, as the login is unsuccessful.
    public boolean login(String user_type, String username, String password){
            if (Objects.equals(user_type, "Student")){
                return IMongoDBStudentMethods.checkStudent(username)
                        && Objects.equals(password, IMongoDBStudentMethods.getPassword(username));
            }

            else if (Objects.equals(user_type, "Staff")){
                return IMongoDBStaffMethods.checkStaff(username) &&
                        Objects.equals(password, IMongoDBStaffMethods.getPassword(username));
            }

            return false;

    }



    public void changePassword(String username, String new_password){

    }

    private void  checkPassword(String username, String password){
    }

    public void forgetPassword(String username, String new_password){
    }

    // will generate a randon length 5, all capital letter temporary password.
    private String randomPasswordGenerator() {
        return getString();

    }

    private String getString() {
        String ran_pick_lst = "QWERTYUIOPASDFGHJKLZXCVBNM";
        Random ran = new Random();
        String pass = "";
        pass += ran_pick_lst.charAt(ran.nextInt(ran_pick_lst.length() - 1));
        pass += ran_pick_lst.charAt(ran.nextInt(ran_pick_lst.length() - 1));
        pass += ran_pick_lst.charAt(ran.nextInt(ran_pick_lst.length() - 1));
        pass += ran_pick_lst.charAt(ran.nextInt(ran_pick_lst.length() - 1));
        pass += ran_pick_lst.charAt(ran.nextInt(ran_pick_lst.length() - 1));

        return pass;
    }
}
