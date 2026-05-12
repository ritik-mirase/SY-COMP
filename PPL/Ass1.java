import java.util.Scanner;

class Student {
    int studentID;
    private String name;
    private double[] marks;
    private double avg;

    public Student() {
    }

    // Setter methods
    public void setStudentID(int ID) {
        studentID = ID;
    }

    public void setName(String n) {
        name = n;
    }

    public void setMarks(double[] mark) {
        marks = mark;
    }

    // Getter methods
    public int getStudentID() {
        return studentID;
    }

    public String getName() {
        return name;
    }

    public double[] getMarks() {
        return marks;
    }

    // Calculate Average
    public double calcAvg() {
        avg = 0;
        for (int i = 0; i < marks.length; i++) {
            avg += marks[i];
        }
        avg = avg / marks.length;
        return avg;
    }

    // Check Result
    public String result() {
        double percent = avg;
        int res = 0;
        // Check percentage
        if (percent < 50) {
            res = 1;
        }
        // Check subject marks
        for (int i = 0; i < marks.length; i++) {
            if (marks[i] < 40) {
                res = 1;
            }
        }
        if (res == 1) {
            return "Failed";
        } else {
            return "Passed";
        }
    }

    // Display student details
    public void display() {
        System.out.println("\nStudent ID : " + studentID);
        System.out.println("Student Name : " + name);
        System.out.print("Marks : ");
        for (int i = 0; i < marks.length; i++) {
            System.out.print(" " + marks[i]);
        }
        System.out.println("\nAverage : " + calcAvg());
        System.out.println("Result : " + result());
    }
}

public class PPL1 {
    public static void main(String[] args) {
        Scanner obj = new Scanner(System.in);
        Student s1 = new Student();
        System.out.println("Student Performance Evaluation System\n");
        System.out.print("Enter name : ");
        String name = obj.nextLine();
        s1.setName(name);
        System.out.print("Enter ID : ");
        int id = obj.nextInt();
        s1.setStudentID(id);
        System.out.print("Enter number of subjects : ");
        int num = obj.nextInt();
        double[] arr = new double[num];
        for (int i = 0; i < num; i++) {
            System.out.print("Marks for subject " + (i + 1) + " : ");
            arr[i] = obj.nextDouble();
        }
        s1.setMarks(arr);
        s1.display();
        obj.close();
    }
}
