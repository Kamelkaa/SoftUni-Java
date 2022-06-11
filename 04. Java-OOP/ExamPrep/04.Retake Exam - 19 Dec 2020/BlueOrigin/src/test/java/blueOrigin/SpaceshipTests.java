package blueOrigin;

import org.junit.Assert;
import org.junit.Test;

public class SpaceshipTests {
    @Test(expected = NullPointerException.class)
    public void testSetNameShouldThrowWhenIsNull() {
        new Spaceship(null, 10);
    }

    @Test(expected = NullPointerException.class)
    public void testSetNameShouldThrowWhenIsEmpty() {
        new Spaceship("   ", 10);
    }

    @Test
    public void testSetNameShouldWork() {
        Spaceship spaceship = new Spaceship("test_name", 10);
        Assert.assertEquals("test_name", spaceship.getName());
    }

    @Test(expected = IllegalArgumentException.class)
    public void testSetCapacityShouldThrowWhenIsLessThenZero() {
        new Spaceship("test", -1);
    }

    @Test
    public void testSetCapacityShouldWork() {
        Spaceship spaceship = new Spaceship("test", 1);
        Assert.assertEquals(1, spaceship.getCapacity());
    }

    @Test
    public void testGetAstronautCountShouldReturnOne() {
        Spaceship spaceship = new Spaceship("test", 10);

        spaceship.add(new Astronaut("test_astronaut", 1.0));
        Assert.assertEquals(1, spaceship.getCount());
    }

    @Test
    public void testGetAstronautShouldReturnZeroWhenEmpty() {
        Spaceship spaceship = new Spaceship("test", 10);

        Assert.assertEquals(0, spaceship.getCount());
    }

    @Test(expected = IllegalArgumentException.class)
    public void testAddShouldThrowWhenCapacityIsEqualToSize() {
        Spaceship spaceship = new Spaceship("test", 1);

        spaceship.add(new Astronaut("test_astronaut", 1.0));
        spaceship.add(new Astronaut("test_astronaut1", 1.0));
    }

    @Test(expected = IllegalArgumentException.class)
    public void testAddShouldThrowWhenAstronautExist() {
        Spaceship spaceship = new Spaceship("test", 10);

        spaceship.add(new Astronaut("test_astronaut", 1.0));
        spaceship.add(new Astronaut("test_astronaut", 1.0));
    }

    @Test
    public void testRemoveShouldReturnTrueWhenAstronautIsRemoved() {
        Spaceship spaceship = new Spaceship("test", 1);

        spaceship.add(new Astronaut("test_astronaut", 1.0));

        Assert.assertTrue(spaceship.remove("test_astronaut"));
    }

    @Test
    public void testRemoveShouldReturnFalseWhenNoAdded() {
        Spaceship spaceship = new Spaceship("test", 1);

        Assert.assertFalse(spaceship.remove("test_astronaut1"));
    }
}