import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.BDDMockito;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;
import static org.mockito.Mockito.*;

@RunWith( PowerMockRunner.class )
@PrepareForTest( AgaUtils.class )
public class BookTest {

    @Test (expected = NullPointerException.class)
   @Test
public void testMockObjectStaticWithMockito() {
    try (MockedStatic<AgaUtils> mockedStatic = mockStatic(AgaUtils.class)) {
        // Arrange
        mockedStatic.when(() -> AgaUtils.getTextUppercase(anyString())).thenReturn("yesterday");

        Book book = new Book();
        String exp = "yesterday";

        // Act
        String act = book.getTitle();

        // Assert
        Assert.assertEquals(exp, act);
    }
}

    }

    @Test
    public void testMockObjectStatic(){
        //arrange
        PowerMockito.mockStatic(AgaUtils.class);
        BDDMockito.given(AgaUtils.getTextUppercase(any(String.class))).willReturn("yesterday");

        Book book = new Book();
        String exp = "yesterday";

        //act
        String act = book.getTitle();

        //assert
        Assert.assertEquals(exp, act);
    }


    @Test
    public void testGetTitle(){
        //arrange
        Book book = new Book();
        String exp = "TODAY IS THE DAY";

        //act
        String act = book.getTitle();

        //assert
        Assert.assertEquals(exp, act);
    }

}
