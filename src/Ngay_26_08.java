import java.util.Random;
import java.util.Scanner;

import static java.lang.Math.sqrt;

public class Ngay_26_08 {
    private static long findMaxNumber(long[] arr) {
        long max = arr[0];
        for (int i = 0; i < arr.length; i++) {
            if (max < arr[i]) {
                max = arr[i];
            }
        }
        return max;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.printf("Nhập số lượng số ngẫu nhiên: ");
        int totalNumber = scanner.nextInt();

        long arr[] = new long[totalNumber];
        long min = arr[0];
        int sumOfPrimes = 0;
        for (int i = 0; i < totalNumber; i++) {
            double randomDouble = Math.random() * 20;
            int randomInt = (int) randomDouble;
            arr[i] = randomInt;
            System.out.printf("Số ngẫu nhiên thứ %d là: %d \n", i + 1, randomInt);

            if (min > arr[i]) {
                min = arr[i];
            }

            if (randomInt > 2) {
                for (int x = 1; x <= sqrt(randomInt); x++) {
                    if (randomInt % x != 0) {
                        sumOfPrimes += randomInt;
                    }
                }
            }
        }
        System.out.printf("Số nhỏ nhất là: %d \n", min);
        System.out.printf("Số lớn nhất là: %d \n", findMaxNumber(arr));
        if (sumOfPrimes != 0) {
            System.out.printf("Tổng các số nguyên tố là: %d \n", sumOfPrimes);
        } else System.out.println("Dãy trên không có số nguyên tố nào!");
    }
}
