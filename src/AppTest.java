public class AppTest {

    private static Object ContactList;

    public static void main(String[] args) {

        ContactList contactList = new ContactList();
        Contact newContact = new Contact("test2", "0987654321");

        contactList.viewContacts();

        System.out.println("Adding new contact w/ string input");
        contactList.addContact("Test", "1234567890");
        contactList.viewContacts();
//
        System.out.println("Adding new contact w/ object");
        contactList.addContact(newContact);
        contactList.viewContacts();
        System.out.println("Searching contacts");

        contactList.searchContacts("test2");

//        contactList.deleteContact("Test");

//        System.out.println(contactList);

    }

}
