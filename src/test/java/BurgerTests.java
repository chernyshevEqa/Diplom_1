import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import praktikum.*;
import java.util.List;


@RunWith(MockitoJUnitRunner.class)
public class BurgerTests {

    private Burger burger;
    private Bun mockBun;
    private Ingredient mockIngredient;

    @Before
    public void setUp() {
        burger = new Burger();
        mockBun = Mockito.mock(Bun.class);
        mockIngredient = Mockito.mock(Ingredient.class);
    }

    @Test
    public void setBunsTest() {
        burger.setBuns(mockBun);

        Assert.assertEquals(mockBun, burger.bun);
    }

    @Test
    public void addIngredientTest() {

        burger.addIngredient(mockIngredient);

        Assert.assertTrue(burger.ingredients.contains(mockIngredient));
    }

    @Test
    public void removeIngredientFromListTests() {

        burger.addIngredient(mockIngredient);

        burger.removeIngredient(0);

        Assert.assertTrue(burger.ingredients.isEmpty());


    }

    @Test
    public void moveIngredientTest() {

        Ingredient ingredient1 = Mockito.mock(Ingredient.class);
        Ingredient ingredient2 = Mockito.mock(Ingredient.class);

        burger.addIngredient(ingredient1);
        burger.addIngredient(ingredient2);

        burger.moveIngredient(1, 0);

        List<Ingredient> ingredients = burger.ingredients;

        Assert.assertEquals(ingredient2, ingredients.get(0));
        Assert.assertEquals(ingredient1, ingredients.get(1));
    }

    @Test
    public void getReceiptTest() {

        Mockito.when(mockBun.getName()).thenReturn("black bun");
        Mockito.when(mockIngredient.getName()).thenReturn("cheese");
        Mockito.when(mockIngredient.getType()).thenReturn(IngredientType.FILLING);

        burger.setBuns(mockBun);
        burger.addIngredient(mockIngredient);

        String expectedReceipt = String.format(
                "(==== %s ====)%n= %s %s =%n(==== %s ====)%n%nPrice: %f%n",
                "black bun", "filling", "cheese", "black bun", burger.getPrice());


        Assert.assertEquals(expectedReceipt, burger.getReceipt());
    }
}
