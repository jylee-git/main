package seedu.address.model.person;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import seedu.address.testutil.Assert;

public class AddressTest {

    @Test
    public void constructor_null_throwsNullPointerException() {
        Assert.assertThrows(NullPointerException.class, () -> new Address(null));
    }

    @Test
    public void constructor_invalidAddress_throwsIllegalArgumentException() {
        String invalidAddress = "";
        Assert.assertThrows(IllegalArgumentException.class, () -> new Address(invalidAddress));
    }

    @Test
    public void isValidAddress() {
        // null address
        Assert.assertThrows(NullPointerException.class, () -> Address.isValidAddress(null));

        // invalid addresses
        assertFalse(Address.isValidAddress("")); // empty string
        assertFalse(Address.isValidAddress(" ")); // spaces only

        // valid addresses
        assertTrue(Address.isValidAddress("Blk 456, Den Road, #01-355"));
        assertTrue(Address.isValidAddress("-")); // one character
        assertTrue(Address.isValidAddress("Leng Inc; 1234 Market St; San Francisco CA 2349879; USA")); // long address
    }

    @Test
    public void hashCode_sameObject_equals() {
        Address address = new Address("Clementi");
        int expectedHash = address.hashCode();
        assertEquals(address.hashCode(), expectedHash);
    }

    @Test
    public void hashCode_differentObject_equals() {
        Address address = new Address("Clementi");
        int expectedHash = address.hashCode();
        Address sameAddress = new Address("Clementi");
        assertEquals(sameAddress.hashCode(), expectedHash);
    }

    @Test
    public void hashCode_differentValues_notEquals() {
        Address address = new Address("Clementi");
        int expectedHash = address.hashCode();
        Address differentAddress = new Address("Bishan");
        assertNotEquals(differentAddress.hashCode(), expectedHash);
    }
}
