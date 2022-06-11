package halfLife;

import org.junit.Assert;
import org.junit.Test;

import java.util.List;

public class PlayerTests {
    @Test(expected = NullPointerException.class)
    public void testUserNameShouldFailWhenIsNull() {
        new Player(null, 100);
    }

    @Test(expected = NullPointerException.class)
    public void testUserNameShouldFailWhenIsEmpty() {
        new Player("   ", 100);
    }

    @Test
    public void testUserNameShouldWork() {
        Player player = new Player("test", 100);
        Assert.assertEquals("test", player.getUsername());
    }

    @Test(expected = IllegalArgumentException.class)
    public void testHealthIsBelowZero() {
        new Player("test", -1);
    }

    @Test
    public void testHealthShouldWork() {
        Player player = new Player("test", 100);
        Assert.assertEquals(100, player.getHealth());
    }

    @Test
    public void testAddGunShouldWork() {
        Player player = new Player("test", 100);
        Gun gun = new Gun("Pistol", 10);

        player.addGun(gun);

        List<Gun> expectedGuns = List.of(gun);
        Assert.assertEquals(expectedGuns, player.getGuns());
    }

    @Test(expected = NullPointerException.class)
    public void testAddGunShouldFail() {
        Player player = new Player("test", 100);
        player.addGun(null);
    }

    @Test
    public void testTakeDamageShouldWork() {
        Player player = new Player("test", 100);
        player.takeDamage(10);
        Assert.assertEquals(90, player.getHealth());
    }

    @Test
    public void testTakeDamageShouldWorkAndHealthMustBeZero() {
        Player player = new Player("test", 9);
        player.takeDamage(10);
        Assert.assertEquals(0, player.getHealth());
    }

    @Test(expected = IllegalStateException.class)
    public void testTakeDamageShouldFail() {
        Player player = new Player("test", 0);
        player.takeDamage(10);
    }

    @Test
    public void testRemoveGunShouldWork() {
        Player player = new Player("test", 100);
        Gun gun = new Gun("Pistol", 10);

        player.addGun(gun);

        Assert.assertTrue(player.removeGun(gun));
    }

    @Test
    public void testGetGunShouldWork() {
        Player player = new Player("test", 100);
        Gun gun = new Gun("Pistol", 10);

        player.addGun(gun);

        Assert.assertEquals(gun, player.getGun("Pistol"));
    }

    @Test
    public void testGetGunShouldReturnNull() {
        Player player = new Player("test", 100);
        Gun gun = new Gun("Pistol", 10);

        player.addGun(gun);

        Assert.assertNull(player.getGun("AWP"));
    }
}
