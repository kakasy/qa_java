import com.example.Feline;
import com.example.LionAlex;
import org.hamcrest.CoreMatchers;
import org.hamcrest.MatcherAssert;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.List;

@RunWith(MockitoJUnitRunner.class)
public class LionAlexTest {

    @Mock
    private Feline feline;

    @Test
    public void getKittensShouldBeZero() throws Exception {
        MatcherAssert.assertThat("У Алекса нет котят"
                , new LionAlex(feline).getKittens()
                , CoreMatchers.equalTo(0));
    }

    @Test
    public void getHomeShouldBeNY() throws Exception {
        MatcherAssert.assertThat("Алекс живёт в другом месте"
                , new LionAlex(feline).getPlaceOfLiving()
                , CoreMatchers.equalTo("Нью-Йоркский зоопарк"));
    }


    @Test
    public void checkListOfFriends() throws Exception {
        List<String> expected = List.of("зебра Марти", "бегемотиха Глория", "жираф Мелман");
        MatcherAssert.assertThat("Список друзей неверен",
                new LionAlex(feline).getFriends(),
                CoreMatchers.equalTo(expected));
    }

}
