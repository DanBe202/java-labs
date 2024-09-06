package test;

import static org.testng.Assert.assertEquals;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import lab0.Variant1;

public class TestVariant1 {

    ////////////////////////////////////////////////
    //Дано тризначне число. В ньому закреслили першу ліворуч цифру і приписали її праворуч. Вивести отримане число.

    @Test(dataProvider = "integerProvider")
    public void inputTest(int p1, int p3) {
        assertEquals(new Variant1().integerNumbersTask(p1), p3);
    }

    @DataProvider
    public Object[][] integerProvider() {
        return new Object[][]{{100, 1}, {12, 0}, {139, 391}};
    }

    @Test(expectedExceptions = AssertionError.class)
    public void negativeIntegerTest() {
        new Variant1().integerNumbersTask(-2);
    }

    ////////////////////////////////////////////////
    //Дано три числа. Знайти середнє з них (тобто є число, розташоване між найменшим і найбільшим)

    @Test(dataProvider = "ifProvider")
    public void ifTest(int p1, int p2, int p3, int p4) {
        assertEquals(new Variant1().ifTask(new int[]{p1, p2, p3}), p4);
    }

    @DataProvider
    public Object[][] ifProvider() {
        return new Object[][]{{2, 3, 4, 3}, {-1, 0, 4, 0}, {-3, -3, 5, -3}};
    }

    //////////////////////////////////////////////////
    // Дано три цілих числа: A, B, C. Перевірити істинність висловлювання: Хоча б одне з чисел A, B, C позитивне;

    @Test(dataProvider = "booleanProvider")
    public void booleanTest(int p1, int p2, int p3, boolean p4) {
        assertEquals(new Variant1().booleanTask(new int[]{p1, p2, p3}), p4);
    }

    @DataProvider
    public Object[][] booleanProvider() {
        return new Object[][]{{5, -1, -5, true}, {-1, -4, -5, false}, {3, 1, 4, true}};
    }

    //////////////////////////////////////////////////
//Елементи рівнобедреного прямокутного трикутника пронумеровані в такий спосіб:
// 1 — катет a,
// 2 — гіпотенуза c = a·2^1/2,
// 3 — висота h, опущена на гіпотенузу (h = c/2),
// 4 — площа S = c·h/2.
// Даний номер одного з цих елементів і його значення.
// Вивести значення решти елементів даного трикутника (в тому ж порядку).

    @Test(dataProvider = "switchProvider")
    public void switchTest(int p1, double p2, double[] expected) {
        assertEquals(new Variant1().switchTask(p1, p2), expected);
    }

    @DataProvider
    public Object[][] switchProvider() {
        return new Object[][]{
                {1, 2, new double[]{2.0, 2.0 * Math.sqrt(2), 2 * Math.sqrt(2) / 2, (2 * Math.sqrt(2)) * (2 * Math.sqrt(2) / 2) / 2}},
                {2, 2, new double[]{2.0 / Math.sqrt(2), 2, 2.0 / 2, 2 * (2.0 / 2) / 2}},
                {3, 2, new double[]{(2.0 * 2) / Math.sqrt(2), 2.0 * 2, 2, ((2.0 * 2) * 2) / 2}},
                {4, 2, new double[]{(2.0 * 2) / Math.sqrt(2), 2 * 2, Math.sqrt(2 * 2), 2}}
        };
    }

    ///////////////////////////////////////////////////
//Дано ціле число N (> 0). Знайти значення виражень
//
//1.1 – 1.2 + 1.3 – …
    @Test(dataProvider = "forProvider")
    public void forTest(int n, double p2) {
        assertEquals(new Variant1().forTask(n), p2);
    }

    @DataProvider
    public Object[][] forProvider() {
        return new Object[][]{{3, 1.2}, {7, 1.4}, {12, -0.6}};
    }

    ///////////////////////////////////////////////////

    //////////////////////////////////////////
//  Дано число A (>1). Вивести найменше з цілих чисел K, для яких сума 1 + 1/2 + … + 1/K буде більше A, і саму цю суму.

    @Test(dataProvider = "whileProvider")
    public void whileTest(double a, double[] expected) {
        assertEquals(new Variant1().whileTask(a), expected);
    }

    @DataProvider
    public Object[][] whileProvider() {
        return new Object[][]{
                {2.5, new double[]{7, 2.5928571428571425}},
                {3.5, new double[]{19, 3.547739657143682}},
                {4.0, new double[]{31, 4.02724519543652}},
                {5.0, new double[]{83, 5.002068272680166}},
                {6.0, new double[]{227, 6.004366708345567}}
        };
    }

    @Test(expectedExceptions = AssertionError.class, dataProvider = "negativeWhileProvider")
    public void negativeWhileTest(int a) {
        new Variant1().whileTask(a);
    }

    @DataProvider
    public Object[][] negativeWhileProvider() {
        return new Object[][]{{-2}};
    }

    //////////////////////////////////////////
//    Дано масив A розміру  N ( N  — непарне число).
//    Вивести його елементи з непарними номерами в порядку зменшення номерів:
//    A N , A <i>N –2, A N –4, A 1. Умовний оператор не використовує.
    @Test(dataProvider = "arrayProvider")
    public void arrayTest(double[] array, double[] expected) {
        assertEquals(new Variant1().arrayTask(array), expected);
    }

    @DataProvider
    public Object[][] arrayProvider() {
        return new Object[][]{
                {new double[]{10, 2, 3, 4, 6, 5}, new double[]{6, 3, 10}},
                {new double[]{10, 2, 13}, new double[]{13, 10}},
                {new double[]{4, 3, 5, -4, 9, 2}, new double[]{9, 5, 4}}
                };
    }


    //////////////////////////////////////////
//  Дано квадратну матрицю A порядку M M. Починаючи з елемента 1,1,
//  вивести її елементами наступним чином (куточками): все;
//  елементи першого рядка; елементи останнього стовпця,
//  крім першого (вже виведеного) елемента; елементи другого рядка, що залишилися;
//  елементи, що залишилися передостаннього стовпця і т. д.;
//  останнім виводиться елемент A[M,]>.
    @Test(dataProvider = "matrixProvider")
    public void twoDimensionArrayTest(int[][] input, int[][] output) {
        assertEquals(new Variant1().twoDimensionArrayTask(input), output);
    }

    @DataProvider
    public Object[][] matrixProvider() {
        int[][] input1 = {
                {2, 3, 6, 9},
                {34, 98, -9, 2},
                {-4, 2, 1, 6},
                {-98, 8, 1, 5}
        };

        int[][] expected1 = {
                {2, 3, 6, 9, 2, 6, 5},
                {34, 98, -9, 1, 1},
                {-4, 2, 8},
                {-98}
        };
        return new Object[][]{{input1, expected1}};

    }
}