import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

public class AddCostumer_Test {
    ExtentReports extent;
    ExtentSparkReporter sparkReporter;
    private static final WebDriver driver = new ChromeDriver();
    PageObject pageobject = new PageObject(driver);

    @BeforeSuite
    public void BeforeSuit() {
        pageobject.BeforeSuit();
        pageobject.CargarPagina();
    }

    @Test(priority = 1)
    public void Ingresar_Credenciales() throws InterruptedException {
        pageobject.Login();
    }

    @Test(priority = 2)
    public void Form_AddCostumer() throws InterruptedException {
        pageobject.Form_AddCostumer();
        pageobject.add_info_Costumer();
        pageobject.seleccionVendor();
    }

    @AfterSuite
    public void AfterSuite() {
       /* pageobject.AfterSuit();
        driver.manage().deleteAllCookies();
        driver.close();
        driver.quit();*/
    }
}
