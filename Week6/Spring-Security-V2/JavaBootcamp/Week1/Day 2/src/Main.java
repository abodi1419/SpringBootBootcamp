import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);

        // First Exercise
//        for (int i = 1; i <= 100; i++) {
//            if((i%3==0) && (i%5==0)){
//                System.out.println("FizzBuzz");
//            } else if(i%3==0){
//                System.out.println("Fizz");
//            } else if(i%5==0) {
//                System.out.println("Buzz");
//            }
//        }


        // Second Exercise
//        System.out.print("input a String: ");
//        String sentence = s.nextLine();
//        String reverse = "";
//
//        for (int i = sentence.length()-1; i >= 0; i--) {
//            reverse += sentence.charAt(i);
//        }
//        System.out.print(reverse);


        // Third Exercise
//        int num;
//        do{
//            System.out.print("Please enter a positive integer: ");
//            num = s.nextInt();
//        }while(num<1);
//        for(int i=1;i<=10; i++){
//            System.out.println( num + " * " + i + " = " + (num*i));
//        }


        // Forth Exercise
//        int num;
//        int factorial = 1;
//        do{
//            System.out.print("Please enter an integer above 1: ");
//            num = s.nextInt();
//        }while(num<2);
//        for(int i= num; i>1; i--){
//            factorial *= (i);
//        }
//        System.out.print("The factorial of " + num + " is " + factorial);


        // Fifth Exercise
//        System.out.print("Please enter first number: ");
//        int num1 = s.nextInt();
//        System.out.print("Please enter the second number: ");
//        int num2 = s.nextInt();
//
//        int value = num1;
//
//        for (int i = 1; i < num2; i++) {
//            value *= num1;
//        }
//        System.out.print(num1 + "^" + num2 + " = " + value);


        // Sixth Exercise
//        int num,even=0,odd=0;
//        do {
//            System.out.print("Please enter a number(-1 to exit): ");
//            num = s.nextInt();
//            if(num % 2 == 0){
//                even += num;
//            }
//            else if(num % 2 == 1){
//                odd += num;
//            }
//        }while (num != -1);
//
//        System.out.println("The sum of the even numbers is: " + even);
//        System.out.println("The sum of the odd numbers is: " + odd);


        // Seventh Exercise
//        System.out.print("Please enter a number above 2: ");
//        int num = s.nextInt();
//        boolean flag = false;
//        for (int i = 2; i <= num/2; i++) {
//            if(num % i == 0){
//                flag = true;
//                break;
//            }
//        }
//        if(!flag){
//            System.out.print(num + " is a prime number");
//        }else
//            System.out.print(num + " is not a prime number");


//         eighth Exercise
        int num;
        int countP=0;
        int countN=0;
        int count0=0;
        String exit = "";
        while(true){
            System.out.print("Please enter a number: ");
            num = s.nextInt();
            if(num > 0){
                countP++;
            }
            else if(num < 0){
                countN++;
            }
            else {
                count0++;
            }
            System.out.print("Would you like to continue? (y/n) ");
            exit = s.next();
            if(exit.equals("n"))
                break;
        }

        System.out.println("The number of the positive numbers is: " + countP);
        System.out.println("The number of the negative numbers is: " + countN);
        System.out.println("The number of zeros is: " + count0);


        // Ninth Exercise
//        for (int i = 1; i <= 4; i++) {
//            System.out.println("Week"+ i);
//            for (int j = 1; j <= 7; j++) {
//                System.out.println("Day"+j);
//            }
//        }


        // Tenth Exercise
//        System.out.print("input a String: ");
//        String sentence = s.nextLine();
//        String reverse = "";
//
//        for (int i = sentence.length()-1; i >= 0; i--) {
//            reverse += sentence.charAt(i);
//        }
//
//        if(sentence.equals(reverse)){
//            System.out.print("Your string is a palindrome");
//        } else {
//            System.out.print("Your string is not a palindrome");
//        }



    }
}