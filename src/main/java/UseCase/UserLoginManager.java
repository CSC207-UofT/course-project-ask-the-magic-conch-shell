package UseCase;



import User.Staff;
import User.Student;


/**
     * Manage the user that is currently login (Student/Staff). Responsible for storing the user's information,
     * checking and modifying Students' credit score and changing Users' passwords.
     */

public class UserLoginManager implements IUserLoginManager {

    Student currentStudent;
    Staff currentStaff;


    public UserLoginManager(Student currentStudent) {
        this.currentStudent = currentStudent;

    }

    public UserLoginManager(Staff currentStaff) {
        this.currentStaff = currentStaff;

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
        if (currentStudent.PasswordGetter(username) == oldPassword) {
            currentStudent.PasswordSetter(newPassword);
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
        if (currentStaff.PasswordGetter(username) == oldPassword) {
            currentStaff.PasswordSetter(newPassword);
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


