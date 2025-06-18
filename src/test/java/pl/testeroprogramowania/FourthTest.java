package pl.testeroprogramowania;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class FourthTest {

    @Test(dependsOnMethods = {"thirdTest"})
    public void firstTest() {
        System.out.println("I'm first test");
    }

    @Test(dependsOnMethods = {"firstTest"})
    public void secondTest() {
        System.out.println("I'm second test");

    }

    @Test
    public void thirdTest() {
        System.out.println("I'm third test");

    }


    @Test(dataProvider = "data")
    public void dpTest(String val, String number) {
        System.out.println(val);
        System.out.println(number);

    }

    @DataProvider(name = "data")
    public Object[][] dataProvider() {
        return new Object[][] {{"I am first test", "First"}, {"I am second test", "Second"}, {"I am third test", "Third"}};
    }
}
