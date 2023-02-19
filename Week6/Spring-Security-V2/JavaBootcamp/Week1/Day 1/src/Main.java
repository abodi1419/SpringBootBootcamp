import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);


        // First Exercise
//        System.out.println("Input first number:");
//        int number1 = s.nextInt();
//        System.out.println("Input second number:");
//        int number2 = s.nextInt();
//
//        System.out.println(number1 + " + " + number2 + " = " + (number1+number2));
//        System.out.println(number1 + " - " + number2 + " = " + (number1-number2));
//        System.out.println(number1 + " * " + number2 + " = " + (number1*number2));
//        System.out.println(number1 + " / " + number2 + " = " + (number1/number2));
//        System.out.println(number1 + " % " + number2 + " = " + (number1%number2));



        // Second Exercise
//        System.out.print("Input a string: ");
//        String sentence = s.nextLine();
//
//        System.out.println(sentence.toLowerCase());



        // Third Exercise
//        System.out.print("Input a number: ");
//        int number = s.nextInt();
//
//        if(number % 2 == 0){
//            System.out.println(1);
//        }
//        else {
//            System.out.println(0);
//        }



        // Fourth Exercise
//        System.out.print("Enter your role: ");
//        String sentence1 = s.nextLine();
//
//        if(sentence1.equals("admin"))
//            System.out.println("welcome admin");
//        else if(sentence1.equals("superuser"))
//            System.out.println("welcome superuser");
//        else if(sentence1.equals("user"))
//            System.out.println("welcome user");
//        else
//            System.out.println("welcome");



        // Fifth Exercise
//        System.out.println("Input the first number:");
//        int num1 = s.nextInt();
//        System.out.println("Input the second number:");
//        int num2 = s.nextInt();
//        System.out.println("Input the third number:");
//        int num3 = s.nextInt();
//
//        if((num1+num2) == num3){
//            System.out.println("true");
//        }
//        else {
//            System.out.println("false");
//        }



        // Sixth Exercise
//        System.out.println("Input the first number:");
//        int number1st = s.nextInt();
//        int greatest = number1st;
//
//        System.out.println("Input the second number:");
//        int number2nd = s.nextInt();
//
//        if(number2nd > greatest){
//            greatest = number2nd;
//        }
//
//        System.out.println("Input the third number:");
//        int number3rd = s.nextInt();
//
//        if(number3rd > greatest){
//            greatest = number3rd;
//        }
//
//        System.out.println("The greatest: " + greatest);



        //Seventh Exercise
        System.out.println("Input number: ");
        int day = s.nextInt();

        switch (day){
            case 1: System.out.println("Sunday");
                break;
            case 2: System.out.println("Monday");
                break;
            case 3: System.out.println("Tuesday");
                break;
            case 4: System.out.println("Wednesday");
                break;
            case 5: System.out.println("Thursday");
                break;
            case 6: System.out.println("Friday");
                break;
            case 7: System.out.println("Saturday");
                break;
            default: System.out.println("Wrong number");
        }


    }
}