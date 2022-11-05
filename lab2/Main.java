import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();

        Matrix matrix = new Matrix(n, m);

        matrix.print();
        System.out.println();

        matrix.calculateMinAndMaxOfRows();
        matrix.swapMinAndMax();

        matrix.print();
        System.out.println();

        matrix.calculateMinAndMaxOfRows();
        int diagonalSize = Math.min(n, m);
        for(int i=0;i<diagonalSize;i++) {
            if(matrix.get(i, i) == 0) {
                System.out.println(i+1 + " " + matrix.maxInRows[i]);
            }
        }
    }
}