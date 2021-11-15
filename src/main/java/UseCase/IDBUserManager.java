package UseCase;

import MongoDBGateway.IMongoDBStaffMethods;
import MongoDBGateway.IMongoDBStudentMethods;
import User.Staff;
import User.Student;

import java.util.ArrayList;

public interface IDBUserManager {

    boolean checkStudent(String username, IMongoDBStudentMethods sum);

    boolean checkStaff(String username, IMongoDBStaffMethods sm);

    boolean createNewUser(Staff staff, IMongoDBStaffMethods sm);

    boolean createNewUser(Student student, IMongoDBStudentMethods sum);

    boolean deleteStudent(String username, IMongoDBStudentMethods sum);

    String studentDBGetPassword(String username, IMongoDBStudentMethods sum);

    String staffDBGetPassword(String username, IMongoDBStaffMethods sm);

    public Integer DBGetCreditScore(String username, IMongoDBStudentMethods sum);

    public ArrayList<String> DBGetBorrowingRecord(String username, IMongoDBStudentMethods sum);

    void modifyDBCreditScore(String username, int changeBy, IMongoDBStudentMethods sum);

    void studentDBModifyPassword(String username, String oldPassword, String newPassword, IMongoDBStudentMethods sum);

    void studentDBModifyBorrowRecord(String username, ArrayList<String> newBR, IMongoDBStudentMethods sum);

    void staffDBModifyPassword(String username, String oldPassword, String newPassword, IMongoDBStaffMethods sm);
}
