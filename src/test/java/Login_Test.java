import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

public class Login_Test {

    private static final WebDriver driver = new ChromeDriver();

    @BeforeSuite
    public static void main(String[] args) {
    }
    @Test(priority = 1)
    public static void Cargar_Pagina() throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", Conexion.CHROME_DRIVER_LOCATION);
        driver.get(Conexion.BASE_URL);
        System.out.println("Se abre el navegador y la URL de la prueba");
        driver.manage().window().maximize();
        System.out.println("Se Maximiza el Navegador");
    }
    @Test(priority = 2)
    public static void Ingresar_Credenciales() throws InterruptedException {
        PageObject pageobject = new PageObject(driver);
        System.out.println("Inicio de Ingreso de Credenciales");
        pageobject.Login();
    }
    @Test(priority = 2)
    public static void confirmar_ingreso() throws InterruptedException {
        PageObject pageobject = new PageObject(driver);
        pageobject.confirmacion_ingreso();
    }

    @AfterSuite
    public static void cleanUp(){
        driver.manage().deleteAllCookies();
        driver.close();
    }
}
