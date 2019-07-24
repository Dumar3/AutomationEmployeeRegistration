package steps;

import pages.LoginPage;

public class LoginStep {

LoginPage loginPage = new LoginPage();

public void iniciarSesion(){
  loginPage.abrirPaginaVacaciones();
  loginPage.escribirCorreoElectronico("gap-automation-test@mailinator.com");
  loginPage.escribirContrasena("12345678");
  loginPage.ingresarPaginaInicio();
}

}
