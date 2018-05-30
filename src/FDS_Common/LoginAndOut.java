import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginAndOut {

    public void login(String username,String password){
        WebDriver driver = InitChrome.driver;
        driver.navigate().to("http://172.19.103.123:28080/familyDoctor/main");

        WaitTime.SleepTime(1000); //设置等待时间，默认500

        WebElement userNameElement = driver.findElement(By.id("username")); //输入用户名
        userNameElement.sendKeys(username);

        WebElement userPasswordElement = driver.findElement(By.id("password")); //输入密码
        userPasswordElement.sendKeys(password);

        WebElement loginButton = driver.findElement(By.id("subimg"));   //【登陆】
        loginButton.click();
    }


}
