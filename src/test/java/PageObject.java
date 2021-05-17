import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import java.util.concurrent.TimeUnit;

public class PageObject extends BasePage {
    public PageObject(WebDriver driver) {
        super(driver);
    }

    ExtentReports extent;
    ExtentSparkReporter sparkReporter;

    //Elementos necesarios para realizar las pruebas necesarias

    //Pagina De Login
    By txt_email = By.id("Email");
    By txt_password = By.id("Password");
    By cb_remember = By.id("RememberMe");
    By btn_login = By.xpath("/html/body/div[6]/div/div/div/div/div[2]/div[1]/div/form/div[3]/button");

    //Pagina Del sistema Administrativo
    By logo = By.xpath("/html/body/div[3]/aside/a/img[1]");
    By btnCostumers = By.xpath("/html/body/div[3]/aside/div/div[4]/div/div/nav/ul/li[4]/a");
    By btnCostumersPage = By.xpath("/html/body/div[3]/aside/div/div[4]/div/div/nav/ul/li[4]/ul/li[1]/a");
    By btnAddNew = By.xpath("/html/body/div[3]/div[1]/form[1]/div/div/a");

    //Pantalla del Formulario ADDCostumer
    By txt_costumer_email = By.id("Email");
    By txt_costumer_password = By.id("Password");
    By txt_costumer_FirstName = By.id("FirstName");
    By txt_costumer_LastName = By.id("LastName");
    By RB_Male = By.id("Gender_Male");
    By RB_Female = By.id("Gender_Female");
    By txt_calendar = By.id("DateOfBirth");
    By txt_company = By.id("Company");
    By CB_tax = By.id("IsTaxExempt");
    By select_newsletter = By.xpath("//*[@id=\"customer-info\"]/div[2]/div[9]/div[2]/div/div[1]/div");
    By select_costumer_rol = By.xpath("//*[@id=\"customer-info\"]/div[2]/div[10]/div[2]/div/div[1]/div/div");
    By select_vender = By.id("VendorId");
    By CB_active = By.id("Active");
    By txt_adminContent = By.id("AdminComment");
    By btn_save = By.xpath("/html/body/div[3]/div[1]/form/div[1]/div/button[1]");

    //Implementacion de las acciones de Pruebas
    //Acciones Antes Pruebas
    public void BeforeSuit() {
        extent = new ExtentReports();
        sparkReporter = new ExtentSparkReporter("Reports\\Report_eCommerce.html");
        extent.attachReporter(sparkReporter);
        sparkReporter.config().setDocumentTitle("Prueba de Page eCommerce");

        extent.setSystemInfo("Company name", "Babel");
        extent.setSystemInfo("Proyect Name", "Commerce Page Test");
        extent.setSystemInfo("Tester Name", "Ing. Justin Leon Castro");
        extent.setSystemInfo("Test Lead", "Ing. ..............");
    }

    //Acciones Despues Pruebas
    public void AfterSuit() {
        extent.flush();
    }

    //Test Cargar Pagina
    public void CargarPagina() {
        ExtentTest test = extent.createTest("Iniciar Prueba Cargar_Pagina");
        System.setProperty("webdriver.chrome.driver", Conexion.CHROME_DRIVER_LOCATION);
        test.log(Status.INFO, "Abierto navegador");
        driver.get(Conexion.BASE_URL);
        test.info("Se Abre la URL de prueba" + "https://admin-demo.nopcommerce.com/login?ReturnUrl=%2Fadmin%2F");
        driver.manage().window().maximize();
        test.info("Se maximiza la ventana del navegador");
        test.pass("Prueba Cargar_Pagina Completa");
    }

    //Test Login
    public void Login() {
       /* Credenciales de login:
        - Email: admin@yourstore.com
        -PassWord: admin */

        //Test de limpiar los espacios del login para ingresar los Credenciales
        ExtentTest test = extent.createTest("Iniciar Prueba Login");
        test.log(Status.INFO, "Se inicia la prueba Limpiar Espacios");
        clear(txt_email);
        test.info("Se limpia espacion Email");
        clear(txt_password);
        test.info("Se Limpia espacio Password");
        test.pass("Se han limpiado correctamente los espacios");

        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);

        //Agregr Credenciales
        test.log(Status.INFO, "Se inicia la prueba de Ingresar Credenciales");
        type("admin@yourstore.com", txt_email);
        test.info("Se ingresa el Email admin@yourstore.com");
        type("admin", txt_password);
        test.info("Se ingresa el Password admin");
        test.pass("Se ingresaron los Credenciales correctamente");

        //Seleccionar el CheckBox
        test.log(Status.INFO, "Se inicia la prueba del CheckBox de Recordar Credencial");
        click(cb_remember);
        test.pass("Se selecciona el CheckBox de Recordar Credenciales");
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);

        //Confirmar los Datos al ingresar y Precionar Boton para Confirmar Credenciales y ingresar al Sistema
        test.log(Status.INFO, "Se inicia la prueba del Boton de Login");
        click(btn_login);
        test.pass("Se Se preciono el Boton de Login");

        //Se confirma si existe el logo de la pagina Administrativa para conocer si ingresamos correctamente
        test.log(Status.INFO, "Se Confirma que hemos ingresado correctamente al sistema");
        Assert.assertTrue(isDisplayed(logo), String.valueOf(test.fail("No se ingreso Correctamente a la pagina")));
        test.pass("Se ingreso correctamente al Sistema");
    }

    //Test AddCostumer
    public void Form_AddCostumer() {
        ExtentTest test = extent.createTest("Iniciar Prueba Ingresar a Formulario de Agregar Costumers");

        if (isDisplayed(btnCostumers)) {
            click(btnCostumers);
            click(btnCostumersPage);
        } else {
            test.fail("No se ingreso Correctamente al systema, no estan los botones para ingresar al formulario de agregar usuario");
        }
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
        if (isDisplayed(btnAddNew)) {
            click(btnAddNew);
            test.pass("Se Presiono el boton de agregar usuario correctamente");
        } else {
            System.out.println("Boton de Agregar Cliente no disponible");
            test.fail("botton de AddCostumer no disponible");

        }
        test.pass("Se verifica y se ingresa a la pagina de Formulario de agregar Costumer");
    }

    public void addinfo_Costumer(){



    }
}