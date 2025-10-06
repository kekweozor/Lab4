package example;

import org.example.AddressBook;
import org.example.BuddyInfo;
import org.junit.Test;

import static org.junit.Assert.*;

public class AddressBookTest {

    private AddressBook addressBook = new AddressBook();
    private BuddyInfo buddy1 = new BuddyInfo("Michael", "522 Reacher Avenue", "2299223300") ;
    ;
    private BuddyInfo buddy2 = new BuddyInfo("Esther", "12 Collusion Street", "1313131313") ;
    ;

        @Test
    public void addBuddy() {
        addressBook.addBuddy(buddy1);
        assertEquals(1,addressBook.getAddressList().size());
        assertTrue(addressBook.getAddressList().contains(buddy1));
    }

    @Test
    public void removeBuddy() {
        addressBook.addBuddy(buddy1);
        addressBook.addBuddy(buddy2);
        addressBook.removeBuddy(buddy1);

        assertEquals(1, addressBook.getAddressList().size());
        assertFalse(addressBook.getAddressList().contains(buddy1));
        assertTrue(addressBook.getAddressList().contains(buddy2));
    }

    @Test
    public void getAddressList() {
        addressBook.addBuddy(buddy1);
        addressBook.addBuddy(buddy2);

        var list = addressBook.getAddressList();
        assertEquals(2, list.size());
        assertEquals("Michael", list.get(0).getName());
        assertEquals("Esther", list.get(1).getName());
    }
}