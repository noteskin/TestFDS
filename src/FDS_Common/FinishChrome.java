import org.testng.annotations.Test;

public class FinishChrome {

@Test
    public void quitChrome(){
        System.out.println("rrrr");
        InitChrome.driver.close();
        InitChrome.driver.quit();
    }

}
