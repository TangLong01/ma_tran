import java.util.Date;

/**
 * Lec09Prac
 */
public class Lec09Prac {
    static public class Book {
        /* Lớp Sách chứa thông tin cơ bản về sách như mã sách, tên sách, tác giả, năm xuất bản, và số lượng hiện có.
        Hãy sử dụng tính chất đóng gói để bảo vệ dữ liệu và cung cấp các phương thức để truy xuất và cập nhật thông tin sách. */
        String id, name, author;
        Integer publishYear, amount;

        Book(String id, String name, String author, Integer publishYear, Integer amount) {
            this.id = id;
            this.name = name;
            this.author = author;
            this.publishYear = publishYear;
            this.amount = amount;
        }

        void print() {
            System.out.printf("%s %s %s %s %s\n", this.id, this.name, this.author, this.publishYear, this.amount);
        }
    }

    static public class Person {
        /* Lớp Người Đọc chứa thông tin về mã đọc giả, tên đọc giả, tuổi, ngày tham gia thư viện. */
        /* Lớp Nhân Viên chứa thông tin về mã nhân viên, tên nhân viên, tuổi, chức vụ, ngày tham gia thư viện. */

        String id, name;
        Integer age;
        Date joinedDate;

        Person(String id, String name, Integer age, Date joinedDate) {
            this.id = id;
            this.name = name;
            this.age = age;
            this.joinedDate = joinedDate;
        }

    }

    static public class Reader extends Person {
        /* Lớp Người Đọc chứa thông tin về mã đọc giả, tên đọc giả, tuổi, ngày tham gia thư viện. */
        Reader(String id, String name, Integer age, Date joinedDate) {
            super(id, name, age, joinedDate);
        }

        void print() {
            System.out.printf("%s %s %s %s\n", this.id, this.name, this.age, this.joinedDate);
        }
    }

    static enum Role {
        MANAGER,
        LIBARIAN
    }

    static public class Staff extends Person {
        /* Lớp Nhân Viên chứa thông tin về mã nhân viên, tên nhân viên, tuổi, chức vụ, ngày tham gia thư viện. */
        Role role;

        Staff(String id, String name, Role role, Integer age, Date joinedDate) {
            super(id, name, age, joinedDate);
            this.role = role;
        }
    }

    static enum BBCState {
        WAITTING,
        BORROWING,
        RETURNED
    }

    static class BookBorrowCard {
        Reader borrower;
        Staff staff;
        Book book;
        Date borrowedDate, returnedDate;
        BBCState state;
        Integer count;

        BookBorrowCard(Reader borrower, Staff staff, Book book, BBCState state, Date borrowedDate, Date returnedDate, Integer count) {
            this.borrower = borrower;
            this.staff = staff;
            this.book = book;
            this.state = state;
            this.borrowedDate = borrowedDate;
            this.returnedDate = returnedDate;
            this.count = count;
        }

    }

    static class BookManager {
        static Book[] books;
        static BookBorrowCard[] cards;

        static int findBookById(String id) {
            for (int i = 0; i < BookManager.books.length; i++) {
                if (id == BookManager.books[i].id) {
                    return i;
                }
            }
            return -1;
        }

        static int[] findCardByBookId(String bid) {
            int[] result = new int[BookManager.cards.length];
            int resultCount = 0;
            for (int i = 0; i < BookManager.cards.length; i++) {
                if (bid == BookManager.cards[i].book.id) {
                    result[resultCount] = i;
                    resultCount++;
                }
            }
            return result;
        }

        static int noOfAvailableBook(String id) {
            int bookIdx = BookManager.findBookById(id);
            if (bookIdx == -1) return 0;
            int cardsIdx[] = BookManager.findCardByBookId(id);

            int total = BookManager.books[bookIdx].amount;
            for (int i = 0; i < cardsIdx.length; i++) {
                if (BookManager.cards[cardsIdx[i]].state == BBCState.BORROWING) {
                    total -= BookManager.cards[cardsIdx[i]].count;
                }
            }
            return total;
        }

        static BookBorrowCard[] findCardByBorrower(String borrowerId) {
            BookBorrowCard[] result = new BookBorrowCard[BookManager.cards.length];
            int resultCount = 0;
            for (int i = 0; i < BookManager.cards.length; i++) {
                if (borrowerId == BookManager.cards[i].borrower.id) {
                    // ++var // var++
                    result[resultCount++] = BookManager.cards[i];
                }
            }
            return result;
        }

        static BookBorrowCard findOldestWaittingCard(String bid) {
            int[] cardIdx = BookManager.findCardByBookId(bid);
            if (!(cardIdx.length > 0)) {
                return null;
            }
            BookBorrowCard card = BookManager.cards[cardIdx[0]];
            for (int i = 1; i < cardIdx.length; i++) {
                if (card.borrowedDate.after(BookManager.cards[cardIdx[i]].borrowedDate)) {
                    card = BookManager.cards[cardIdx[i]];
                }
            }
            return card;
        }
    }

    public static void main(String[] args) {
        // Tạo sách
        Book[] books = {
                new Book("1", "Book 1", "Any", 1990, 3),
                new Book("2", "Book 2", "Bny", 1992, 10),
                new Book("3", "Book 3", "Cny", 1997, 1)
        };
        BookManager.books = books;

        Staff maria = new Staff("S001", "Maria", Role.LIBARIAN, 25, new Date(1663855399));

        Reader john = new Reader("R001", "John", 27, new Date());
        Reader dave = new Reader("R002", "Dave", 30, new Date());

        BookBorrowCard[] cards = {
                new BookBorrowCard(dave, maria, BookManager.books[BookManager.findBookById("2")], BBCState.BORROWING, new Date(), null, 5)
        };
        BookManager.cards = cards;

        //System.out.println(BookManager.noOfAvailableBook("2"));

        // BookBorrowCard[] bbcCards = BookManager.findCardByBorrower("R002");
        // dave.print();
        // for (int i=0;i<bbcCards.length; i++){
        //     bbcCards[i].book.print();
        // }

        BookManager.findOldestWaittingCard("2").borrower.print();

    }
}