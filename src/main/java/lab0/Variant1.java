package lab0;

import java.util.Arrays;

public class Variant1 {

    /**
     * @param k a 3-digit number
     * @return the first digit moved to last
     */

    public int integerNumbersTask(int k) {
        if (k < 0) {
            throw new AssertionError();
        }
        if (k < 100 || k > 999) {
            return 0;
        }
        String numberString = Integer.toString(k);
        return Integer.parseInt(
                numberString.substring(1) + numberString.charAt(0)
        );
    }

    /**
     * @param numbers is an array of integers
     * @return true, if number is positive
     */
    public boolean booleanTask(int[] numbers) {
        for (int number : numbers) {
            if (number >= 0) {
                return true;
            }
        }
        return false;
    }


    /**
     * @param numbers is an array of integers
     * @return is the median int
     */
    public int ifTask(int[] numbers) {
//        Arrays.sort(numbers); Я загрався треба ж if-ом робити)
//        return numbers[1];
        int a = numbers[0], b = numbers[1], c = numbers[2];
        int median;
        if ((a >= b && a <= c) || (a >= c && a <= b)) {
            median = a;
        } else if ((b >= a && b <= c) || (b >= c && b <= a)) {
            median = b;
        } else {
            median = c;
        }
        return median;
    }


    /**
     * @param elementNumber what is given, value the measurement of given thing
     * @return Triangle measurement
     */
    public double[] switchTask(int elementNumber, double value) {
        double a, c, h, s;

        switch (elementNumber) {
            case 1:
                a = value;
                c = a * Math.sqrt(2);
                h = c / 2;
                s = (c * h) / 2;
                break;

            case 2:
                c = value;
                a = c / Math.sqrt(2);
                h = c / 2;
                s = (c * h) / 2;
                break;

            case 3:
                h = value;
                c = h * 2;
                a = c / Math.sqrt(2);
                s = (c * h) / 2;
                break;

            case 4:
                s = value;
                h = Math.sqrt(s * 2);
                c = h * 2;
                a = c / Math.sqrt(2);
                break;

            default:
                throw new IllegalArgumentException("Invalid element number");
        }

        return new double[]{a, c, h, s};
    }


    /**
     * @param n is integer number
     * @return approximated value of exp(1)
     */
    public double forTask(int n) {
        assert n > 0 : "Argument should be more than zero";
        double result = 0.0;
        for (int i = 1; i <= n; i++) {
            double term = 1.0 + 0.1 * i;
            if (i % 2 != 0) {
                result += term;
            } else {
                result -= term;
            }
        }
        return Math.round(result * 10.0) / 10.0;
    }


    public double[] whileTask(double a) {
        if (a < 0) {
            throw new AssertionError();
        }
        int k = 1;
        double sum = 0.0;

        while (sum <= a) {
            sum += 1.0 / k;
            k++;
        }
        return new double[]{k - 1, sum};
    }

    public double[] arrayTask(double[] array) {
        int n = array.length;
        int j = 0;
        int additional = 0;
        if (n % 2 != 0) {
            ++additional;
        }
        double[] result = new double[n / 2 + additional];
        for (int i = n - 1; i >= 0; --i) {
            if (i % 2 == 0) {
                result[j] = array[i];
                ++j;
            }
        }
        return result;
    }

    /**
     *  Дано квадратну матрицю A порядку M M. Починаючи з елемента 1,1,
     *  вивести її елементами наступним чином (куточками): все;
     *  елементи першого рядка; елементи останнього стовпця,
     *  крім першого (вже виведеного) елемента; елементи другого рядка, що залишилися;
     *  елементи, що залишилися у передостанньому стовпці й т. д.;
     *  останнім виводиться елемент A[M,M]>.
     * @return перетворена матриця
     */
    public int[][] twoDimensionArrayTask(int[][] matrix) {
        int initMatrixSize = matrix.length;
        int initArrayLength = matrix.length + matrix[0].length;
        for (int i = 0; i < initMatrixSize; i++) {
            matrix[i] = Arrays.copyOf(matrix[i], initArrayLength - 1 - (2 * i));
            for (int j = i + 1; j < initMatrixSize; j++) {
                 matrix[i][matrix[i].length - initMatrixSize + j] = matrix[j][initMatrixSize - i - 1];
            }
        }
        return matrix;
    }
}