package pageobjects;

import java.util.Map;
import org.hamcrest.MatcherAssert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ListaUsuariosPage {

  private WebDriver driver;

  public ListaUsuariosPage(WebDriver driver) {
    this.driver = driver;
  }

  public void validarUsuarioCreado(Map<String, String> mapUsuario) {
    boolean empleadoRegistrado = true;
    WebElement tablaEmpleados = driver.findElement(By.xpath("//div[@id='content']/table/tbody"));
    WebElement lblNombreEmpleado = tablaEmpleados
        .findElement(By.xpath("./tr/td[text()='" + mapUsuario.get("nombreEmpleado") + "']"));
    WebElement lblApellidoEmpleado = tablaEmpleados
        .findElement(By.xpath("./tr/td[text()='" + mapUsuario.get("apellidoEmpleado") + "']"));
    WebElement lblIdentificacionEmpleado = tablaEmpleados
        .findElement(
            By.xpath("./tr/td[text()='" + mapUsuario.get("identificacionEmpleado") + "']"));
    WebElement lblNombreLider = tablaEmpleados
        .findElement(By.xpath("./tr/td[text()='" + mapUsuario.get("nombreLider") + "']"));
    if (!lblNombreEmpleado.isDisplayed() || !lblApellidoEmpleado.isDisplayed()
        || !lblIdentificacionEmpleado.isDisplayed() || !lblNombreLider.isDisplayed()) {
      empleadoRegistrado = false;
    }
    MatcherAssert.assertThat("El empleado no se registró correctamente", empleadoRegistrado);
  }

}
