// Project 1

import java.util.InputMismatchException;
import java.util.Random;
import java.util.Scanner;

public class Main {
    public static String[][] table = {{" "," "," "},{" "," "," "},{" "," "," "}};
    public static String currentPlayer = "X";
    public static Scanner s = new Scanner(System.in);
    public static void main(String[] args) {

        displayTable();
        try {
            while (!gameFinished()) {
                if (currentPlayer.equals("X")) {
                    playerPlay();
                } else if (currentPlayer.equals("O")) {
                    computerPlay();
                }
                displayTable();
            }
        }
        catch (InputMismatchException e){
            System.out.println("invalid type for the choice");
        }
        catch (NegativeArraySizeException e) {
            System.out.println("fd");
        }
        catch (ArrayIndexOutOfBoundsException e){
            System.out.println("your choice is less than 1 or more than 9");
        }
        catch (Exception e){
            System.out.println(e.getMessage());
        }

    }

    public static void displayTable(){
        System.out.println(table[0][0] + "|" + table[0][1] + "|" + table[0][2]);
        System.out.println("-+-+-");
        System.out.println(table[1][0] + "|" + table[1][1] + "|" + table[1][2]);
        System.out.println("-+-+-");
        System.out.println(table[2][0] + "|" + table[2][1] + "|" + table[2][2]);
    }

    public static boolean ValidMove(int choice) throws ArrayIndexOutOfBoundsException{
        // to find the row: (choice-1)/3
        // to find the column: (choice-1)%3
        if(table[(choice-1)/3][(choice-1)%3].equals(" ")){
            return true;
        }
        if (currentPlayer.equals("X"))
            System.out.println(choice + " is not a valid move");
        return false;
    }

    public static boolean checkWinRow(){
        for (int i = 0; i < 3; i++) {
            if((table[i][0].equals(table[i][1])) && (table[i][1].equals(table[i][2])) && (!table[i][0].equals(" "))){
                if(currentPlayer.equals("X"))
                    System.out.println("Computer wins!");
                else
                    System.out.println("Player wins!");
                return true;
            }
        }
        return false;
    }
    public static boolean checkWinCol(){
        for (int i = 0; i < 3; i++) {
            if((table[0][i].equals(table[1][i])) && (table[1][i].equals(table[2][i])) && (!table[0][i].equals(" "))){
                if(currentPlayer.equals("X"))
                    System.out.println("Computer wins!");
                else
                    System.out.println("Player wins!");
                return true;
            }
        }
        return false;
    }
    public static boolean checkWinDiagonal(){
        if((table[0][0].equals(table[1][1])) && (table[1][1].equals(table[2][2])) && (!table[0][0].equals(" "))){
            if(currentPlayer.equals("X"))
                System.out.println("Computer wins!");
            else
                System.out.println("Player wins!");
            return true;
        }
        else if((table[0][2].equals(table[1][1])) && (table[1][1].equals(table[2][0])) && (!table[0][2].equals(" "))){
            if(currentPlayer.equals("X"))
                System.out.println("Computer wins!");
            else
                System.out.println("Player wins!");
            return true;
        }

        return false;
    }
    public static boolean gameFinished(){
        if(checkWinRow() || checkWinCol() || checkWinDiagonal())
            return true;

        return false;
    }
    public static void playerPlay() throws InputMismatchException, ArrayIndexOutOfBoundsException {
        int choice=0;
        do {
            System.out.println("Where would you like to play? (1-9)");
            choice = s.nextInt();
        }while(!ValidMove(choice));
        table[(choice-1)/3][(choice-1)%3] = "X";
        currentPlayer = "O";
    }
    public static void computerPlay(){
        int choice=0;
        Random random = new Random();
        do {
            choice = random.nextInt(9)+1;
        }while(!ValidMove(choice));
        table[(choice-1)/3][(choice-1)%3] = "O";
        currentPlayer = "X";
        System.out.println("Computer choose " + choice);
    }

}


//Exercise 7

//import java.lang.annotation.AnnotationTypeMismatchException;
//import java.util.*;
//
//public class Main {
//    public static void main(String[] args) {
//        Scanner s = new Scanner(System.in);
//
//
//        // Seventh Exercise
//
//        System.out.print("Please enter the size of the array: ");
//        try {
//            int size = s.nextInt();
//            int[] arr = new int[size];
//            boolean exit = false;
//            while (!exit) {
//                System.out.println("-------------------");
//                System.out.println("a. Accept elements of an array");
//                System.out.println("b. Display elements of an array");
//                System.out.println("c. Search the element within array");
//                System.out.println("d. Sort the array");
//                System.out.println("e. Exit");
//                System.out.println("-------------------");
//                System.out.print("please select a character: ");
//                char choice = s.next().charAt(0);
//                switch (choice) {
//                    case 'a':
//                        for (int i = 0; i < arr.length; i++) {
//                            System.out.print("Please enter an integer: ");
//                            arr[i] = s.nextInt();
//                        }
//                        break;
//                    case 'b':
//                        System.out.println(Arrays.toString(arr));
//                        break;
//                    case 'c':
//                        System.out.print("Please enter the number you are searching for: ");
//                        int search = s.nextInt();
//                        boolean flag = false;
//                        for (int i = 0; i < arr.length; i++) {
//                            if (search == arr[i])
//                                flag = true;
//                        }
//                        if (flag) {
//                            System.out.println("The number was found :)");
//                        } else
//                            System.out.println("Sorry the number wasn't found :(");
//                        break;
//                    case 'd':
//                        Arrays.sort(arr);
//                        System.out.println("The sorted array: " + Arrays.toString(arr));
//                        break;
//                    case 'e':
//                        System.out.println("Thank you!!");
//                        exit = true;
//                        break;
//                    default:
//                        try{
//                            throw new Exception();
//                        }
//                        catch (Exception e){
//                            System.out.println("invalid choice try again");
//                        }
//                }
//            }
//        }
//
//        catch(InputMismatchException e){
//            System.out.println("Not an integer");
//        }
//        catch(NegativeArraySizeException e){
//            System.out.println("Size of the array was negative");
//        }
//        catch(Exception e){
//            System.out.println(e.getMessage());
//        }
//
//
//    }
//}