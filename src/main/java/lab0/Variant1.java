package lab0;

import java.util.Arrays;

public class Variant1 {

    /**
     * Дано тризначне число. В ньому закреслили першу ліворуч цифру і приписали її праворуч.
     * Вивести отримане число.
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
     * Дано три цілих числа: A, B, C.
     * Перевірити істинність висловлювання: Хоча б одне з чисел A, B, C позитивне;
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
     * Дано три числа. Знайти середнє з них (тобто є число, розташоване між найменшим і найбільшим)
     */
    public int ifTask(int[] numbers) {
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
     * Елементи рівнобедреного прямокутного трикутника пронумеровані в такий спосіб:
     *  1 — катет a,
     *  2 — гіпотенуза c = a·2^1/2,
     *  3 — висота h, опущена на гіпотенузу (h = c/2),
     *  4 — площа S = c·h/2.
     *  Даний номер одного з цих елементів і його значення.
     *  Вивести значення решти елементів даного трикутника (в тому ж порядку).
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
     * Дано ціле число N (> 0). Знайти значення виражень
     * 1.1 – 1.2 + 1.3 – …
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

    /**
     * Дано число A (>1). Вивести найменше з цілих чисел K,
     * для яких сума 1 + 1/2 + … + 1/K буде більше A, і саму цю суму.
     */

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

    /**
     * Дано масив A розміру N (N — непарне число).
     * Вивести його елементи з непарними індексів в порядку зменшення індексів
     * Умовний оператор не використовує.
     */

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