import java.util.Random;
import java.util.Scanner;

public class Table {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int size;

        // Read array size
        while (true) {
            System.out.print("Enter array size (for PxP array): ");

            if (!sc.hasNextInt()) {
                System.out.println("Invalid input! Please enter an integer.\n");
                sc.next();
                continue;
            }

            size = sc.nextInt();

            if (size <= 0) {
                System.out.println("Array size must be greater than 0.\n");
                continue;
            }
            break;
        }

        int[][] arr = new int[size][size];
        Random random = new Random();

        // Generate random even numbers between 2 and 16
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                arr[i][j] = (random.nextInt(8) + 1) * 2;
            }
        }

        System.out.println("\nGenerated 2D array:\n");
        printTable(arr, -1);

        int highlight;

        // Read highlight number
        while (true) {
            System.out.print("\nEnter a number to highlight (even number 2-16): ");

            if (!sc.hasNextInt()) {
                System.out.println("Invalid input! Please enter an integer.\n");
                sc.next();
                continue;
            }

            highlight = sc.nextInt();

            if (highlight < 2 || highlight > 16 || highlight % 2 != 0) {
                System.out.println("Please enter an EVEN number between 2 and 16.\n");
                continue;
            }

            break;
        }

        System.out.println("\nArray with " + highlight + " highlighted:\n");

        int count = printTable(arr, highlight);

        System.out.println("\nNumber " + highlight + " appeared " + count + " time(s).");

        sc.close();
    }

    static int printTable(int[][] arr, int highlight) {

        int n = arr.length;
        int count = 0;

        // Column header
        System.out.print("    ");
        for (int i = 0; i < n; i++) {
            System.out.printf("%4s", String.format("%02d", i));
        }
        System.out.println();

        // Border
        System.out.print("   +");
        for (int i = 0; i < n; i++) {
            System.out.print("----+");
        }
        System.out.println();

        for (int i = 0; i < n; i++) {

            System.out.printf("%02d |", i);

            for (int j = 0; j < n; j++) {

                if (arr[i][j] == highlight) {
                    System.out.printf("[%2d]|", arr[i][j]);
                    count++;
                } else {
                    System.out.printf(" %2d |", arr[i][j]);
                }

            }

            System.out.println();

            System.out.print("   +");
            for (int j = 0; j < n; j++) {
                System.out.print("----+");
            }
            System.out.println();
        }

        return count;
    }
}
