import com.example.Feline;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.mockito.Spy;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.List;

@RunWith(MockitoJUnitRunner.class)
public class FelineTest {

    @Spy
    private Feline feline;

    @Test
    public void getKittensWOArgShouldReturn1() {
        int actual = feline.getKittens();
        int expected = 1;
        System.out.println(actual);
        Mockito.verify(feline, Mockito.times(1)).getKittens();
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void getKittensWithArg3ShouldReturn3() {
        int num = feline.getKittens(3);
        System.out.println(num);
        Assert.assertEquals(3, feline.getKittens(3));
    }

    @Test
    public void getFamilyTest() {
        String expected = "Кошачьи";
        String actual = feline.getFamily();
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void eatMeatTest() {
        try {
            List<String> foodList = feline.eatMeat();
            Assert.assertEquals(List.of("Животные", "Птицы", "Рыба"), foodList);
        } catch (Exception e) {
            Assert.fail("Исключение не выбрасывается при правильной работе: " + e);
        }

    }
}
