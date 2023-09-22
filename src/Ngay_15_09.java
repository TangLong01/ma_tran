public class Ngay_15_09 {
    static class AddBook {
        String title, author;
        int year;

        AddBook(String title, String author, int year) {
            this.title = title;
            this.author = author;
            if (isPublishBefore(year)) {
                this.year = year;
            } else this.year = -1;
        }

        void printInfo() {
            System.out.printf("Tiêu đề sách: %s\n", this.title);
            System.out.printf("Tác giả: %s\n", this.author);
            System.out.printf("Năm xuất bản: %s\n", this.year);
            System.out.println("------------------------");
        }

        boolean isPublishBefore(int year) {
            if (year <= 2023) {
                return true;
            }
            return false;
        }
    }

    public static void main(String[] args) {
        AddBook book1 = new Ngay_15_09.AddBook("Book 1", "Author 1", 2024);
        AddBook book2 = new Ngay_15_09.AddBook("Book 2", "Author 2", 2023);
        AddBook book3 = new Ngay_15_09.AddBook("Book 3", "Author 3", 2022);

        book1.printInfo();
        book2.printInfo();
        book3.printInfo();
    }
}
