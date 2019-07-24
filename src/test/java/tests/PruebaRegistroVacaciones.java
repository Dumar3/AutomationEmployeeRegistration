package tests;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pageobjects.CreacionUsuarioPage;
import pageobjects.HomePage;
import pageobjects.LoginPage;

public class PruebaRegistroVacaciones {

  private WebDriver driver;
  HomePage homePage;

  @Before
  public void abrirPaginaVacaciones() {
    System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
    driver = new ChromeDriver();
    driver.get("https://vacations-management.herokuapp.com/users/sign_in");
  }

  @Test
  public void probarRegistroVacaciones() {
    homePage = new HomePage(driver);
    iniciarSesion();
    verificarLogueo();
    homePage.seleccionarNuevoRegistroEmpleado();
    crearUsuario();
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
    CreacionUsuarioPage creacionUsuarioPage = new CreacionUsuarioPage(driver);
    creacionUsuarioPage.ingresarNombreEmpleado("James");
    creacionUsuarioPage.ingresarApellidoEmpleado("Smith");
    creacionUsuarioPage.ingresarCorreoElectronicoEmpleado("jsmith@gap.com.co");
    creacionUsuarioPage.ingresarIdentificacionEmpleado("1234567890");
    creacionUsuarioPage.ingresarNombreLider("Dumar");
    creacionUsuarioPage.ingresarFechaIngreso("2014", 1, "21");
    creacionUsuarioPage.crearRegistroEmpleado();
  }

  @After
  public void cerrarAplicativo() {
    driver.close();
  }

}
