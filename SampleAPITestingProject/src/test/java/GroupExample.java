import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class GroupExample {

    @BeforeMethod(onlyForGroups = "groupA")
    public void beforeGroupA() {
        System.out.println(">>> [BeforeMethod] Runs only for 'groupA' <<<");
    }

    @AfterMethod(onlyForGroups = "groupA")
    public void afterGroupA() {
        System.out.println(">>> [AfterMethod] Runs only for 'groupA' <<<");
    }

    @BeforeMethod(onlyForGroups = "groupB")
    public void beforeGroupB() {
        System.out.println(">>> [BeforeMethod] Runs only for 'groupB' <<<");
    }

    @AfterMethod(onlyForGroups = "groupB")
    public void afterGroupB() {
        System.out.println(">>> [AfterMethod] Runs only for 'groupB' <<<");
    }

    @Test(groups = "groupA")
    public void testA() {
        System.out.println(">>> [Test] Running testA() <<<");
    }

    @Test(dependsOnGroups = "groupA")
    public void testB() {
        System.out.println(">>> [Test] Running testB() <<<");
    }

    @Test(dependsOnGroups = "groupA", groups = "groupB")
    public void testC() {
        System.out.println(">>> [Test] Running testC() <<<");
    }

}