import com.example.Feline;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;


@RunWith(Parameterized.class)
public class FelineParamTest {

    private final int kittensCount;
    private final int expectedKittensCount;


    public FelineParamTest(int kittensCount, int expectedKittensCount) {
        this.kittensCount = kittensCount;
        this.expectedKittensCount = expectedKittensCount;
    }

    @Parameterized.Parameters

    public static Object[][] getCreds() {
        return new Object[][] {
                {1, 1},
                {3, 3},
                {5, 5},
        };
    }
    @Test
    public void getKittensWithParams() {
        Feline feline = new Feline();
        Assert.assertEquals(expectedKittensCount, feline.getKittens(kittensCount));
    }
}
