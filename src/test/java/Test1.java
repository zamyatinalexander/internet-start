import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import java.util.ArrayList;

import static org.testng.Assert.assertEquals;

public class Test1 extends BaseClass{

    @Test   //проверка, что при введении в строку поиска url сайта и по нажатию Enter сразу открывается сайт, а не производится поиск в поисковике
    public void test1()throws InterruptedException{
        start();
        getPage("https://new.internet-start.net");
        WebElement search = driver.findElement(By.id("customSearchInput"));
        search.sendKeys("google.com");
        driver.findElement(By.xpath("//span[@class='suggestion-domain-text']"));
        search.sendKeys(Keys.ENTER);
        sleep(1);

        ArrayList<String> tabs2 = new ArrayList<String> (driver.getWindowHandles());
        driver.switchTo().window(tabs2.get(1));
        String title = driver.getTitle();
        driver.switchTo().window(tabs2.get(0));
        String title2 = "Google";
        assertEquals(title, title2);    //проверим, что открылась страница google.com
    }


    @Test   //поиск по слову google.com по нажатию на кнопку Search
    public void test2() throws InterruptedException {
        start();
        getPage("https://new.internet-start.net");
        WebElement search = driver.findElement(By.id("customSearchInput"));
        search.sendKeys("google.com");
        WebElement searchButton = driver.findElement(By.xpath("//span[contains(text(), 'Search')]"));
        searchButton.click();

        driver.findElement(By.xpath("//div[contains(text(),'news.google.com')]")).click();
        driver.findElement(By.xpath("//div[@class='article-inner']//h1[contains(text(),'Google Новости')]"));   //проверим что в правой части экрана появилась нужная информация, а именно заголовок Google Новости
        driver.findElement(By.xpath("//div[@class='article-inner']//a[contains(text(),'news.google.com')]"));   //проверим что в правой части экрана появилась нужная информация, а именно ссылка на ресурс news.google.com
    }


    @Test   //Проверим, что работаю кнопки свернуть и развернуть статью в правой части по кнопкам  Show more и Hide
    public void test3() throws InterruptedException {
        start();
        getPage("https://new.internet-start.net");
        WebElement search = driver.findElement(By.id("customSearchInput"));
        search.sendKeys("google.com");
        WebElement searchButton = driver.findElement(By.xpath("//span[contains(text(), 'Search')]"));
        searchButton.click();

        driver.findElement(By.xpath("//span[contains(text(),'Show more')]")).click();   //Нажатие на Show more
        if ((driver.findElements(By.xpath("//span[contains(text(),'Hide')]"))).size() == 0) {
            Assert.fail("Кнопка Hide не отобразилась");
        }

        driver.findElement(By.xpath("//span[contains(text(),'Hide')]")).click();   //Нажатие на Show more
        if ((driver.findElements(By.xpath("//span[contains(text(),'Show more')]"))).size() == 0) {
            Assert.fail("Кнопка Show more не отобразилась");
        }
    }
}
