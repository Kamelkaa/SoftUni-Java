package rpg_lab;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class DummyTest {
    private static final int DUMMY_HEALTH = 10;
    private static final int DUMMY_EXPERIENCE = 10;
    private static final int ATTACK_POINTS = 1;

    private Dummy dummy;
    private Dummy deadDummy;

    @Before
    public void setUp() {
        dummy = new Dummy(DUMMY_HEALTH, DUMMY_EXPERIENCE);
        deadDummy = new Dummy(0, DUMMY_EXPERIENCE);
    }

    //⦁	Dummy loses health if attacked
    @Test
    public void testDummyLosesHealthWhenAttacked() {
        dummy.takeAttack(ATTACK_POINTS);
        Assert.assertEquals(DUMMY_HEALTH - ATTACK_POINTS, dummy.getHealth());
    }

    //⦁	Dead Dummy throws exception if attacked
    @Test(expected = IllegalStateException.class)
    public void testDeadDummyCannotBeAttacked() {
        deadDummy.takeAttack(ATTACK_POINTS);
    }

    //⦁	Dead Dummy can give XP
    @Test
    public void testDeadDummyGivesExperience() {
        Assert.assertEquals(DUMMY_EXPERIENCE, deadDummy.giveExperience());
    }

    //⦁	Alive Dummy can't give XP
    @Test(expected = IllegalStateException.class)
    public void testAliveDummyCannotGivesExperience() {
        dummy.giveExperience();
    }
}
