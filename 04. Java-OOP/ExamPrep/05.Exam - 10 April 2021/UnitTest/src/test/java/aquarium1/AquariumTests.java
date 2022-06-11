package aquarium;

import org.junit.Assert;
import org.junit.Test;

public class AquariumTests {
    @Test(expected = NullPointerException.class)
    public void testSetNameShouldThrowWhenNameIsNull() {
        new Aquarium(null, 10);
    }

    @Test(expected = NullPointerException.class)
    public void testSetNameShouldThrowWhenNameIsEmpty() {
        new Aquarium("   ", 10);
    }

    @Test
    public void testSetNameShouldWork() {
        Aquarium aquarium = new Aquarium("test_name", 10);
        Assert.assertEquals("test_name", aquarium.getName());
    }

    @Test
    public void testSetCapacityShouldWork() {
        Aquarium aquarium = new Aquarium("test_name", 10);
        Assert.assertEquals(10, aquarium.getCapacity());
    }

    @Test(expected = IllegalArgumentException.class)
    public void testSetCapacityShouldThrowWhenCapacityIsBelowZero() {
        Aquarium aquarium = new Aquarium("test_name", -1);
    }

    @Test
    public void testGetCountShouldWork() {
        Aquarium aquarium = new Aquarium("test_name", 10);
        aquarium.add(new Fish("test_fish1"));
        aquarium.add(new Fish("test_fish2"));
        aquarium.add(new Fish("test_fish3"));
        Assert.assertEquals(3, aquarium.getCount());
    }

    @Test(expected = IllegalArgumentException.class)
    public void testAddShouldThrowWhenSizeEqualsToCapacity() {
        Aquarium aquarium = new Aquarium("test_name", 2);
        aquarium.add(new Fish("test_fish1"));
        aquarium.add(new Fish("test_fish2"));
        aquarium.add(new Fish("test_fish3"));
    }

    @Test
    public void testAddShouldWork() {
        Aquarium aquarium = new Aquarium("test_name", 10);
        aquarium.add(new Fish("test_fish1"));
        aquarium.add(new Fish("test_fish2"));
        Assert.assertEquals(2, aquarium.getCount());
    }

    @Test(expected = IllegalArgumentException.class)
    public void testRemoveShouldThrowWhenFishIsNull() {
        Aquarium aquarium = new Aquarium("test_name", 10);
        aquarium.remove(null);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testRemoveShouldThrowWhen() {
        Aquarium aquarium = new Aquarium("test_name", 10);
        aquarium.remove("test");
    }

    @Test
    public void testRemoveShouldWork() {
        Aquarium aquarium = new Aquarium("test_name", 10);
        Fish fish1 = new Fish("test_fish1");
        Fish fish2 = new Fish("test_fish2");
        aquarium.add(fish1);
        aquarium.add(fish2);

        aquarium.remove("test_fish2");
        Assert.assertEquals(1, aquarium.getCount());
    }

    @Test(expected = IllegalArgumentException.class)
    public void testSellFishShouldThrowWhenFishIsNull() {
        Aquarium aquarium = new Aquarium("test_name", 10);
        aquarium.sellFish(null);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testSellFishShouldThrow() {
        Aquarium aquarium = new Aquarium("test_name", 10);
        aquarium.sellFish("test");
    }

    @Test
    public void testSellFishShouldWork() {
        Aquarium aquarium = new Aquarium("test_name", 10);
        Fish fish1 = new Fish("test_fish1");
        Fish fish2 = new Fish("test_fish2");
        aquarium.add(fish1);
        aquarium.add(fish2);
        aquarium.sellFish("test_fish2");
        Assert.assertFalse(fish2.isAvailable());
    }

    @Test
    public void testReportShouldWork() {
        Aquarium aquarium = new Aquarium("test_name", 10);
        Fish fish1 = new Fish("test_fish1");
        Fish fish2 = new Fish("test_fish2");
        aquarium.add(fish1);
        aquarium.add(fish2);

        String expected = "Fish available at test_name: test_fish1, test_fish2";
        Assert.assertEquals(expected, aquarium.report());
    }
}

