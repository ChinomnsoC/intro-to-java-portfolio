import java.util.Scanner;

public class Worksheet1 {

    public static void reading(){
        Scanner scr = new Scanner(System.in);
        System.out.println("Reading an entire String line: ");
        String msg2 = scr.nextLine();
        System.out.println("Line read: " + msg2); 
        System.out.println("Reading a String:");
        String msg = scr.next();
        System.out.println("String read: " + msg);
        System.out.println("Reading a double value: ");
        int value = scr.nextDouble();
        System.out.println("double value read: " + value);
        System.out.println("Reading an in value: ");
        int value2 = scr.nextInt();
        System.out.println("int value read: " , value2);
    }

    public static int division(int val1, int val2){
        return val1/val2;
    }

    public static void module(int val1, int val2){
        return val1%val2;
    }

    public static void main(String args[]){
        reading();
        int val1 = 5;
        int val2 = 2;
        System.out.println("5/2 = " + division());
        System.out.println("5/2 = " + module(val1, val2));
        double val3 = 2.0;
        system.out.println("5/2.0 = " + val1/val3);
    }
}

// 1.	The program above has 7 (seven) errors. Find and correct them.
// 2.	Assuming that you corrected all errors, what this the exact output of this program?
// 3.	What happen if we remove import java.util.Scanner; from this program?
// 4.	Analyze the following sentence: “In Java you could either use “” or ‘’ to initialize a String variable.” Is this correct or incorrect? What is the difference of using “” and ‘’?
// If you do not remember this from your readings, search on the Internet. If you need to search, write here the URL you used to base your answer.
// 5.	Write a method that receives a double value as a parameter and return that the double of that value. Write a method call for the method you just created.
