import java.util.Scanner;

public class MaTran {
//    private static void nhapPhanTu(int arr) {
//        int min = arr[0][0];
//        System.out.println(arr.length);
//    }

    private static void phanTuNhoNhat(int[][] arr) {
        int min = arr[0][0];
        System.out.println(arr.length);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.printf("Nhập số hàng: ");
        int soHang = scanner.nextInt();
        System.out.printf("Nhập số cột: ");
        int soCot = scanner.nextInt();
        int arr[][] = new int[soHang][soCot];

        for (int i = 0; i < soHang; i++) {
            for (int j = 0; j < soCot; j++) {
                System.out.printf("Nhập số ở hàng %d cột %d: ", i + 1, j + 1);
                arr[i][j] = scanner.nextInt();
            }
        }

        System.out.println("\nMa trận: ");
        for (int i = 0; i < soHang; i++) {
            for (int j = 0; j < soCot; j++) {
                System.out.print(arr[i][j] + "\t");
            }
            System.out.println();
        }

        phanTuNhoNhat(arr);
    }
}
