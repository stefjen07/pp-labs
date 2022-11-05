import java.util.Random;
import java.util.function.BiFunction;

interface Comparator {
    int operation(int x, int y);
}

public class Matrix {
    int n, m;
    int[][] matrix;
    int[] maxInRows;
    int[] minInRows;

    void print() {
        for(int i=0;i<n;i++) {
            for(int j=0;j<m;j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
    }

    void calculateMinAndMaxOfRows() {
        calculateExtremesOfRows(maxInRows, Math::max);
        calculateExtremesOfRows(minInRows, Math::min);
    }

    void calculateExtremesOfRows(int[] destination, BiFunction<Integer, Integer, Integer> comparator) {
        for(int i=0;i<n;i++) {
            destination[i] = matrix[i][0];

            for(int j=1;j<m;j++) {
                destination[i] = comparator.apply(destination[i], matrix[i][j]);
            }
        }
    }

    void swapMinAndMax() {
        int maxRowValue = maxInRows[0], minRowValue = minInRows[0];
        int maxRowIndex = 0, minRowIndex = 0;

        for(int i=1;i<n;i++) {
            if(maxRowValue < maxInRows[i]) {
                maxRowValue = maxInRows[i];
                maxRowIndex = i;
            }

            if(minRowValue > minInRows[i]) {
                minRowValue = minInRows[i];
                minRowIndex = i;
            }
        }

        if(maxRowIndex == minRowIndex)
            return;

        int temp;
        for(int i=0;i<m;i++) {
            temp = matrix[maxRowIndex][i];
            matrix[maxRowIndex][i] = matrix[minRowIndex][i];
            matrix[minRowIndex][i] = temp;
        }
    }

    int get(int x, int y) {
        return matrix[x][y];
    }

    Matrix(int n, int m) {
        this.n = n;
        this.m = m;

        matrix = new int[n][m];
        maxInRows = new int[n];
        minInRows = new int[n];

        Random random = new Random();
        for(int i=0;i<n;i++) {
            for(int j=0;j<m;j++) {
                matrix[i][j] = random.nextInt() % 10;
            }
        }
    }
}
