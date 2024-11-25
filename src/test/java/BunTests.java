import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import praktikum.Bun;

public class BunTests {

    Bun bun;

    @Before
    public void setUp() {
        bun = new Bun("Рженая", 50f);

    }

    @Test
    public void setNameTest() {

        String expectedName = bun.getName();

        Assert.assertEquals(expectedName,bun.getName());
    }

    @Test
    public void setPriceTest() {

        float expectedPrice = bun.getPrice();

        Assert.assertEquals(expectedPrice, bun.getPrice(), 0.0f);
    }
}
