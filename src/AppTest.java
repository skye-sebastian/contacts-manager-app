import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

import static java.nio.file.Files.readAllLines;

public class AppTest {

    public static void main(String[] args) throws IOException {

    ContactList contactList = new ContactList();

    contactList.readFromContactsList();



    }

}
