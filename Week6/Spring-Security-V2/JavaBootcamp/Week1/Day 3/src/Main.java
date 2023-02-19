import java.lang.annotation.AnnotationTypeMismatchException;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);


        // First Exercise
//        int[] arr= {50, -20, 0, 30, 40, 60, 10};
//        System.out.print(arr[0]==arr[arr.length-1]);


        // Second Exercise
//        int[] arr = {1, 4, 17, 7, 25, 3, 100};
//        int[] arrlargest = new int[3];
//        int largest=0,indx=0;
//        for (int i = 0; i < 3; i++) {
//            for (int j = 0; j < arr.length; j++) {
//                if(arr[j]>largest){
//                    largest = arr[j];
//                    indx = j;
//                }
//            }
//            arr[indx] = 0;
//            arrlargest[i] = largest;
//            largest = 0;
//        }
//        System.out.print("3 largest elements of the said array are: " + Arrays.toString(arrlargest));


        // Third Exercise
//        int[] arr={1, 4, 17, 7, 25, 3, 100};
//        ArrayList<Integer> larger = new ArrayList<>();
//        int sum=0;
//        double average = 0.0;
//
//        for (int i = 0; i < arr.length; i++) {
//            sum +=arr[i];
//        }
//        average = sum/arr.length;
//        for (int i = 0; i < arr.length; i++) {
//            if(arr[i]>average){
//                larger.add(arr[i]);
//            }
//        }
//        System.out.println("The average of the said array is: " + average);
//        System.out.println("The numbers in the said array that are greater than the average are: " + larger);


        // Forth Exercise
//        int[] arr = {20,30,40};
//        int largest = 0;
//        if(arr[0]>arr[arr.length-1]){
//            largest = arr[0];
//        }
//        else {
//            largest = arr[arr.length-1];
//        }
//        System.out.println("Larger value between first and last element: " + largest);



        // Fifth Exercise
//        int[] arr = {20,30,40};
//        int temp = arr[0];
//        arr[0] = arr[arr.length-1];
//        arr[arr.length-1] = temp;
//        System.out.println("New array after swapping the first and last elements: " + Arrays.toString(arr));


        // Sixth Exercise
//        String[] words = { "cat", "dog", "red", "is", "am"};
//        int largestLength = 0;
//        for (int i = 0; i < words.length; i++) {
//            if(words[i].length() > largestLength){
//                largestLength = words[i].length();
//            }
//        }
//        for (int i = 0; i < words.length; i++) {
//            if (words[i].length() == largestLength){
//                System.out.print(words[i] + ", ");
//            }
//        }


        // Seventh Exercise

        System.out.print("Please enter the size of the array: ");
        try {
            int size = s.nextInt();
            int[] arr = new int[size];
            boolean exit = false;
            while (!exit) {
                System.out.println("-------------------");
                System.out.println("a. Accept elements of an array");
                System.out.println("b. Display elements of an array");
                System.out.println("c. Search the element within array");
                System.out.println("d. Sort the array");
                System.out.println("e. Exit");
                System.out.println("-------------------");
                System.out.print("please select a character: ");
                char choice = s.next().charAt(0);
                switch (choice) {
                    case 'a':
                        for (int i = 0; i < arr.length; i++) {
                            System.out.print("Please enter an integer: ");
                            arr[i] = s.nextInt();
                        }
                        break;
                    case 'b':
                        System.out.println(Arrays.toString(arr));
                        break;
                    case 'c':
                        System.out.print("Please enter the number you are searching for: ");
                        int search = s.nextInt();
                        boolean flag = false;
                        for (int i = 0; i < arr.length; i++) {
                            if (search == arr[i])
                                flag = true;
                        }
                        if (flag) {
                            System.out.println("The number was found :)");
                        } else
                            System.out.println("Sorry the number wasn't found :(");
                        break;
                    case 'd':
                        Arrays.sort(arr);
                        System.out.println("The sorted array: " + Arrays.toString(arr));
                        break;
                    case 'e':
                        System.out.println("Thank you!!");
                        exit = true;
                        break;
                    default:
                        try{
                            throw new Exception();
                        }
                        catch (Exception e){
                            System.out.println("invalid choice try again");
                        }
                    }
                }
            }

        catch(InputMismatchException e){
            System.out.println("Not an integer");
        }
        catch(NegativeArraySizeException e){
            System.out.println("Size of the array was negative");
        }
        catch(Exception e){
            System.out.println(e.getMessage());
        }




        // eighth Exercise
//        int[] arr = {1,1,1,3,3,5};
//        System.out.print("enter a number to see how many time it occurs: ");
//        int number = s.nextInt();
//        int counter=0;
//        for (int i = 0; i < arr.length; i++) {
//            if(arr[i]==number){
//                counter++;
//            }
//        }
//        System.out.print("The number " + number + " occurred " + counter + " times");


        //ninth exercise
//        int[] arr = {2,3,40,1,5,9,4,10,7};
//        ArrayList<Integer> newArr = new ArrayList<Integer>();
//
//        for (int i = 0; i < arr.length; i++) {
//            if(arr[i] %2 == 1)
//                newArr.add(arr[i]);
//        }
//        for (int i = 0; i < arr.length; i++) {
//            if(arr[i] %2 == 0)
//                newArr.add(arr[i]);
//        }
//        System.out.print("The new array is " + newArr);


        // Tenth Exercise
//        int[] arr1 = {2,3,6,6,4};
//        int[] arr2 = {2,3,6,6,4};
//        boolean flag = true;
//        if(arr1.length>arr2.length || arr2.length>arr1.length)
//            System.out.print("false");
//        else {
//            for (int i = 0; i <arr1.length; i++) {
//                if(arr1[i] != arr2[i]){
//                    flag = false;
//                    break;
//                }
//            }
//            if(flag)
//                System.out.print("true");
//            else
//                System.out.print("false");
//        }



    }
}