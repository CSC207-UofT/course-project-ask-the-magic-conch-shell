package com.bookSystem.useCase;

import com.bookSystem.entity.User.Staff;
import com.bookSystem.entity.User.Student;

public interface IUserLoginManager {

    Student getCurrentStudent();

    Staff getCurrentStaff();

    void modifyCreditScore(int changeBy);

    void studentModifyPassword(String username, String oldPassword, String newPassword);

    void staffModifyPassword(String username, String oldPassword, String newPassword);

    int BorrowedBookAmount();

    void execute();
}
