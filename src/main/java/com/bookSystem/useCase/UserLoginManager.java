package com.bookSystem.useCase;


import com.bookSystem.entity.User.Staff;
import com.bookSystem.entity.User.Student;

import java.util.ArrayList;
import java.util.Objects;


/**
     * Manage the user that is currently login (Student/Staff). Responsible for storing the user's information,
     * checking and modifying Students' credit score and changing Users' passwords.
     */

public class UserLoginManager implements IUserLoginManager {

    public Student currentStudent;
    public Staff currentStaff;


    public UserLoginManager(String username, String password, int creditScore, ArrayList<Integer> br) {
        this.currentStudent = new Student(username);
        this.currentStudent.setPassword(password);
        this.currentStudent.CreditScoreSetter(creditScore);
        this.currentStudent.borrowingRecordsSetter(br);


    }

    public UserLoginManager(String username, String password) {
        this.currentStaff = new Staff(username);
        this.currentStaff.setPassword(password);

    }


        /**
         * To modify current student's credit score
         * @param changeBy change the credit score by "changeBy" amount of credit
         */

    @Override
    public void modifyCreditScore(int changeBy) {
        int old = currentStudent.CreditScoreGetter();
        currentStudent.CreditScoreSetter(old + changeBy);
        }



        /**
         * To modify current student's password
         * @param username student's username
         * @param oldPassword student's old password
         * @param newPassword student's new password
         */

    @Override
    public void studentModifyPassword(String username, String oldPassword, String newPassword) {
        if (Objects.equals(currentStudent.getPassword(), oldPassword)) {
            currentStudent.setPassword(newPassword);
        }
    }

        /**
         * To modify staff's password
         * @param username staff's username
         * @param oldPassword staff's old password
         * @param newPassword staff's new password
         */

    @Override
    public void staffModifyPassword(String username, String oldPassword, String newPassword) {
        if (Objects.equals(currentStaff.getPassword(), oldPassword)) {
            currentStaff.setPassword(newPassword);
        }

        }

        /**
         * To check how many books the student is currently borrowing
         * @return numbers of book a student is currently borrowing, return -1 if username cannot be found
         */

    @Override
    public int BorrowedBookAmount() {
        return currentStudent.CurrentBorrowingRecordsGetter().size();
    }
    }


