/**
 * <h1>Number Counter</h1>
 * <p>The Fibonacci program implements an application that
 * displays odd and even numbers on given interval, their sum and also it counts percentage of odd
 * and even Fibonacci numbers on given interval
 * <p>
 *
 * @author AlexDex
 * @version 1.0
 * @since 2018-11-12
 */

import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * This is the main method which performs calculation.
 * exception InputMismatchException On input error.
 */
public class Main {
    /**Main method */
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter starting number");
        try {
            int a = sc.nextInt();
            System.out.println("Enter ending number");
            int b = sc.nextInt();
            /**Checking if user input is >0 */
            if ((a > 0) && (b > 0)) {
                /**Performing advanced swap to change numbers if a>b*/
                if (b < a) {
                    a = a + b;
                    b = a - b;
                    a = a - b;
                }
                System.out.println("Odd Numbers Ascending");
                /**Cycle for displaying odd numbers in ascending and their sum*/
                int summator = 0;
                for (int i = a; i <= b; i++) {
                    if ((i % 2) != 0) {
                        System.out.print(i + " ");
                        summator += i;
                    }
                }
                System.out.println("\n" + "Sum of Odd Numbers is " + summator);

                /**Cycle for displaying even numbers in descending order and their sum*/
                System.out.println("\n" + "Even Numbers Descending ");
                for (int j = b; j >= a; j--) {
                    if ((j % 2) == 0) {
                        System.out.print(j + " ");
                        summator += j;
                    }
                }
                System.out.println("\n" + "Sum of Odd Numbers is " + summator);
                throw new InputMismatchException();
            }
            /**checking if interval numbers are positive*/
            else {
                System.out
                    .print("Please Enter positive numbers for evaluation of odd and even numbers");
                throw new InputMismatchException();
            }
        }
        /**Catching invalid user inputs*/ catch (InputMismatchException e) {
            System.out.print("Please Enter only numbers not letters!");

        }

        /**Reading from user Fibonacci numbers to evaluate */
        System.out.println("\n" + "Enter max Number for Fibonacci numbers Set");
        try {
            int fibmaxset = sc.nextInt();
            /**Checking if at least one number in Fibonacci*/
            if (fibmaxset >= 1) {
                int f[] = new int[fibmaxset + 2];
                f[0] = 0;
                f[1] = 1;
                int summatorodd = 0;
                int summatoreven = 0;
                int F1 = 0;
                int F2 = 0;
                int counter = 2;
                /**Building array of fibonacci numbers and counting them*/
                for (int i = 2; i <= fibmaxset; i++) {
                    f[i] = f[i - 1] + f[i - 2];
                    counter += 1;

                }
                for (int i = 0; i <= counter; i++) {
                    if (f[i] == 0) {
                        continue;
                    }
                    /**Loop through array of fibonacci numbers and counting odd and even*/
                    if ((f[i] % 2) != 0) {
                        summatorodd += 1;
                        F1 = f[i];
                    }
                    if ((f[i] % 2) == 0) {
                        summatoreven += 1;
                        F2 = f[i];
                    }
                }
                System.out.println("\n" + "Max Odd Fibonacci number is ");
                System.out.print(F1);
                System.out.println("\n" + "Max Even Fibonacci number is ");
                System.out.print(F2);
                System.out.println("\n" + "Percentage of Odd Fibonacci numbers in this  set is");
                System.out.print(summatorodd * 100 / fibmaxset);
                System.out.print("%");
                System.out.println("\n" + "Percentage of Even Fibonacci numbers in this set is");
                System.out.print(summatoreven * 100 / fibmaxset);
                System.out.print("%");

            }
            /**checking if user doesn't input less than 1, so we don't divine on zero */
            else {
                System.out.print("Please Enter more then 0 Fibonacci numbers to compare");

            }
        }
        /**@exeption catching invalid user inputs*/ catch (InputMismatchException e) {
            System.out.print("Please Enter only numbers not letters!");

        }
    }
}



