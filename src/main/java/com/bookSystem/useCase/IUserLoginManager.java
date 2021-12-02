package com.bookSystem.useCase;

import org.springframework.stereotype.Component;

@Component
public interface IUserLoginManager {

    void modifyCreditScore(int changeBy);

    void studentModifyPassword(String username, String oldPassword, String newPassword);

    void staffModifyPassword(String username, String oldPassword, String newPassword);

    int BorrowedBookAmount();
}
