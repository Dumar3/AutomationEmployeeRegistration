package tests;

import java.util.HashMap;
import java.util.Map;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pageobjects.CreacionUsuarioPage;
import pageobjects.HomePage;
import pageobjects.ListaUsuariosPage;
import pageobjects.LoginPage;

public class PruebaRegistroVacaciones {

  private WebDriver driver;
  private HomePage homePage;
  private CreacionUsuarioPage creacionUsuarioPage;

  @Before
  public void abrirPaginaVacaciones() {
    System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
    driver = new ChromeDriver();
    driver.get("https://vacations-management.herokuapp.com/users/sign_in");
  }

  @Test
  public void probarRegistroVacaciones() {
    homePage = new HomePage(driver);
    creacionUsuarioPage = new CreacionUsuarioPage(driver);
    iniciarSesion();
    verificarLogueo();
    homePage.seleccionarNuevoRegistroEmpleado();
    crearUsuario();
    creacionUsuarioPage.regresarListaEmpleados();
    validarUsuarioCreado();
  }

  private void iniciarSesion() {
    LoginPage loginPage = new LoginPage(driver);
    loginPage.escribirCorreoElectronico("gap-automation-test@mailinator.com");
    loginPage.escribirContrasena("12345678");
    loginPage.ingresarPaginaInicio();
  }

  private void verificarLogueo() {
    homePage.verificarLogo();
    homePage.verificarUsuarioLogueado();
    homePage.verificarLogueoSatisfactorio();
  }

  private void crearUsuario() {
    creacionUsuarioPage.ingresarNombreEmpleado("James");
    creacionUsuarioPage.ingresarApellidoEmpleado("Smith");
    creacionUsuarioPage.ingresarCorreoElectronicoEmpleado("jsmith@gap.com.co");
    creacionUsuarioPage.ingresarIdentificacionEmpleado("1234567890");
    creacionUsuarioPage.ingresarNombreLider("Dumar");
    creacionUsuarioPage.ingresarFechaIngreso("2014", 1, "21");
    creacionUsuarioPage.crearRegistroEmpleado();
  }

  private void validarUsuarioCreado(){
    ListaUsuariosPage listaUsuariosPage = new ListaUsuariosPage(driver);
    Map<String, String> mapUsuario = new HashMap<>();
    mapUsuario.put("nombreEmpleado", "James");
    mapUsuario.put("apellidoEmpleado", "Smith");
    mapUsuario.put("identificacionEmpleado", "1234567890");
    mapUsuario.put("nombreLider", "Dumar");
    listaUsuariosPage.validarUsuarioCreado(mapUsuario);
  }

  @After
  public void cerrarAplicativo() {
    driver.close();
  }

}
