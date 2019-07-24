package pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class CreacionUsuarioPage {

  private WebDriver driver;

  public CreacionUsuarioPage(WebDriver driver) {
    this.driver = driver;
  }

  public void ingresarNombreEmpleado(String nombreEmpleado) {
    WebElement txtNombreEmpleado = driver.findElement(By.id("employee_first_name"));
    txtNombreEmpleado.sendKeys(nombreEmpleado);
  }

  public void ingresarApellidoEmpleado(String apellidoEmpleado) {
    WebElement txtApellidoEmpleado = driver.findElement(By.id("employee_last_name"));
    txtApellidoEmpleado.sendKeys(apellidoEmpleado);
  }

  public void ingresarCorreoElectronicoEmpleado(String correoElectronico) {
    WebElement txtCorreoElectronicoEmpleado = driver.findElement(By.id("employee_email"));
    txtCorreoElectronicoEmpleado.sendKeys(correoElectronico);
  }

  public void ingresarIdentificacionEmpleado(String identificacion) {
    WebElement txtIdentificacionEmpleado = driver.findElement(By.id("employee_identification"));
    txtIdentificacionEmpleado.sendKeys(identificacion);
  }

  public void ingresarNombreLider(String nombreLider) {
    WebElement txtNombreLider = driver.findElement(By.id("employee_leader_name"));
    txtNombreLider.sendKeys(nombreLider);
  }

  public void ingresarFechaIngreso(String ano, int mes, String dia) {
    Select selAno = new Select(driver.findElement(By.id("employee_start_working_on_1i")));
    Select selMes = new Select(driver.findElement(By.id("employee_start_working_on_2i")));
    Select selDia = new Select(driver.findElement(By.id("employee_start_working_on_3i")));
    selAno.selectByVisibleText(ano);
    selMes.selectByIndex(mes-1);
    selDia.selectByVisibleText(dia);
  }

  public void crearRegistroEmpleado(){
    WebElement btnCrearEmpleado = driver
        .findElement(By.cssSelector("#new_employee > div.actions > input[type=submit]"));
    btnCrearEmpleado.click();
  }

}
