package com.example.demo.password;

import java.util.Scanner;

public class Password {

    public static void userLogin() {

        Scanner scan = new Scanner(System.in);

        boolean correctLogin = false;

        String enteredUsername;
        String enteredPassword;

        while(!correctLogin){
            System.out.print("Enter Username: ");
            enteredUsername = scan.nextLine();

            System.out.print("Enter Password: ");
            enteredPassword = scan.nextLine();

            if(enteredUsername.equals("username") && enteredPassword.equals("passw00rd")){
                System.out.println("You have logged in successfully!");
                correctLogin = true;
                break;
            }
            else{
                System.out.println("Your login info was incorrect, please try again");
            }
        }

    }
}