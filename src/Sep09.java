import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class Sep09 {
    static class Candidate {
        String id, name, birthday;
        int mathScore, literatureScore, englishScore;

        Candidate(String id, String name, String birthday, int mathScore, int literatureScore, int englishScore) {
            this.id = id;
            this.name = name;
            this.birthday = birthday;
            this.mathScore = mathScore;
            this.literatureScore = literatureScore;
            this.englishScore = englishScore;
        }

        boolean checkScore() {
            if (mathScore + literatureScore + englishScore > 15) {
                return true;
            }
            return false;
        }

        void printCandidate() {
            System.out.printf("Mã: %s\n", id);
            System.out.printf("Tên: %s\n", name);
            System.out.printf("Ngày sinh: %s\n", birthday);
            System.out.printf("Điểm Toán: %s\n", mathScore);
            System.out.printf("Điểm Văn: %s\n", literatureScore);
            System.out.printf("Điểm Anh: %s\n", englishScore);
        }
    }

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        System.out.printf("Nhập số lượng thí sinh: ");
        int totalCandidate = scn.nextInt();
        scn.nextLine();
        Candidate listCandidate[] = new Candidate[totalCandidate];
        for (int i = 0; i < totalCandidate; i++) {
            System.out.printf("---------- Nhập thông tin thí sinh thứ %s ----------\n", i + 1);
            System.out.printf("Nhập mã: ");
            String id = scn.nextLine();
            System.out.printf("Nhập tên: ");
            String name = scn.nextLine();
            System.out.printf("Nhập ngày tháng năm sinh: ");
            String dateString = scn.nextLine();
            SimpleDateFormat inputFormat = new SimpleDateFormat("dd/MM/yyyy");
            SimpleDateFormat outputFormat = new SimpleDateFormat("dd/MM/yyyy");
            String birthday = "";
            try {
                Date unformattedDate = inputFormat.parse(dateString);
                birthday = outputFormat.format(unformattedDate);
            } catch (ParseException e) {
            }
            System.out.printf("Nhập điểm Toán: ");
            int mathScore = scn.nextInt();
            System.out.printf("Nhập điểm Văn: ");
            int literatureScore = scn.nextInt();
            System.out.printf("Nhập điểm Anh: ");
            int englishScore = scn.nextInt();
            scn.nextLine();

            Candidate newCandidate = new Candidate(id, name, birthday, mathScore, literatureScore, englishScore);
            listCandidate[i] = newCandidate;
        }

        System.out.println("----------------------||||||||----------------------");
        System.out.println("Các thí sinh có tổng điểm lớn hơn 15 là: ");
        for (int i = 0; i < listCandidate.length; i++) {
            if (listCandidate[i].checkScore()) {
                System.out.printf("---------- Thí sinh thứ %s ----------\n", i + 1);
                listCandidate[i].printCandidate();
            }
        }
    }
}
