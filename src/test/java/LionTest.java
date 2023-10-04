import com.example.Feline;
import com.example.Lion;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.List;

@RunWith(MockitoJUnitRunner.class)
public class LionTest {

    @Mock
    private Feline feline;

    @Test
    public void doesHaveManeTestShouldReturnFalse() throws Exception {
        Lion lion = new Lion(feline, "Самка");
        Assert.assertFalse(lion.doesHaveMane());
    }
    @Test
    public void doesHaveManeTestShouldReturnTrue() throws Exception {
        Lion lion = new Lion(feline, "Самец");
        Assert.assertTrue(lion.doesHaveMane());
    }

    @Test
    public void lionFoodTest() throws Exception {
        Lion lion = new Lion(feline, "Самец");
        List<String> expectedFood = List.of("Животные", "Птицы", "Рыба");
        Mockito.when(feline.getFood("Хищник")).thenReturn(expectedFood);
        List<String> foods = lion.getFood();
        Assert.assertEquals(expectedFood, foods);
    }

    @Test
    public void getKittensTest() throws Exception {
        Lion lion = new Lion(feline,"Самец");
        lion.getKittens();
        Mockito.verify(feline).getKittens();
    }

    @Test
    public void undefinedSexTest() {
        Exception actual = Assert.assertThrows(Exception.class, () -> new Lion(feline, "Что-то иное"));
        Assert.assertEquals("Используйте допустимые значения пола животного - самей или самка", actual.getMessage());
    }
}
