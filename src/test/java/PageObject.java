import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

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
    By btn_login = By.className("button-1 login-button");

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

        //Precionar Boton para Confirmar Credenciales y ingresar al Sistema
        click(btn_login);
        System.out.println("Presionado correctamente Boton de Log In ");
    }
}
