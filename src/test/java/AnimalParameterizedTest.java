import com.example.Animal;
import org.hamcrest.CoreMatchers;
import org.hamcrest.MatcherAssert;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.List;

@RunWith(Parameterized.class)
public class AnimalParameterizedTest {

    private final String animalType;
    private final List<String> expectedListOfFood;

    public AnimalParameterizedTest(String animalType, List<String> expectedListOfFood) {
        this.animalType = animalType;
        this.expectedListOfFood = expectedListOfFood;
    }

    @Parameterized.Parameters
    public static Object[][] getCreds() {
        return new Object[][] {
                {"Травоядное", List.of("Трава", "Различные растения")},
                {"Хищник", List.of("Животные", "Птицы", "Рыба")},

        };
    }

    @Test
    public void getFamilyIsCorrect() {
        String expectedString = "Существует несколько семейств: заячьи, беличьи, мышиные, кошачьи, псовые, медвежьи, куньи";

        MatcherAssert.assertThat("Некорректный перечень семейств",
                new Animal().getFamily(),
                CoreMatchers.equalTo(expectedString)
        );
    }

    @Test
    public void getFoodCheck() throws Exception {
        Assert.assertEquals(new Animal().getFood(animalType), expectedListOfFood);
    }
}
