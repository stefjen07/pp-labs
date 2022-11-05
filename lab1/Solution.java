public class Solution {
    double compute(double x, double error) {
        double numerator = 1;
        double denominator = 2;
        double coefficient = -0.5;
        int index = 1;

        double result = 0;
        double lastTerm = 1;
        while(Math.abs(lastTerm) >= error) {
            result += lastTerm;
            lastTerm = coefficient * Math.pow(x, index);

            numerator += 2;
            denominator += 2;
            coefficient *= numerator / denominator;
            coefficient = -coefficient;
            index++;
        }

        return result;
    }
}
