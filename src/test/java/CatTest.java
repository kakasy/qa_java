import com.example.Cat;
import com.example.Feline;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;

import org.mockito.junit.MockitoJUnitRunner;

import java.util.List;

@RunWith(MockitoJUnitRunner.class)
public class CatTest {

    @Mock
    private Feline feline;

    @Test
    public void getCatSoundTest() {
        Cat cat = new Cat(feline);
        String actual = cat.getSound();
        String expected = "Мяу";
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void catFoodTest() throws Exception {
            Cat cat = new Cat(feline);
            cat.getFood();
            Mockito.verify(feline, Mockito.times(1)).eatMeat();
    }

    @Test
    public void getFoodTest() throws Exception {
            Cat cat = new Cat(feline);
            List<String> expected = List.of("Животные", "Птицы", "Рыба");
            Mockito.when(feline.eatMeat()).thenReturn(expected);
            Assert.assertEquals(expected, cat.getFood());
    }
}
