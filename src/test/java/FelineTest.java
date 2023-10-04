import com.example.Feline;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.mockito.Mockito;


@RunWith(Parameterized.class)
public class FelineTest {

    private final int kittensCount;
    private final int expectedKittensCount;


    public FelineTest(int kittensCount, int expectedKittensCount) {
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
    public void getFamilyTest() {
        Feline feline = new Feline();
        Assert.assertEquals("Кошачьи", feline.getFamily());
    }

    @Test
    public void eatMeatTest() throws Exception {
        Feline feline = Mockito.spy(new Feline());
        feline.eatMeat();
        Mockito.verify(feline).getFood("Хищник");
    }

    @Test
    public void getKittensShouldReturn1() {
        Feline feline = new Feline();
        Assert.assertEquals(1, feline.getKittens());
    }

    @Test
    public void getKittensWithParams() {
        Feline feline = new Feline();
        Assert.assertEquals(expectedKittensCount, feline.getKittens(kittensCount));
    }
}
