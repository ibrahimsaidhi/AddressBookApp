package org.example;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) {
        AddressBook book1 = new AddressBook();

        BuddyInfo info1 = new BuddyInfo("Ibrahim", "343-297-1675");
        BuddyInfo info2 = new BuddyInfo("Bob", "613-223-1109");

        book1.addBuddyInfo(info1);
        book1.addBuddyInfo(info2);
        book1.display();

    }
}