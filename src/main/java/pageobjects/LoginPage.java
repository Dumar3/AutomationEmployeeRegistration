package pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPage {

  private WebDriver driver;

  public LoginPage(WebDriver driver){
    this.driver = driver;
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
