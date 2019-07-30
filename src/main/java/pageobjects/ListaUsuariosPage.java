package pageobjects;

import java.util.Map;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import utils.Utilidades;

public class ListaUsuariosPage {

  private WebDriver driver;

  public ListaUsuariosPage(WebDriver driver) {
    this.driver = driver;
  }

  public void validarUsuarioCreado(Map<String, String> mapUsuario) {
    Utilidades utilidades = new Utilidades(driver);
    Assert.assertTrue("El empleado no se registró correctamente", utilidades.verificarElementoPresente(By.xpath(
        "//*[@id='content']/table/tbody/tr[td[1][text()='" + mapUsuario
            .get("nombreEmpleado") + "'] and td[2][text()='" + mapUsuario
            .get("apellidoEmpleado") + "'] and td[3][text()='" + mapUsuario
            .get("identificacionEmpleado") + "'] and td[4][text()='" + mapUsuario
            .get("nombreLider") + "']]")));
  }

}
