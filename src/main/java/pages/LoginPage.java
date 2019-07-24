package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class LoginPage {

  WebDriver driver = null;

  public void abrirPaginaVacaciones(){
    System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
    driver = new ChromeDriver();
    driver.get("https://vacations-management.herokuapp.com/users/sign_in");
  }

  public void escribirCorreoElectronico(String correoElectronico){
    WebElement txtUsuario = driver.findElement(By.id("user_email"));
    txtUsuario.sendKeys(correoElectronico);
  }

  public void escribirContrasena(String contrasena){
    WebElement txtContrasena = driver.findElement(By.id("user_password"));
    txtContrasena.sendKeys(contrasena);
  }

  public void ingresarPaginaInicio(){
    WebElement btnIngresar = driver.findElement(By.name("commit"));
    btnIngresar.click();
  }

}
