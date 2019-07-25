package pageobjects;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import utils.Utilidades;

public class HomePage {

  private WebDriver driver;
  private Utilidades utilidades;

  public HomePage(WebDriver driver) {
    this.driver = driver;
    utilidades = new Utilidades(driver);
  }


  public void verificarLogo() {
    Assert.assertTrue("El logo no es visible",
        utilidades.verificarElementoPresente(By.cssSelector("#logo")));
  }

  public void verificarUsuarioLogueado() {
    Assert.assertTrue("El usuario no está logueado", utilidades
        .verificarElementoPresente(By.cssSelector("#user_information > span:first-child")));
  }

  public void verificarLogueoSatisfactorio() {
    boolean logueoSatisfactorio;
    logueoSatisfactorio = utilidades
        .verificarElementoPresente(By.cssSelector("#content > p.flash_notice"));
    if (logueoSatisfactorio) {
      WebElement lblLogueoSatisfactorio = driver
          .findElement(By.cssSelector("#content > p.flash_notice"));
      logueoSatisfactorio = lblLogueoSatisfactorio.getText()
          .equalsIgnoreCase("Signed in successfully.");
    }
    Assert.assertTrue("El usuario no se logueó satisfactoriamente", logueoSatisfactorio);
  }

  public void seleccionarNuevoRegistroEmpleado() {
    WebElement lnkNuevoRegistro = driver
        .findElement(By.cssSelector("#content > p > a[href='/employees/new']"));
    lnkNuevoRegistro.click();
  }

}
