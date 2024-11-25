import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import praktikum.Bun;
import praktikum.Database;

import java.util.List;

public class DataBaseTests {

    private Database database;

    @Before
    public void setUp() {
        database = new Database();
    }

    @Test
    public void testAvailableBunsTest() {
        List<Bun> buns = database.availableBuns();

        // Проверка, что список не пустой
        Assert.assertNotNull("List of buns should not be null", buns);
        Assert.assertFalse("List of buns should not be empty", buns.isEmpty());

        // Проверка размеров списка
        Assert.assertEquals("The number of buns should be 3", 3, buns.size());

        // Проверка содержимого списка
        Assert.assertEquals("First bun should be 'black bun'", "black bun", buns.get(0).getName());
        Assert.assertEquals("Second bun should be 'white bun'", "white bun", buns.get(1).getName());
        Assert.assertEquals("Third bun should be 'red bun'", "red bun", buns.get(2).getName());
    }
}
