import static java.lang.Math.round;

public class Main {
    public static void main(String[] args) {
        float a = 9.4f;
        float h = 13.4f;

        if (a > 0 && h > 0) {
            float S = a / 2 * h;
            System.out.println("Diện tích tam giác là: " + round(S));
        } else System.out.println("Lỗi, không thể tính được");
    }
}