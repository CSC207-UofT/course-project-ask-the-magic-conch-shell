package com.application.UI_demo;

import java.util.HashMap;
import java.util.Objects;
import java.util.Scanner;


public class command_executor {
    // public empty_input(String commandLine){
    // if (commandLine.equals("")) {
    //return "";
    //  }

    // }
    public static HashMap<String, String> member_info = new HashMap<>() ;

    public static void log_in(){
        Scanner myObj = new Scanner(System.in);
        System.out.println("Please input your username, in the next line, declare the type user: student, or staff");
        String username = myObj.nextLine();
        member_info.put("username", username);
        String usertype = myObj.nextLine();
        member_info.put("usertype", usertype);

        System.out.println("Name: " + username);
        System.out.println("usertype: " + usertype);
        //System.out.println();

        System.out.println("now please input your password");
        String password = myObj.nextLine();
        System.out.println("You have successfully logged in");
        select_service();
    }

    public static void select_service(){
        Scanner service = new Scanner(System.in);
        if (Objects.equals(member_info.get("usertype"), "student")){
            System.out.println("\n Please select the service you need \n Borrow book \n Return book \n Change_password " +
                    "\n check credit score");
            String wished_service = service.nextLine();
            if(Objects.equals(wished_service, "Borrow book")){borrow_book();}
            else if (Objects.equals(wished_service, "Return book")){return_book();}
            else if (Objects.equals(wished_service, "Change_password")){change_password();}
            else if (Objects.equals(wished_service, "check credit score")){check_credit();}

        }
        else if (Objects.equals(member_info.get("usertype"), "staff")){
            System.out.println("Please select the service you need \n Return book \n Change password for me \n " +
                    "change password for another student \n add new book to inventory");
            String wished_service = service.nextLine();
            if(Objects.equals(wished_service, "Change password for me")){change_password();}
            else if (Objects.equals(wished_service, "Return book")){return_book();}
            else if (Objects.equals(wished_service, "Change_password for another student")){change_password_for_others();}
            else if (Objects.equals(wished_service, "add new book to inventory")){add_new_book_to_inventory();}


        }

    }


    public static void borrow_book(){
        Scanner command = new Scanner(System.in);
        System.out.println("Please input the id of the book you wish to borrow, or type exit to return " +
                "to the main menu");
        String bookID = command.nextLine();
        if (!Objects.equals(bookID, "exit")){
            System.out.println("book id:" + bookID);
            System.out.println("You have successfully borrowed this book. Please return this book by 2021-12-20");
        }
        select_service();

    }

    public static void return_book(){
        if (Objects.equals(member_info.get("usertype"), "student")){
            Scanner command = new Scanner(System.in);
            System.out.println("Please drop off the book at the library, or type exit to return to the main menu ");

            String chosen_command = command.nextLine();
            if (Objects.equals(chosen_command, "exit")){select_service();}
        }
        else if (Objects.equals(member_info.get("usertype"), "staff")){
            Scanner command = new Scanner(System.in);
            System.out.println("Please input the bookID and the status of the book, " +
                    "or type exit to return to the main menu \n the status of the book can be GOOD or DAMAGED");
            String chosen_command = command.nextLine();
            if (!Objects.equals(chosen_command, "exit")) {
                System.out.println("bookID: " + chosen_command);
                String book_status = command.nextLine();
                System.out.println("book_status: " + book_status);
                if (Objects.equals(book_status, "GOOD")) {
                    System.out.println("The return of this book is successful \n");
                } else if (Objects.equals(book_status, "DAMAGED")) {
                    System.out.println("\nSince the book is damaged, please dispose the book.\n");
                }
            }
            select_service();
        }
    }

    public static void change_password(){
        Scanner new_password = new Scanner(System.in);
        System.out.println("Please input your new password");
        System.out.println("You have successfully changed your password");
        System.out.println("new password: " + new_password);

        select_service();


    }

    public static void change_password_for_others(){
        Scanner command = new Scanner(System.in);
        System.out.println("Please input the username of the user whom you chose to change password of");
        String username = command.nextLine();
        System.out.println("username: " + username);
        String new_password = command.nextLine();
        System.out.println("You have successfully changed your password");
        System.out.println("new password: " + new_password);
        select_service();


    }

    public static void add_new_book_to_inventory(){
        Scanner book_info = new Scanner(System.in);
        System.out.println("Please input ISBN");
        String isbn = book_info.nextLine();
        System.out.println("Please input book name");
        String bookName = book_info.nextLine();
        System.out.println("Please input published date, in format yyyy/mm/dd");
        String book_published_date = book_info.nextLine();
        System.out.println("Please input author");
        String book_author = book_info.nextLine();

        System.out.println("ISBN: " + isbn);
        System.out.println("book name: " + bookName);
        System.out.println("published dae: " + book_published_date);
        System.out.println("author: " + book_author);

        System.out.println("You have successfully add this book to inventory");
        select_service();

    }

    public static void check_credit(){
        System.out.println("Your credit score is 100.\n");
        select_service();

    }

}
