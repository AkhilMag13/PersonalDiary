package Diary.application;

import java.io.*;
import java.util.Scanner;

public class Authentication {
    private static File auth = new File("C:\\Users\\akhil\\IdeaProjects\\Learning Java\\src\\Diary\\authenticationFiles\\auth");
    private static File details = new File("C:\\Users\\akhil\\IdeaProjects\\Learning Java\\src\\Diary\\authenticationFiles\\details.txt");
    private static String passkey = "";
    private static boolean entry;
    private static Scanner input = new Scanner(System.in);

    public static boolean getAccess() {
        if (auth.exists() && !auth.isDirectory()) {
            try (BufferedReader br = new BufferedReader(new FileReader(auth))) {
                passkey = br.readLine();
                System.out.println("Please Enter the passkey to enter:");
                do {
                    if (passkey.equals(input.next())) {
                        entry = true;
                    } else {
                        System.err.println("Please enter the correct passkey: ");
                    }
                } while (!entry);
            } catch (IOException e) {
                e.printStackTrace();
            }
        } else {
            System.out.println("Please register by entering a passkey:");
            try {
                auth.createNewFile();
                try {
                    FileWriter authWriter = new FileWriter(auth);
                    authWriter.write(input.next());
                    authWriter.close();
                    System.out.println("Successfully saved the passkey in file: " + auth.getAbsolutePath() + ".txt\n--You can access it there and change incase you forget the passkey--");
                    entry = true;
                } catch (IOException e) {
                    System.err.println("An error occurred with registration, please try again later.");
                    e.printStackTrace();
                }
            } catch (IOException e) {
                System.err.println("Error in creating auth file");
                throw new RuntimeException(e);
            }
        }
        return entry;
    }


}
