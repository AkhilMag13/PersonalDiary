package Diary.application;

import java.util.Scanner;
/* Basic Java app to re-learn the basics of Java - Started 10/07/23
    Basic features and layout:
        1. Login and password for authentication - Done
        2. Option to create a diary per day
        3. Saves the diary as a .txt file in a given folder with name of 'User-Diary-Entry-{Date}'
        4. Option to view diaries from the past entries

*/
public class PersonalDiary {
    public static void main(String[] args) {
        // Scanner class for taking in keyboard input
        Scanner input = new Scanner(System.in);
        System.out.println("Welcome to your Personal Diary!");

        // Login for authentication
        if(Authentication.getAccess()) {
            System.out.println("Yes");
        }
    }
}
