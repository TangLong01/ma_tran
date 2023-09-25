public class Ngay_22_09 {
    static public class Book {
        String code, title, author;
        int year, count;

        Book(String code, String title, String author, int year, int count) {
            this.code = code;
            this.title = title;
            this.author = author;
            this.year = year;
            this.count = count;
        }
    }

    static public class Reader {
        String code, name, date, bookBorrowing;
        int age;

        Reader(String code, String name, int age, String date) {
            this.code = code;
            this.name = name;
            this.age = age;
            this.date = date;
        }
    }

    static public class BookBorrowingCard {
        static Book[] bookList;
        String codeReader, codeBook, borrowDate, returnDate;
        int count;
        boolean status;

        BookBorrowingCard(String codeReader, String codeBook, String borrowDate, String returnDate, int count, boolean status) {
            this.codeReader = codeReader;
            this.codeBook = codeBook;
            this.borrowDate = borrowDate;
            this.returnDate = returnDate;
            this.count = count;
            this.status = status;
        }

        void notifyBorrow(String readerCode, String bookCode) {
            System.out.printf("Người đọc %s đã mượn %s cuốn sách %s! \n", readerCode, count, bookCode);
            for (int i = 0; i < bookList.length; i++) {
                if (bookList[i].code == bookCode) {
                    bookList[i].count = bookList[i].count - count;
                    return;
                }
            }
        }
    }

    private static int checkCountByCode(String bookCode, Book[] bookList) {
        for (int i = 0; i < bookList.length; i++) {
            if (bookList[i].code == bookCode) {
                return bookList[i].count;
            }
        }
        return 0;
    }

    public static void main(String[] args) {
        Book book1 = new Book("BK01", "Book 1", "Author 1", 1990, 3);
        Book book2 = new Book("BK02", "Book 2", "Author 2", 1995, 1);
        Book book3 = new Book("BK03", "Book 3", "Author 3", 2000, 5);
        Book[] bookList = {book1, book2, book3};
        BookBorrowingCard.bookList = bookList;

        Reader reader1 = new Reader("RD01", "Reader 1", 30, "20/03/2022");
        Reader reader2 = new Reader("RD02", "Reader 2", 26, "14/06/2021");

        // Kiểm tra còn sách không
        System.out.printf("Số sách còn khả dụng của mã sách \"BK03\" là: %s \n", checkCountByCode("BK03", bookList));
        System.out.println("-------------------------------------------");

        BookBorrowingCard card1 = new BookBorrowingCard("RD01", "BK03", "22/05/2022", "26/07/2022", 2, false);
        card1.notifyBorrow("RD01", "BK03");
        System.out.printf("Số sách còn khả dụng của mã sách \"BK03\" là: %s", checkCountByCode("BK03", bookList));
    }
}
