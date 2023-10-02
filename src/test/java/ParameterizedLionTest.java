import com.example.Lion;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

@RunWith(Parameterized.class)
public class ParameterizedLionTest {

    private final String sex;
    private final boolean mane;

    public ParameterizedLionTest(String sex, boolean mane) {
        this.sex = sex;
        this.mane = mane;
    }

    @Parameterized.Parameters
    public static Object[][] getCreds() {
        return new Object[][] {
                {"Самец", true},
                {"Самка", false},
        };
    }

    @Test
    public void checkSex() throws Exception {
        Lion lion = new Lion(null, sex);
        boolean testMane = lion.doesHaveMane();
        Assert.assertEquals(mane, testMane);
    }
}
