import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import praktikum.Burger;
import praktikum.Database;
import praktikum.Ingredient;

import java.util.Arrays;
import java.util.Collection;

@RunWith(Parameterized.class)
public class BurgerPriceCalculationTest {

    private final float expectedPrice;
    private Burger burger;

    public BurgerPriceCalculationTest(float expectedPrice) {
        this.expectedPrice = expectedPrice;
    }

    @Before
    public void setUp() {
        Database database = new Database();
        burger = new Burger();
        burger.setBuns(database.availableBuns().get(0)); // Устанавливаем первую булочку (black bun)

        // Добавляем ингредиенты
        for (Ingredient ingredient : database.availableIngredients()) {
            burger.addIngredient(ingredient);
        }
    }

    @Parameterized.Parameters
    public static Collection<Object[]> data() {
        Database database = new Database();
        float expectedPrice = database.availableBuns().get(0).getPrice() * 2; // Цена за две булочки
        for (Ingredient ingredient : database.availableIngredients()) {
            expectedPrice += ingredient.getPrice(); // Прибавляем цену каждого ингредиента
        }
        return Arrays.asList(new Object[][]{
                {expectedPrice}  // Ожидаемая цена
        });
    }

    @Test
    public void testPriceCalculation() {
        // Проверяем, что расчетная цена совпадает с ожидаемой
        Assert.assertEquals(expectedPrice, burger.getPrice(), 0.001);
    }
}
