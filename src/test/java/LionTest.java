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
    public void doesHaveManeTest() throws Exception {
        Lion lion = new Lion(feline, "Самка");
        boolean actual = lion.doesHaveMane();
        boolean expected = false;
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void lionFoodTest() throws Exception {
        Lion lion = new Lion(feline, "Самец");
        Mockito.when(feline.getFood("Хищник")).thenReturn(List.of("Животные", "Птицы", "Рыба"));
        List<String> foods = lion.getFood();
        Assert.assertEquals(List.of("Животные", "Птицы", "Рыба"), foods);
    }


    @Test
    public void getKittensTest() throws Exception {
        Lion lion = new Lion(feline,"Самец");
        Mockito.when(feline.getKittens()).thenReturn(1);
        int kittens = lion.getKittens();
        Assert.assertEquals(1, kittens);
    }

//    @Test
//    public void undefinedSexTest() throws Exception {
//        Lion lion = new Lion(feline, "Что-то иное");
//    }
}
