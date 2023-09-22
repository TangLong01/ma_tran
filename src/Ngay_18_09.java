import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Ngay_18_09 {
    static class Contact {
        String name, email, phoneNumber;

        Contact(String name, String email, String phoneNumber) {
            this.name = name;
            this.email = email;
            this.phoneNumber = phoneNumber;
        }
    }

    static class AddressBook {
        List<Contact> contactList = new ArrayList<>();

        void addContact(Contact contact) {
            contactList.add(contact);
        }
    }

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        AddressBook addressBook = new AddressBook();
        Contact ct1 = new Contact("Long", "long@gmail.com", "0123456789");
        addressBook.addContact(ct1);
        Contact ct2 = new Contact("Trung", "trung@gmail.com", "123142342");
        addressBook.addContact(ct2);


        System.out.println("1.Thêm liên hệ");
        System.out.println("2.Xoá liên hệ");
        System.out.println("3.Tìm liên hệ");
        System.out.println("4.Hiển thị tất cả liên hệ");
        System.out.println("---------------------------");
        System.out.printf("Nhập lựa chọn: ");
        int choose = scn.nextInt();

        if (choose == 1) {
            System.out.printf("Nhập tên: ");
            String name = scn.nextLine();
            System.out.printf("Nhập email: ");
            String email = scn.nextLine();
            System.out.printf("Nhập số điện thoại: ");
            String phoneNumber = scn.nextLine();

            System.out.println(addressBook.contactList.get(0).name);
        }


//        System.out.println(addressBook.contactList.get(0).name);
//        System.out.println(addressBook.contactList.get(1).name);
    }
}
