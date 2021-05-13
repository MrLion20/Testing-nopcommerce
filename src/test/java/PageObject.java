import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import java.util.concurrent.TimeUnit;

public class PageObject extends BasePage {
    public PageObject(WebDriver driver) {
        super(driver);
    }

    //Elementos necesarios para realizar las pruebas necesarias

    //Pagina De Login
    By txt_email = By.id("Email");
    By txt_password = By.id("Password");
    By cb_remember = By.id("RememberMe");
    By btn_login = By.xpath("/html/body/div[6]/div/div/div/div/div[2]/div[1]/div/form/div[3]/button");
    //Pagina Del sistema Administrativo
    By logo = By.xpath("/html/body/div[3]/aside/a/img[1]");

    //Implementacion de las acciones de Pruebas

    public void Login() {
       /* Credenciales de login:
        - Email: admin@yourstore.com
        -PassWord: admin */
        //Se limpian los espacios del login
        clear(txt_email);
        clear(txt_password);
        System.out.println("Se Limpian correctamente los TextBox de los credenciales");
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);

        //Agregar informacion en los TextBox
        type("admin@yourstore.com", txt_email);
        System.out.println("Correo Agregado");
        type("admin", txt_password);
        System.out.println("Contraseña Agregada");

        //Seleccionar el CheckBox
        click(cb_remember);
        System.out.println("CheckBox de Recordar Usuario Seleccionado");
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);

        //Confirmar los Datos al ingresar y Precionar Boton para Confirmar Credenciales y ingresar al Sistema
        click(btn_login);
        System.out.println("Presionado correctamente Boton de Log In ");
    }

    public void confirmacion_ingreso(){
        //Se confirma si existe el logo de la pagina Administrativa para conocer si ingresamos correctamente
        Assert.assertTrue(isDisplayed(logo),"No se ingreso correctamente los credenciales");
        }
    }

