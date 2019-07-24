package pageobjects;

import org.hamcrest.MatcherAssert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class HomePage {

  private WebDriver driver;

  public HomePage(WebDriver driver) {
    this.driver = driver;
  }

  public void verificarLogo() {
    boolean logoVisible = false;
    WebElement imgLogo = driver.findElement(By.cssSelector("#logo"));
    if (imgLogo.isDisplayed()) {
      logoVisible = true;
    }
    MatcherAssert.assertThat("El logo no es visible", logoVisible);
  }

  public void verificarUsuarioLogueado() {
    boolean usuarioLogueado = false;
    WebElement lblUsuarioLogueado = driver
        .findElement(By.cssSelector("#user_information > span:first-child"));
    if (lblUsuarioLogueado.isDisplayed()) {
      usuarioLogueado = true;
    }
    MatcherAssert
        .assertThat("El usuario no está logueado", usuarioLogueado);
  }

  public void verificarLogueoSatisfactorio() {
    WebElement lblLogueoSatisfactorio = driver
        .findElement(By.cssSelector("#content > p.flash_notice"));
    MatcherAssert.assertThat("El usuario no se logueó satisfactoriamente",
        lblLogueoSatisfactorio.getText().equals("Signed in successfully."));
  }

  public void seleccionarNuevoRegistroEmpleado(){
    WebElement lnkNuevoRegistro = driver
        .findElement(By.cssSelector("#content > p > a[href='/employees/new']"));
    lnkNuevoRegistro.click();
  }

}
