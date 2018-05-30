import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ItemService implements ItemImpl {
    @Override
    public void jumpItemUrl(String url) {
        InitChrome.driver.navigate().to(url);
    }

    /**
    @Override
    public void addItem(String[] arr) {
        WebDriver driver = InitChrome.driver;

        WebElement newButton = driver.findElement(By.id("button0"));    //【新增】按钮
        newButton.click();

        WaitTime.SleepTime(); //设置等待时间，默认500

        driver.switchTo().frame(0); //当前frame

        ItemDao itemInfo = new ItemDao();

        itemInfo.setItem_name(arr[1]);  //1项目名称
        itemInfo.setItem_code(arr[0]);  //2项目编码
        itemInfo.setShow_type(arr[2]); //3展现方式 0：数值结果，1：描述文本，2：页面链接
        itemInfo.setAllow_entry(arr[3]);   //4是否允许录入 0：否，1：是
        itemInfo.setItem_desc(arr[4]);  //5项目描述
        itemInfo.setItem_status(arr[5]);   //6停启状态 0：启用，1：停用

        //1项目名称
        WebElement itemName =  driver.findElement(By.id("_easyui_textbox_input8"));
        itemName.sendKeys(itemInfo.getItem_name());

        //2项目编码
        WebElement itemCode = driver.findElement(By.id("_easyui_textbox_input10"));
        itemCode.sendKeys(itemInfo.getItem_code());

        JavascriptExecutor jse = (JavascriptExecutor) driver;
        //3展现方式 0：s数值结果，1：m描述文本，2：l页面链接
        jse.executeScript("document.getElementsByClassName(\"textbox-icon combo-arrow\")[0].click()");
        switch (itemInfo.getShow_type()){
            case "s" :jse.executeScript("document.getElementById(\"_easyui_combobox_i1_0\").click()");
            case "m" :jse.executeScript("document.getElementById(\"_easyui_combobox_i1_1\").click()");
            case "l" :jse.executeScript("document.getElementById(\"_easyui_combobox_i1_2\").click()");
        }
        WaitTime.SleepTime();



        //4是否允许录入 0：n否，1：y是
        jse.executeScript("document.getElementsByClassName(\"textbox-icon combo-arrow\")[1].click()");
        switch (itemInfo.getAllow_entry()){
            case "n" :jse.executeScript("document.getElementById(\"_easyui_combobox_i2_0\").click()");
            case "y" :jse.executeScript("document.getElementById(\"_easyui_combobox_i2_1\").click()");
        }
        WaitTime.SleepTime();


        //5项目描述
        WebElement itemDesc = driver.findElement(By.id("_easyui_textbox_input13"));
        itemDesc.sendKeys(itemInfo.getItem_desc());
        WaitTime.SleepTime(); //设置等待时间

        //6停启状态 0：q启用，1：t停用
        jse.executeScript("document.getElementsByClassName(\"textbox-icon combo-arrow\")[2].click()");
        switch (itemInfo.getItem_status()){
            case "q" :jse.executeScript("document.getElementById(\"_easyui_combobox_i3_0\").click()");
            case "t" :jse.executeScript("document.getElementById(\"_easyui_combobox_i3_1\").click()");
        }
        WaitTime.SleepTime();



        //【保存】项目
       //driver.findElement(By.id("save")).click();

        //【取消】项目
        driver.findElement(By.id("cancel")).click();
        driver.close();
        driver.quit();
    }
    */

    /**
     * @param arr
     * @param length
     */
    @Override
    public void addItem(String[][] arr, int length) {
        WebDriver driver = InitChrome.driver;

        WebElement newButton = driver.findElement(By.id("button0"));    //【新增】按钮
        newButton.click();

        WaitTime.SleepTime(); //设置等待时间，默认500



        ItemDao itemInfo = new ItemDao();

        for(int r=1;r<length;r++){  //r行循环
            driver.switchTo().frame(0); //当前frame

            itemInfo.setItem_name(arr[1][r]);  //1项目名称
            itemInfo.setItem_code(arr[0][r]);  //2项目编码
            itemInfo.setShow_type(arr[2][r]); //3展现方式 0：数值结果，1：描述文本，2：页面链接
            itemInfo.setAllow_entry(arr[3][r]);   //4是否允许录入 0：否，1：是
            itemInfo.setItem_desc(arr[4][r]);  //5项目描述
            itemInfo.setItem_status(arr[5][r]);   //6停启状态 0：启用，1：停用

            //1项目名称
            WebElement itemName =  driver.findElement(By.id("_easyui_textbox_input8"));
            itemName.sendKeys(itemInfo.getItem_name());

            //2项目编码
            WebElement itemCode = driver.findElement(By.id("_easyui_textbox_input10"));
            itemCode.sendKeys(itemInfo.getItem_code());

            JavascriptExecutor jse = (JavascriptExecutor) driver;
            //3展现方式 0：s数值结果，1：m描述文本，2：l页面链接
            jse.executeScript("document.getElementsByClassName(\"textbox-icon combo-arrow\")[0].click()");
            switch (itemInfo.getShow_type().charAt(0)){
                case 's' :jse.executeScript("document.getElementsByClassName(\"combobox-item\")[0].click()");
                    break;
                case 'm' :jse.executeScript("document.getElementsByClassName(\"combobox-item\")[1].click()");
                    break;
                case 'l' :jse.executeScript("document.getElementsByClassName(\"combobox-item\")[2].click()");
//                case 'l' :jse.executeScript("document.getElementById(\"_easyui_combobox_i1_2\").click()");
                    break;
                default:jse.executeScript("document.getElementsByClassName(\"combobox-item\")[0].click()");break;
            }
            WaitTime.SleepTime();



            //4是否允许录入 0：n否，1：y是
            jse.executeScript("document.getElementsByClassName(\"textbox-icon combo-arrow\")[1].click()");
            switch (itemInfo.getAllow_entry().charAt(0)){
                case 'n' :jse.executeScript("document.getElementsByClassName(\"combobox-item\")[3].click()");
                    break;
                case 'y' :jse.executeScript("document.getElementsByClassName(\"combobox-item\")[4].click()");
                    break;
                default:jse.executeScript("document.getElementsByClassName(\"combobox-item\")[3].click()");break;
            }
            WaitTime.SleepTime();


            //5项目描述
            WebElement itemDesc = driver.findElement(By.id("_easyui_textbox_input13"));
            itemDesc.sendKeys(itemInfo.getItem_desc());
            WaitTime.SleepTime(); //设置等待时间

            //6停启状态 0：q启用，1：t停用
            jse.executeScript("document.getElementsByClassName(\"textbox-icon combo-arrow\")[2].click()");
            switch (itemInfo.getItem_status().charAt(0)){
                case 'q' :jse.executeScript("document.getElementsByClassName(\"combobox-item\")[5].click()");
                    break;
                case 't' :jse.executeScript("document.getElementsByClassName(\"combobox-item\")[6].click()");
                    break;
                default:jse.executeScript("document.getElementsByClassName(\"combobox-item\")[5].click()");break;
            }
            WaitTime.SleepTime(1000);



            //【保存】项目
            driver.findElement(By.id("save")).click();
            WaitTime.SleepTime(); //设置等待时间，默认500

            driver.switchTo().defaultContent();

            driver.findElement(By.xpath("/html/body/div[6]/div[3]/a/span/span")).click();
            //【取消】项目
//            driver.findElement(By.id("cancel")).click();
            WaitTime.SleepTime(); //设置等待时间，默认500




            newButton.click();
            WaitTime.SleepTime(); //设置等待时间，默认500
        }


        driver.close();
        driver.quit();




    }






}
