package controller;
import MongoDBGateway.IMongoDBStaffMethods;
import MongoDBGateway.IMongoDBStudentMethods;
import UseCase.MongoDBManager;
import User.Staff;
import User.Student;

import java.util.ArrayList;
import java.util.Objects;
import java.util.Random;

public class LoginWindow {
    public void creatNewUser(String user_type, String username){
        if (Objects.equals(user_type, "Student")){
            long pass = randomPasswordGenerator();
            Student s = new Student(username);
            s.PasswordSetter(pass);
            MongoDBManager m = new MongoDBManager();
            m.createNewUser(s);
        }
        else if (Objects.equals(user_type, "Staff")){
            long pass = randomPasswordGenerator();
            Staff s = new Staff(username);
            s.PasswordSetter(pass);
            MongoDBManager m = new MongoDBManager();
            m.createNewUser(s);

    }}

    // login method will return true if the username exist in the database and the input password matches the record
    // in the database, else return false, as the login is unsuccessful.
    public boolean login(String user_type, String username, String password){

        //
            if (Objects.equals(user_type, "Student")){
                if(IMongoDBStudentMethods.checkStudent(username)
                        && Objects.equals(password, MongoDBManager.getPassword(username))){
                    //Student s = new Student(username);
                    //s.PasswordSetter();
                }
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
    private long randomPasswordGenerator() {
        return getString();

    }

    private long getString() {
        String ran_pick_lst = "QWERTYUIOPASDFGHJKLZXCVBNM";
        Random ran = new Random();
        String pass = "";
        pass += ran_pick_lst.charAt(ran.nextInt(ran_pick_lst.length() - 1));
        pass += ran_pick_lst.charAt(ran.nextInt(ran_pick_lst.length() - 1));
        pass += ran_pick_lst.charAt(ran.nextInt(ran_pick_lst.length() - 1));
        pass += ran_pick_lst.charAt(ran.nextInt(ran_pick_lst.length() - 1));
        pass += ran_pick_lst.charAt(ran.nextInt(ran_pick_lst.length() - 1));

        return Long.parseLong(pass);
    }
}
