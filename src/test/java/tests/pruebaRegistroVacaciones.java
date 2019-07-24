package tests;

import org.junit.Test;
import steps.LoginStep;

public class pruebaRegistroVacaciones {

  LoginStep loginStep = new LoginStep();

  @Test
  public void probarRegistroVacaciones(){
    loginStep.iniciarSesion();
  }


}
