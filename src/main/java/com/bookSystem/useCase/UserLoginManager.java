package com.bookSystem.useCase;


import com.bookSystem.entity.User.Staff;
import com.bookSystem.entity.User.Student;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Objects;


/**
 * Manage the user that is currently login (Student/Staff). Responsible for storing the user's information,
 * checking and modifying Students' credit score and changing Users' passwords.
 */
@Component
public class UserLoginManager implements IUserLoginManager {

    public Student currentStudent;
    public Staff currentStaff;
    private final ArrayList<Order> cart = new ArrayList<>();



    public void setCurrentStudent(Student currentStudent) {
        this.currentStudent = currentStudent;
    }

    public void setCurrentStaff(Staff currentStaff) {
        this.currentStaff = currentStaff;
    }

    public ArrayList<Order> getCart() {
        return cart;
    }

    /**
     * To get current student stored in UserLoginManager.
     */

    @Override
    public Student getCurrentStudent() {
        return this.currentStudent;
    }

    /**
     * To get current staff stored in UserLoginManager.
     */

    @Override
    public Staff getCurrentStaff() {
        return this.currentStaff;
    }


    /**
     * To modify current student's credit score
     * @param changeBy change the credit score by "changeBy" amount of credit
     */

    @Override
    public void modifyCreditScore(int changeBy) {
        int old = currentStudent.getCreditScore();
        currentStudent.setCreditScore(old + changeBy);
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
    public int borrowedBookAmount() {
        return currentStudent.getCurrentBorrowingRecords().size();
    }


    public void addToCart(Order order){
        this.cart.add(order);
    }

    public void deleteFromCart(Integer index){
        this.cart.remove(index);
    }


    public ArrayList<Boolean> placeOrders(){
        ArrayList<Boolean> result = new ArrayList<>();
        for (Order order : this.cart) {
            result.add(order.execute());
        }
        this.cart.clear();

        return result;
    }
}




