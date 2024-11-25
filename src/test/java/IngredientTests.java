import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import praktikum.Ingredient;
import praktikum.IngredientType;

public class IngredientTests {

    Ingredient ingredient;

    @Before
    public void init() {
        ingredient = new Ingredient(IngredientType.SAUCE, "сыр", 400f);
    }

    @Test
    public void getPriceTest() {
        float expectedPrice = 400f;
        Assert.assertEquals(400f, expectedPrice, 0.0);

    }

    @Test
    public void getNameTest() {
        String expectedName = "сыр";
        Assert.assertEquals(expectedName, ingredient.getName());
    }

    @Test
    public void getTypeTest() {
        IngredientType expectedType = IngredientType.SAUCE;
        Assert.assertEquals(expectedType, ingredient.getType());
    }
}
