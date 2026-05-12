import java.io.*;
import java.util.*;

class Student {
    String name;
    int age;
    String grade;

    Student(String name, int age, String grade) {
        this.name = name;
        this.age = age;
        this.grade = grade;
    }

    public String toString() {
        return name + "," + age + "," + grade;
    }
}

public class Main {

    static ArrayList<Student> list = new ArrayList<>();
    static final String FILE = "student.txt";

    // LOAD DATA
    static void load() {
        try {
            File f = new File(FILE);
            if (!f.exists()) return;

            BufferedReader br = new BufferedReader(new FileReader(f));
            String line;

            while ((line = br.readLine()) != null) {
                String[] p = line.split(",");
                list.add(new Student(p[0], Integer.parseInt(p[1]), p[2]));
            }
            br.close();
            System.out.println("Data loaded successfully!");
        } catch (Exception e) {
            System.out.println("Error loading file");
        }
    }

    // SAVE DATA
    static void save() {
        try {
            BufferedWriter bw = new BufferedWriter(new FileWriter(FILE));
            for (Student s : list) {
                bw.write(s.toString());
                bw.newLine();
            }
            bw.close();
            System.out.println("Data saved successfully!");
        } catch (Exception e) {
            System.out.println("Error saving file");
        }
    }

    // DISPLAY
    static void display() {
        if (list.isEmpty()) {
            System.out.println("No records found!");
            return;
        }

        System.out.println("\n--- All Student Records ---");
        for (Student s : list) {
            System.out.println("Name: " + s.name + " | Age: " + s.age + " | Grade: " + s.grade);
        }
    }

    // SEARCH BY NAME
    static void searchName(String name) {
        boolean found = false;
        for (Student s : list) {
            if (s.name.equalsIgnoreCase(name)) {
                System.out.println("Student found! Details: Name: " + s.name + " | Age: " + s.age + " | Grade: " + s.grade);
                found = true;
            }
        }
        if (!found) System.out.println("Student not found!");
    }

    // SEARCH BY GRADE (added as per question)
    static void searchGrade(String grade) {
        boolean found = false;
        for (Student s : list) {
            if (s.grade.equalsIgnoreCase(grade)) {
                System.out.println("Name: " + s.name + " | Age: " + s.age + " | Grade: " + s.grade);
                found = true;
            }
        }
        if (!found) System.out.println("No students found in this grade!");
    }

    // MODIFY
    static void modify(String name, int age, String grade) {
        for (Student s : list) {
            if (s.name.equalsIgnoreCase(name)) {
                s.age = age;
                s.grade = grade;
                System.out.println("Record updated successfully!");
                return;
            }
        }
        System.out.println("Student not found!");
    }

    // DELETE
    static void delete(String name) {
        boolean removed = list.removeIf(s -> s.name.equalsIgnoreCase(name));
        if (removed)
            System.out.println("Record deleted!");
        else
            System.out.println("Student not found!");
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        load();

        int ch;

        do {
            System.out.println("\n---- Student Management System ----");
            System.out.println("1. Add student");
            System.out.println("2. Display");
            System.out.println("3. Search by name");
            System.out.println("4. Search by grade");
            System.out.println("5. Modify");
            System.out.println("6. Delete");
            System.out.println("7. Save & Exit");
            System.out.print("Choice: ");

            ch = sc.nextInt();
            sc.nextLine();

            switch (ch) {
                case 1:
                    System.out.print("Enter name: ");
                    String n = sc.nextLine();
                    System.out.print("Enter age: ");
                    int a = sc.nextInt();
                    sc.nextLine();
                    System.out.print("Enter grade: ");
                    String g = sc.nextLine();
                    list.add(new Student(n, a, g));
                    System.out.println("Student added!");
                    break;

                case 2:
                    display();
                    break;

                case 3:
                    System.out.print("Enter name: ");
                    searchName(sc.nextLine());
                    break;

                case 4:
                    System.out.print("Enter grade: ");
                    searchGrade(sc.nextLine());
                    break;

                case 5:
                    System.out.print("Enter name: ");
                    String mn = sc.nextLine();
                    System.out.print("Enter new age: ");
                    int ma = sc.nextInt();
                    sc.nextLine();
                    System.out.print("Enter new grade: ");
                    String mg = sc.nextLine();
                    modify(mn, ma, mg);
                    break;

                case 6:
                    System.out.print("Enter name: ");
                    delete(sc.nextLine());
                    break;

                case 7:
                    save();
                    System.out.println("Goodbye!");
                    break;

                default:
                    System.out.println("Invalid choice!");
            }

        } while (ch != 7);

        sc.close();
    }
} 
