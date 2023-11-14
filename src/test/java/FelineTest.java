import com.example.Feline;
import org.junit.Assert;
import org.junit.Test;
import org.mockito.Mockito;

public class FelineTest {

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
}
