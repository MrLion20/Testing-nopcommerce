import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

public class BasePage {

    protected WebDriver driver;

    public BasePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    //Para buscar los elementos
    public WebElement findElement(By locator) {
        return driver.findElement(locator);
    }

    //Accion para dar clic a un elemento
    public void click(By locator){
        driver.findElement(locator).click();
    }

    //Accion para mandar texto
    public void type(String inputText, By locator){
        driver.findElement(locator).sendKeys(inputText);
    }

    //Accion para tomar text
    public String getText(WebElement element) {
        return element.getText();
    }
    public String getText(By locator) {
        return driver.findElement(locator).getText();
    }

    //Accion para verificar la disponibilidad de un elemento

    public boolean isDisplayed(By locator){
        try{
            return driver.findElement(locator).isDisplayed();
        } catch (org.openqa.selenium.NoSuchElementException e){
            return false;
        }
    }
}

