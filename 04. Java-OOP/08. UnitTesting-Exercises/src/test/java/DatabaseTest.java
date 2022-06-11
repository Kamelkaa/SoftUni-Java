import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import p01_Database.Database;

import javax.naming.OperationNotSupportedException;

public class DatabaseTest {
    private Database database;
    private static final Integer[] NUMBERS = {1, 5, 38, 21, 18};

    @Before
    public void prepareDatabase() throws OperationNotSupportedException {
        database = new Database(NUMBERS);
    }

    @Test
    public void testConstructorHasToCreateValidObject() {
        //взема елементите масива и ги проверява дали са същите в създадения обект
        Integer[] databaseElements = database.getElements();
        //проверка дали броя им е еднакъв
        Assert.assertEquals(databaseElements.length, NUMBERS.length);
        for (int i = 0; i < databaseElements.length; i++) {
            Assert.assertEquals(databaseElements[i], NUMBERS[i]);
        }
    }

    @Test(expected = OperationNotSupportedException.class)
    public void testConstructorThrowWhenUseMoreThenSixteenElements() throws OperationNotSupportedException {
        //създаваме масив с повече от 16 елемента и проверяваме дали ще хвърли грешка
        Integer[] numbers = new Integer[17];
        new Database(numbers);
    }

    @Test(expected = OperationNotSupportedException.class)
    public void testConstructorThrowWhenUseLessThenOneElement() throws OperationNotSupportedException {
        //създаваме масив с 0 елементи и проверяваме дали ще хвърли грешка
        Integer[] numbers = new Integer[17];
        new Database(numbers);
    }

    @Test(expected = OperationNotSupportedException.class)
    public void testAddShouldThrowWhenParameterIsNull() throws OperationNotSupportedException {
        database.add(null);
    }

    @Test
    public void testAddShouldAddElements() throws OperationNotSupportedException {
        database.add(7);
        Assert.assertEquals(database.getElements().length, NUMBERS.length + 1);
        Assert.assertEquals(database.getElements()[database.getElements().length - 1], Integer.valueOf(7));
    }

    @Test(expected = OperationNotSupportedException.class)
    public void testRemoveShouldThrowWithEmptyData() throws OperationNotSupportedException {
        for (int i = 0; i < NUMBERS.length; i++) {
            database.remove();
        }
        database.remove();
    }

    @Test
    public void testRemoveLastElement() throws OperationNotSupportedException {
        database.remove();
        Assert.assertEquals(database.getElements().length, NUMBERS.length - 1);
        Assert.assertEquals(database.getElements()[database.getElements().length - 1], Integer.valueOf(21));
    }
}