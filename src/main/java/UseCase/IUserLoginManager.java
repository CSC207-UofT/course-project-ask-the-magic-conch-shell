package UseCase;

public interface IUserLoginManager {

    void modifyCreditScore(int changeBy);

    void studentModifyPassword(String username, long oldPassword, long newPassword);

    void staffModifyPassword(String username, long oldPassword, long newPassword);

    int BorrowedBookAmount();
}
