import java.util.ArrayList;
import java.util.Scanner;

public class ArrayListTest {
    public static void main(String args[]){
        Scanner in = new Scanner(System.in);
        System.out.println("Enter the number of number to read:");
        int size = in.nextInt();
        ArrayList<Integer> list = read(in, size);
        print(list);
        list.remove((Integer)1);//removing the object that contains 1
        print(list);
        list.remove(1); //removing an object that is in index 1
        print(list);
    }
    public static ArrayList<Integer> read(Scanner in, int size){
        ArrayList<Integer> lst = new ArrayList<>(size);
        for(int i = 0; i < size; i++){
            System.out.println("Enter an int number: ");
            int num = in.nextInt();
            lst.add(num);
        }
        return lst;
    }
    public static void print(ArrayList<Integer> list){
        for(int i = 0; i < list.size();i++){
            System.out.print(list.get(i) + " ");
        }
        System.out.println();
    }
}
