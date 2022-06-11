package heroRepository;

import org.junit.Assert;
import org.junit.Test;

public class HeroRepositoryTests {
    @Test
    public void testGetCountShouldReturnOne() {
        HeroRepository heroesTest = new HeroRepository();
        Hero hero = new Hero("test_hero", 10);

        heroesTest.create(hero);
        Assert.assertEquals(1, heroesTest.getCount());
    }

    @Test
    public void testGetCountShouldReturnZero() {
        HeroRepository heroesTest = new HeroRepository();

        Assert.assertEquals(0, heroesTest.getCount());
    }

    @Test(expected = NullPointerException.class)
    public void testCreateShouldThrowWhenHeroIsNull() {
        HeroRepository heroesTest = new HeroRepository();

        heroesTest.create(null);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testCreateShouldThrowWhenHeroExist() {
        HeroRepository heroesTest = new HeroRepository();
        Hero hero = new Hero("test_hero", 10);

        heroesTest.create(hero);
        heroesTest.create(hero);
    }

    @Test(expected = NullPointerException.class)
    public void testRemoveShouldThrowWhenHeroNameIsNull() {
        HeroRepository heroesTest = new HeroRepository();

        heroesTest.remove(null);
    }

    @Test(expected = NullPointerException.class)
    public void testRemoveShouldThrowWhenHeroNameIsEmpty() {
        HeroRepository heroesTest = new HeroRepository();

        heroesTest.remove("  ");
    }

    @Test
    public void testRemoveShouldReturnTrueWhenHeroIsRemoved() {
        HeroRepository heroesTest = new HeroRepository();
        Hero hero = new Hero("test_hero", 10);

        heroesTest.create(hero);
        Assert.assertTrue(heroesTest.remove("test_hero"));
    }

    @Test
    public void testRemoveShouldReturnFalseWhenNoHero() {
        HeroRepository heroesTest = new HeroRepository();

        Assert.assertFalse(heroesTest.remove("test_hero"));
    }

    @Test
    public void testGetHeroWithHighestLevelShouldWork() {
        HeroRepository heroesTest = new HeroRepository();
        heroesTest.create(new Hero("test_hero", 8));
        heroesTest.create(new Hero("test_hero1", 10));
        heroesTest.create(new Hero("test_hero2", 3));

        Assert.assertEquals(10, heroesTest.getHeroWithHighestLevel().getLevel());
    }

    @Test
    public void testGetHeroShouldWork() {
        HeroRepository heroesTest = new HeroRepository();
        heroesTest.create(new Hero("test_hero", 8));
        heroesTest.create(new Hero("test_hero1", 10));
        heroesTest.create(new Hero("test_hero2", 3));

        Assert.assertEquals("test_hero", heroesTest.getHero("test_hero").getName());
    }

    @Test(expected = UnsupportedOperationException.class)
    public void testGetHeroes() {
        HeroRepository heroesTest = new HeroRepository();
        heroesTest.getHeroes().remove(0);
    }
}