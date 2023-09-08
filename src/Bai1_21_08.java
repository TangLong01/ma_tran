import java.util.Scanner;

public class Bai1_21_08 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.printf("Bạn muốn nhập bao nhiêu số nguyên: ");
        int totalNum = scanner.nextInt();
        int arr[] = new int[totalNum];

        System.out.printf("Nhập %d số nguyên tố: ", totalNum);
        for (int i = 0; i < totalNum; i++) {
            arr[i] = scanner.nextInt();
        }

        System.out.printf("Các số lẻ đã nhập: ");
        for (int i = 0; i < totalNum; i++) {
            if (arr[i] % 2 != 0) {
                System.out.printf(arr[i] + " ");
            }
        }
    }
}
