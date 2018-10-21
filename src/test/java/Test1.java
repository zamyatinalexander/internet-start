import org.testng.annotations.Test;

public class Test1 extends BaseClass{

    @Test
    public void test1() throws InterruptedException {
        start();
        getPage("https://new.internet-start.net");
       
        sleep(2);
    }


}
