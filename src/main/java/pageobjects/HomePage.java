package pageobjects;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class HomePage {

  private WebDriver driver;

  public HomePage(WebDriver driver) {
    this.driver = driver;
  }

  public void verificarLogo() {
    WebElement imgLogo = driver.findElement(By.cssSelector("#logo"));
    Assert.assertTrue("El logo no es visible", imgLogo.isDisplayed());
  }

  public void verificarUsuarioLogueado() {
    WebElement lblUsuarioLogueado = driver
        .findElement(By.cssSelector("#user_information > span:first-child"));
    Assert.assertTrue("El usuario no está logueado", lblUsuarioLogueado.isDisplayed());
  }

  public void verificarLogueoSatisfactorio() {
    WebElement lblLogueoSatisfactorio = driver
        .findElement(By.cssSelector("#content > p.flash_notice"));
    Assert.assertTrue("El usuario no se logueó satisfactoriamente",
        lblLogueoSatisfactorio.getText().equalsIgnoreCase("Signed in successfully."));
  }

  public void seleccionarNuevoRegistroEmpleado(){
    WebElement lnkNuevoRegistro = driver
        .findElement(By.cssSelector("#content > p > a[href='/employees/new']"));
    lnkNuevoRegistro.click();
  }

}
