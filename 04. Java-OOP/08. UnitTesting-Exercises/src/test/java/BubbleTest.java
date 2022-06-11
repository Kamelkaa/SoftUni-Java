import org.junit.Assert;
import org.junit.Test;
import p04_BubbleSortTest.Bubble;

public class BubbleTest {
    @Test
    public void testSort() {
        int[] numbers = {3, 28, 15, 10, 25};
        Bubble.sort(numbers);
        int[] expectedSortedArray = {3, 10, 15, 25, 28};

        Assert.assertEquals(expectedSortedArray.length, numbers.length);
        Assert.assertArrayEquals(expectedSortedArray, numbers);
    }
}