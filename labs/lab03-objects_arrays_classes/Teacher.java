import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

/*
 * Why might you want to use an Array instead of an ArrayList?
 * You might want to use an Array instead of an Arraylist when you know the exact size of the array, 
 * and it isn't growing. Also, because they are more memory efficient

 * When might our Array not be useful?
 * When you don't know the size in advance, and when we need to perform functions like search, sort etc.

 * What might we want to use an ArrayList for that we can’t use an Array for?
 * When we need an array that dynamically grows, and we want to be able to make calls like get, add, contains etc

 * What is the type in Python that most closely resembles an ArrayList?
 * A list
 */

public class Teacher {
    Student[] remembered = new Student[100];
    ArrayList<Student> students = new ArrayList<>();
    int curr = 0;

    public Teacher(String studentFile, String knownFile) {
        try {
            // This is some file reading. You will learn how to do this yourself later,
            // But for now, just know that this code is reading from a file with all
            // students and
            // with known students to fill its Array and ArrayList
            Scanner stu = new Scanner(new File(studentFile));
            Scanner know = new Scanner(new File(knownFile));
            while (stu.hasNext()) {
                String name = stu.next();
                int ID = Integer.parseInt(stu.next());
                students.add(new Student(name, ID));
            }
            while (know.hasNext()) {
                if (curr == remembered.length) {
                    break;
                }
                String name = know.next();
                int ID = Integer.parseInt(know.next());
                remembered[curr] = new Student(name, ID);
                curr++;
            }

        } catch (FileNotFoundException e) {
            System.out.println("File not found!");
        }
    }

    // This code adds new students to the Array of students with their names
    // remembered. If the Array is full, it returns false, else it returns true
    public boolean remember(Student s) {
        if (remembered.length != curr) {
            remembered[curr] = s;
            curr++;
            return true;
        }
        return false;
    }

    /*
     * If the Student's name and ID match the name and ID of one of the students in
     * the remembered Array, return the Student's name.
     * If it isn't in the array or if you have reached a null entry, return
     * "Er...You"
     */
    // Refer to the directions for how to code this
    public String recallName(Student s) {
        /*
         * FUNCTION recallName(Student s):
         * FOR each index i from 0 to remembered.length - 1:
         * IF remembered[i] is null:
         * RETURN "Er...You" // Reached empty slot, student not found
         * 
         * IF remembered[i].name equals s.name AND remembered[i].ID equals s.ID:
         * RETURN s.name // Found matching student
         * 
         * RETURN "Er...You" // Searched entire array, no match foun
         */

        for (int i = 0; i <= remembered.length - 1; i++) {
            if (remembered[i] == null) {
                return "Er...You";
            }
            if (remembered[i].getName().equals(s.getName()) && remembered[i].getID() == (s.getID())) {
                return s.getName();
            }
        }
        return "Er...You";
    }

    public static void main(String[] args) {
        Teacher Steven = new Teacher("Students.txt", "Memorable.txt");
        // Teacher Steven = new Teacher("Students.txt", "Memorable.txt");
        Student Jacob = new Student("Jacob", 679);
        Student Adeline = new Student("Adeline", 276);
        Steven.recallName(Jacob);   //Would return "Er...You"
        Steven.recallName(Adeline);   //Would return "Adeline"
    }
}