package bankSafe;


import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import javax.naming.OperationNotSupportedException;

public class BankVaultTest {
    BankVault bankVault;

    @Before
    public void setUp() {
        this.bankVault = new BankVault();
    }

    @Test(expected = UnsupportedOperationException.class)
    public void testGetVaultCellsShouldFail() {
        bankVault.getVaultCells().put("K1", null);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testAddItemNotContainsGivenKeyAndShouldFail() throws OperationNotSupportedException {
        Item item = new Item("Test", "1");

        bankVault.addItem("test_1", item);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testAddItemWhenCellIsTakenShouldFail() throws OperationNotSupportedException {
        Item item = new Item("Test", "1");
        Item item1 = new Item("Test1", "2");

        bankVault.addItem("A1", item);
        bankVault.addItem("A1", item1);
    }

    @Test(expected = OperationNotSupportedException.class)
    public void testAddItemWhenSameItemIsAddedShouldFail() throws OperationNotSupportedException {
        Item item = new Item("Test", "1");

        bankVault.addItem("A1", item);
        bankVault.addItem("A2", item);
    }

    @Test
    public void testAddItemShouldWork() throws OperationNotSupportedException {
        Item item = new Item("Test", "1");

        String expected = String.format("Item:%s saved successfully!", item.getItemId());
        String actual = bankVault.addItem("A1", item);

        Assert.assertEquals(expected, actual);
        Assert.assertNotNull(bankVault.getVaultCells().get("A1"));
    }

    @Test(expected = IllegalArgumentException.class)
    public void testRemoveItemShouldFailWhenKeyIsNotExist() {
        Item item = new Item("Test", "1");

        bankVault.removeItem("test", item);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testRemoveItemShouldFailWhenItemDoseNotExist() {
        Item item = new Item("Test", "1");

        bankVault.removeItem("A1", item);
    }

    @Test
    public void testRemoveItemShouldWork() throws OperationNotSupportedException {
        Item item = new Item("Test", "1");
        bankVault.addItem("A1", item);

        String actual = bankVault.removeItem("A1", item);
        String expected = String.format("Remove item:%s successfully!", item.getItemId());

        Assert.assertEquals(expected, actual);
        Assert.assertNull(bankVault.getVaultCells().get("A1"));
    }
}