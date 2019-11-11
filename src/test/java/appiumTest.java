import di.yang.utils.MyAndroidDriver;
import org.testng.annotations.Test;

public class appiumTest {
    private MyAndroidDriver driver = new MyAndroidDriver();

    @Test
    public void testStart(){
        driver.setAndroidDriver();
    }
}
