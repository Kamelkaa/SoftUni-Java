package shopAndGoods;


import org.junit.Assert;
import org.junit.Test;

import javax.naming.OperationNotSupportedException;

public class ShopTest {
    @Test(expected = UnsupportedOperationException.class)
    public void testGetShelves() {
        Shop test = new Shop();
        test.getShelves().remove("Shelves13");
    }

    @Test(expected = IllegalArgumentException.class)
    public void testAddGoodsShouldFailWhenShelveNoExist() throws OperationNotSupportedException {
        Shop test = new Shop();

        Goods goods = new Goods("test_name", "test_code");
        test.addGoods("Shelves13", goods);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testAddGoodsShouldFailWhenShelveIsTaken() throws OperationNotSupportedException {
        Shop test = new Shop();

        Goods goods = new Goods("test_name", "test_code");
        Goods goods1 = new Goods("test_name1", "test_code1");

        test.addGoods("Shelves1", goods);
        test.addGoods("Shelves1", goods1);
    }

    @Test(expected = OperationNotSupportedException.class)
    public void testAddGoodsShouldFailWhenGoodIsInShelve() throws OperationNotSupportedException {
        Shop test = new Shop();

        Goods goods = new Goods("test_name", "test_code");

        test.addGoods("Shelves1", goods);
        test.addGoods("Shelves2", goods);

        Assert.assertTrue(test.getShelves().containsValue(goods));
    }

    @Test
    public void testAddGoodsShouldWork() throws OperationNotSupportedException {
        Shop test = new Shop();

        Goods goods = new Goods("test_name", "test_code");

        String expected = "Goods: test_code is placed successfully!";

        Assert.assertEquals(expected, test.addGoods("Shelves1", goods));
    }

    @Test(expected = IllegalArgumentException.class)
    public void testRemoveGoodsShouldFailWhenShelveNotExist() {
        Shop test = new Shop();

        Goods goods = new Goods("test_name", "test_code");
        test.removeGoods("Shelves13", goods);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testRemoveGoodsShouldFailWhenGoodsNotExist() throws OperationNotSupportedException {
        Shop test = new Shop();

        Goods goods = new Goods("test_name", "test_code");
        Goods goods1 = new Goods("test_name1", "test_code1");
        test.addGoods("Shelves1", goods);

        test.removeGoods("Shelves1", goods1);
    }

    @Test
    public void testRemoveGoodsShouldWork() throws OperationNotSupportedException {
        Shop test = new Shop();

        Goods goods = new Goods("test_name", "test_code");
        test.addGoods("Shelves1", goods);

        String expected = "Goods: test_code is removed successfully!";

        Assert.assertEquals(expected, test.removeGoods("Shelves1", goods));
        Assert.assertNull(test.getShelves().get("Shelves1"));
    }
}