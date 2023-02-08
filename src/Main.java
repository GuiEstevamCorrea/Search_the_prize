import java.util.Scanner;
import java.util.Random;

public class Main {
    static int rows, columns, prizeRow, prizeColumn, tries;
    static char[][] matrix;
    static Scanner sc = new Scanner(System.in);
    static Random random = new Random();

    public static void main(String[] args) {
        while (true) {
            showMenu();
            int option = sc.nextInt();
            if (option == 1) {
                initializeGame();
                play();
            } else if (option == 2) {
                System.out.println("Exit the game...");
                break;
            } else {
                System.out.println("Invalid position, try again.");
            }
        }
    }

    static void showMenu() {
        System.out.println("Menu:");
        System.out.println("1. Play");
        System.out.println("2. Exit");
        System.out.print("Option: ");
    }

    static void initializeGame() {
        System.out.print("Enter the number of rows in the matrix: ");
        rows = sc.nextInt();
        System.out.print("Enter the number of columns in the matrix: ");
        columns = sc.nextInt();

        matrix = new char[rows][columns];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                matrix[i][j] = '*';
            }
        }

        prizeRow = random.nextInt(rows);
        prizeColumn = random.nextInt(columns);
        tries = 0;
    }

    static void play() {
        while (true) {
            printMatrix();
            System.out.print("Inform the line: ");
            int row = sc.nextInt();
            System.out.print("Inform the column: ");
            int column = sc.nextInt();

            if (row < 0 || row >= rows || column < 0 || column >= columns) {
                System.out.println("Invalid position, try again.");
                continue;
            }

            tries++;
            if (row == prizeRow && column == prizeColumn) {
                System.out.println("Congratulations, you found the prize!");
                System.out.println("Number of attempts: " + tries);
                matrix[row][column] = 'P';
                printMatrix();
                break;
            }
        }
    }

    static void printMatrix() {
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
    }
}