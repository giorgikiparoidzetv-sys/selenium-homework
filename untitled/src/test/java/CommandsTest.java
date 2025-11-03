import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class CommandsTest {
    public static void main(String[] args) throws InterruptedException {

        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("http://the-internet.herokuapp.com/dynamic_controls");

        WebElement enableButton = driver.findElement(By.xpath("//*[@id=\"input-example\"]/button"));
        enableButton.click();

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        WebElement input=wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"input-example\"]/input")));
        System.out.println("input field is enabled :"  + input.isEnabled());

        WebElement msg=wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("message")));
        System.out.println("messsage text: "+ msg.getText());

        if (input.isEnabled() && msg.getText().equals("It's enabled!")) {
            System.out.println("შეყვანის ველი გააქტიურდა, ტექსტი ჩანს");}


        wait.until(ExpectedConditions.textToBePresentInElement(enableButton, "Disable"));
        System.out.println("ღილაკის ტექსტი წარმატებით შეიცვალა");


        input.sendKeys("bootcamp");
        input.clear();

        driver.get("http://the-internet.herokuapp.com/drag_and_drop");

        WebElement columnA = driver.findElement(By.id("column-a"));
        WebElement columnB = driver.findElement(By.id("column-b"));

        int A = columnA.getLocation().getY();
        int B = columnB.getLocation().getY();

        if (A == B) {
            System.out.println(" A და B წარმატებით არიან გასწორებული ;)");
        } else {
            System.out.println("A და B არ არიან გასწორებული :(");
        }

        driver.quit();

    }
}
