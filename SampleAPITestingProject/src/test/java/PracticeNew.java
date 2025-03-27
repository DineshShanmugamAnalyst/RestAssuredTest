import org.testng.annotations.Test;

public class PracticeNew {

    @Test
    public void test1() {
        System.out.println("test1 ");
        throw new RuntimeException("test1 failed");
    }

    @Test(dependsOnMethods = "test1", alwaysRun = true)
    public void test2() {
        System.out.println("test 2");
    }


    @Test (dependsOnMethods = "test1", alwaysRun = false)
    public void test3() {
        System.out.println("test 3");
    }


}
