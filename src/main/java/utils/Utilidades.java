package utils;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;

public class Utilidades {

  private WebDriver driver;

  public Utilidades(WebDriver driver) {
    this.driver = driver;
  }

  public boolean verificarElementoPresente(By localizador) {
    try {
      driver.findElement(localizador);
      return true;
    } catch (NoSuchElementException e) {
      return false;
    }
  }

}
