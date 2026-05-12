package Puzzle;
import java.util.Scanner;

public class PuzzleSolver {

    private int n;
    private int[] arr;

    // Set size
    public void setSize(int num) {
        n = num;
    }

    // Set array
    public void setArray(int[] a) {
        arr = a;
    }

    // Missing number
    public int missing(int s, int s1) {
        int result = s - s1;
        return result;
    }

    // Bubble Sort
    public void sortArray() {

        for (int i = 0; i < n - 1; i++) {

            for (int j = 0; j < n - 1 - i; j++) {

                if (arr[j] > arr[j + 1]) {

                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;

                }
            }
        }

        System.out.print("Sorted Array: ");

        for (int i = 0; i < n; i++) {
            System.out.print(arr[i] + " ");
        }

        System.out.println();
    }

    // Search element
    public void searchElement(int key) {

        boolean found = false;

        for (int i = 0; i < n; i++) {

            if (arr[i] == key) {
                found = true;
                break;
            }

        }

        if (found)
            System.out.println("Element Found!");
        else
            System.out.println("Element Not Found!");
    }

    // Find largest
    public int findMax() {

        int max = arr[0];

        for (int i = 1; i < n; i++) {

            if (arr[i] > max)
                max = arr[i];

        }

        return max;
    }

    // Find smallest
    public int findMin() {

        int min = arr[0];

        for (int i = 1; i < n; i++) {

            if (arr[i] < min)
                min = arr[i];

        }

        return min;
    }

    // Sum pair puzzle
    public void sumPairs(int target) {

        boolean found = false;

        for (int i = 0; i < n; i++) {

            for (int j = i + 1; j < n; j++) {

                if (arr[i] + arr[j] == target) {

                    System.out.println(arr[i] + " , " + arr[j]);
                    found = true;

                }
            }
        }

        if (!found)
            System.out.println("No pairs found!");
    }

    // MAIN METHOD
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        PuzzleSolver ps = new PuzzleSolver();

        int size;
        int choice;

        System.out.println("Array Puzzle Solver");

        // Step 1: Enter size
        System.out.print("Enter size of array: ");
        size = sc.nextInt();

        ps.setSize(size);

        // Step 2: Enter array
        int[] array = new int[size];
        int expectedSum = (size * (size + 1)) / 2;

        System.out.println("Enter array elements:");

        for (int i = 0; i < size; i++) {

            array[i] = sc.nextInt();

        }

        ps.setArray(array);

        // Step 3: Menu
        do {

            System.out.println("\nMENU");
            System.out.println("1. Find Missing Number");
            System.out.println("2. Sort Array");
            System.out.println("3. Search Element");
            System.out.println("4. Find Largest");
            System.out.println("5. Find Smallest");
            System.out.println("6. Sum Pair Puzzle");
            System.out.println("7. Exit");

            System.out.print("Enter choice: ");
            choice = sc.nextInt();

            switch (choice) {

                case 1:

                    int actualSum = 0;

                    System.out.println("Enter elements except missing number:");

                    for (int i = 0; i < size - 1; i++) {

                        int num = sc.nextInt();
                        actualSum = actualSum + num;

                    }

                    System.out.println("Missing Number = "
                            + ps.missing(expectedSum, actualSum));

                    break;

                case 2:

                    ps.sortArray();
                    break;

                case 3:

                    System.out.print("Enter element to search: ");
                    int key = sc.nextInt();

                    ps.searchElement(key);

                    break;

                case 4:

                    System.out.println("Largest Element = " + ps.findMax());
                    break;

                case 5:

                    System.out.println("Smallest Element = " + ps.findMin());
                    break;

                case 6:

                    System.out.print("Enter target sum: ");
                    int target = sc.nextInt();

                    ps.sumPairs(target);

                    break;

                case 7:

                    System.out.println("Program Ended");
                    break;

                default:

                    System.out.println("Invalid choice");

            }

        } while (choice != 7);

        sc.close();
    }
}

