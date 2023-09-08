import java.util.Scanner;

public class a {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
//        System.out.printf("Hãy nhập vào thông tin về [tháng]: ");
//        int thang = scanner.nextInt();
//        System.out.printf("Hãy nhập vào thông tin về [năm]: ");
//        int nam = scanner.nextInt();
//
//        switch (thang) {
//            case 1:
//            case 3:
//            case 5:
//            case 7:
//            case 8:
//            case 10:
//            case 12:
//                System.out.printf("Tháng %d năm %d có 31 ngày", thang, nam);
//                break;
//            case 4:
//            case 6:
//            case 9:
//            case 11:
//                System.out.printf("Tháng %d năm %d có 30 ngày", thang, nam);
//                break;
//            case 2:
//                if (nam % 4 == 0 && !(nam % 100 == 0 && nam % 400 != 0)) {
//                    System.out.printf("Tháng %d năm %d là năm nhuận, có 29 ngày", thang, nam);
//                } else System.out.printf("Tháng %d năm %d có 28 ngày", thang, nam);
//                break;
//        }


        int arr[][] = new int[3][3];
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                arr[i][j] = scanner.nextInt();
            }
        }
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                System.out.printf("Phan tu thu (%d, %d) la: %d \n", i, j, arr[i][j]);
            }
        }
    }
}