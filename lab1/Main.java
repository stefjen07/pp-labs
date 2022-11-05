import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        double x;
        int k;

        Scanner scanner = new Scanner(System.in);
        x = scanner.nextDouble();
        k = scanner.nextInt();

        double error = Math.pow(10, -k);

        Solution solution = new Solution();
        System.out.printf("%.3f %.3f\n", solution.compute(x, error), 1.0/Math.sqrt(1+x));
    }
}