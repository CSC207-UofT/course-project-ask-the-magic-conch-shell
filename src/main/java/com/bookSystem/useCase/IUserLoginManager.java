package com.bookSystem.useCase;

public interface IUserLoginManager {

    void modifyCreditScore(int changeBy);

    void studentModifyPassword(String username, String oldPassword, String newPassword);

    void staffModifyPassword(String username, String oldPassword, String newPassword);

    int BorrowedBookAmount();
}
