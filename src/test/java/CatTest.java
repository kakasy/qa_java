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
    private Cat cat;

    @Test
    public void getCatSoundTest() {
        Mockito.when(cat.getSound()).thenReturn("Мяу");
        String actual = cat.getSound();
        String expected = "Мяу";
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void catSoundTest() {
        Feline feline = new Feline();
        Cat cat = new Cat(feline);
        String actual = cat.getSound();
        String expected = "Мяу";
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void catFoodTest() {
        try {
            Mockito.when(cat.getFood()).thenReturn(List.of("Животные", "Птицы", "Рыба"));
            List<String> actual = cat.getFood();
            List<String> expected = List.of("Животные", "Птицы", "Рыба");
            Assert.assertEquals(expected, actual);
        } catch (Exception e) {
            Assert.fail("Исключение не выбрасывается при правильной работе: " + e.getMessage());
        }
    }

    @Test
    public void getFoodTest() {
        try {
            Feline feline = new Feline();
            Cat cat = new Cat(feline);
            System.out.println(cat.getFood());
        } catch (Exception e) {
            Assert.fail("Исключение не выбрасывается при правильной работе: " + e.getMessage());
        }
    }
}
