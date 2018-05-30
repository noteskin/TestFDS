import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class PackageService implements PackageImpl {
    /**
     * 打开“服务包”页面
     * @param url
     */
    @Override
    public void jumpPackageUrl(String url) {
        InitChrome.driver.navigate().to(url);
    }

    /**
     * 【新增】服务包
     * @param arr
     * @param length
     */
    @Override
    public void addPackage(String[][] arr, int length) {

        WebDriver driver = InitChrome.driver;

        driver.findElement(By.id("addBtn")).click();
        WaitTime.SleepTime();



        PackageDao packageDao = new PackageDao();

        for(int r=1;r<length;r++){  //r行循环

            packageDao.setService_code(arr[0][r]);
            packageDao.setService_name(arr[1][r]);
            packageDao.setService_type(arr[2][r]);
            packageDao.setService_level(arr[3][r]);
            packageDao.setService_desc(arr[4][r]);
            packageDao.setService_status(arr[5][r]);
            packageDao.setService_fee(arr[6][r]);
            packageDao.setService_item_name(arr[7][r]);

            driver.switchTo().frame(0); //当前frame

            driver.findElement(By.id("_easyui_textbox_input11")).sendKeys(packageDao.getService_code());
            driver.findElement(By.id("_easyui_textbox_input14")).sendKeys(packageDao.getService_name());

            JavascriptExecutor jse = (JavascriptExecutor) driver;
            jse.executeScript("document.getElementsByClassName(\"textbox-icon combo-arrow\")[0].click()");//服务包类型 service_type b基本包，z增值包
            switch (packageDao.getService_type().charAt(0)){
                case 'b':jse.executeScript("document.getElementsByClassName(\"combobox-item\")[0].click()");//基本包
                    break;
                case 'z':jse.executeScript("document.getElementsByClassName(\"combobox-item\")[1].click()");//增值包
                    break;
                default:jse.executeScript("document.getElementsByClassName(\"combobox-item\")[0].click()");//基本包
            }


            jse.executeScript("document.getElementsByClassName(\"textbox-icon combo-arrow\")[1].click()");//服务包级别 service_level q区级，j机构级，t团队级
            switch (packageDao.getService_level().charAt(0)){
                case 'q':jse.executeScript("document.getElementsByClassName(\"combobox-item\")[2].click()");//区级
                    break;
                case 'j':jse.executeScript("document.getElementsByClassName(\"combobox-item\")[3].click()");//机构级
                    break;
                case 't':jse.executeScript("document.getElementsByClassName(\"combobox-item\")[4].click()");//团级
                    break;
                default:jse.executeScript("document.getElementsByClassName(\"combobox-item\")[3].click()");
            }


            if(packageDao.getService_level()=="t"){
                jse.executeScript("document.getElementsByClassName(\"textbox-icon combo-arrow\")[2].click()");//选择团队
                //选择团队
            }

            driver.findElement(By.id("_easyui_textbox_input18")).sendKeys(packageDao.getService_fee());//服务包费用


            jse.executeScript("document.getElementsByClassName(\"textbox-icon combo-arrow\")[3].click()");//启停状态 service_status q启用，t停用
            switch (packageDao.getService_status().charAt(0)){
                case 'q':jse.executeScript("document.getElementsByClassName(\"combobox-item\")[document.getElementsByClassName(\"combobox-item\").length-2].click()");  //启用
                    break;
                case 't':jse.executeScript("document.getElementsByClassName(\"combobox-item\")[document.getElementsByClassName(\"combobox-item\").length-1].click()");  //停用
                    break;
                default:jse.executeScript("document.getElementsByClassName(\"combobox-item\")[document.getElementsByClassName(\"combobox-item\").length-2].click()");  //启用
            }



            driver.findElement(By.id("_easyui_textbox_input20")).sendKeys(packageDao.getService_desc());   //服务包描述


            //分割字符串,组成数组
            String[] serviceItemName = packageDao.getService_item_name().split(",");
            for(String s:serviceItemName){  //循环遍历数组,赋值给s
                /**
                 * 从左边选中项目名称,实现方法一
                 */
                List<WebElement> datagridRow =driver.findElements(By.className("datagrid-row"));
                for(int d=0;d<datagridRow.size();d++){
                    if(datagridRow.get(d).getText().equals(s)){
                        datagridRow.get(d).click();
                        WaitTime.SleepTime();
                    }
                }


                /**
                 * 从左边选中项目名称,实现方法二
                 *        for (Iterator<WebElement> it = datagridRow.iterator();it.hasNext();){
                 *            WebElement we = it.next();
                 *            if(we.getText().equals(s)){
                 *                we.click();
                 *                WaitTime.SleepTime();
                 *            }
                 *
                 *        }
                 */

                driver.findElement(By.id("button2")).click();   //右移选择箭头
                WaitTime.SleepTime();
            }



    //        driver.findElement(By.id("button3")).click();   //左移取消箭头


            driver.findElement(By.id("saveBut")).click();   //【保存】

            WaitTime.SleepTime(); //设置等待时间，默认500

            driver.switchTo().defaultContent();

            driver.findElement(By.xpath("/html/body/div[7]/div[3]/a/span/span")).click();
            //【取消】项目
//            driver.findElement(By.id("cancel")).click();
            WaitTime.SleepTime(); //设置等待时间，默认500


//            driver.findElement(By.id("canBut")).click();    //【取消】

            driver.findElement(By.id("addBtn")).click();
            WaitTime.SleepTime();


        }

        driver.close();
        driver.quit();


    }
}
