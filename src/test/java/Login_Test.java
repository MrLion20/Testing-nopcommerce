import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

public class Login_Test {

    private static final WebDriver driver = new ChromeDriver();

    @BeforeSuite
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver", Conexión.CHROME_DRIVER_LOCATION);
        driver.get(Conexión.BASE_URL);
        System.out.println("Se abre el navegador y la URL de la prueba");
        driver.manage().window().maximize();
        System.out.println("Se Maximiza el Navegador");
    }
    @Test()
    public static void submitForm() throws InterruptedException {
        PageObject pageobject = new PageObject(driver);
        System.out.println("Inicio de Login_Test");
        pageobject.Login();
    }

    @AfterSuite
    public static void cleanUp(){
        driver.manage().deleteAllCookies();
        driver.close();
    }
}
