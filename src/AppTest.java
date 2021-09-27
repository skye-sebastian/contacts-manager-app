import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

import static java.nio.file.Files.readAllLines;

public class AppTest {

    public static void main(String[] args) {

        ContactList contactList = new ContactList();
        Contact newContact = new Contact("test2", "0987654321");

//        contactList.viewContacts();
//        System.out.println("Adding new contact");
//        contactList.addContact("Test", "1234567890");
//        contactList.viewContacts();
//
//        System.out.println("Adding new contact");
//        contactList.addContact(newContact);
//        contactList.viewContacts();

        System.out.println("Searching contacts");
        contactList.searchContacts("Test");





    }

}
