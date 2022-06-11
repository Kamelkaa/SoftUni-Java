package computers;

import org.junit.Assert;
import org.junit.Test;

import java.util.List;

public class ComputerManagerTests {
    @Test(expected = UnsupportedOperationException.class)
    public void testGetComputers() {
        ComputerManager test = new ComputerManager();
        test.getComputers().remove(0);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testValidateNullValueShouldThrowWhenIsNull() {
        ComputerManager test = new ComputerManager();
        test.addComputer(null);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testAddComputerShouldFailWhenAddExistedComputer() {
        Computer computer = new Computer("Test1", "test1", 2.00);
        ComputerManager test = new ComputerManager();
        test.addComputer(computer);
        test.addComputer(computer);
    }

    @Test
    public void testAddComputerShouldWork() {
        Computer computer = new Computer("Test1", "test1", 2.00);
        ComputerManager test = new ComputerManager();
        test.addComputer(computer);
        Assert.assertEquals(1, test.getCount());
    }

    @Test
    public void testRemoveComputerShouldWork() {
        ComputerManager test = new ComputerManager();
        Computer computer = new Computer("Test1", "test1", 2.00);

        test.addComputer(computer);
        Assert.assertEquals(test.removeComputer("Test1", "test1"), computer);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testGetComputerShouldFailWhenManufacturerIsNull() {
        ComputerManager test = new ComputerManager();
        test.getComputer(null, "test1");
    }

    @Test(expected = IllegalArgumentException.class)
    public void testGetComputerShouldFailWhenModelIsNull() {
        ComputerManager test = new ComputerManager();
        test.getComputer("test1", null);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testGetComputerShouldFailWhenComputerIsNull() {
        ComputerManager test = new ComputerManager();
        Computer computer = new Computer("Test1", "test1", 2.00);
        test.getComputer(computer.getManufacturer(), computer.getModel());
    }

    @Test
    public void testGetComputerShouldWork() {
        ComputerManager test = new ComputerManager();
        Computer computer = new Computer("Test1", "test1", 2.00);
        test.addComputer(computer);
        Computer returned = test.getComputer(computer.getManufacturer(), computer.getModel());

        Assert.assertNotNull(returned);
        Assert.assertEquals(computer.getManufacturer(), returned.getManufacturer());
        Assert.assertEquals(computer.getModel(), returned.getModel());
    }

    @Test
    public void testGetComputerByManufacturerWork() {
        ComputerManager test = new ComputerManager();
        Computer computer = new Computer("test1", "Test1", 2.00);
        test.addComputer(computer);
        List<Computer> list = test.getComputersByManufacturer(computer.getManufacturer());
        Assert.assertNotNull(list);
        Assert.assertEquals(list.get(0).getManufacturer(), computer.getManufacturer());
    }

    @Test(expected = IllegalArgumentException.class)
    public void testGetComputerByManufacturerFail() {
        ComputerManager test = new ComputerManager();
        Computer computer = new Computer(null, "Test1", 2.00);

        List<Computer> list = test.getComputersByManufacturer(computer.getManufacturer());
        Assert.assertNotNull(list);
        Assert.assertTrue(list.isEmpty());
    }
}