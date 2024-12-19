package com.nttdata.steps;

import com.nttdata.page.MyStorePage;
import org.junit.Assert;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class MyStoreSteps {


    private WebDriver driver;

    public MyStoreSteps(WebDriver driver){
        this.driver = driver;
    }
    public void iniciarSesion() {
        this.driver.findElement(MyStorePage.inicioSeion).click();

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(MyStorePage.email));
    }

    public void typeUser(String usuario) {
        this.driver.findElement(MyStorePage.email).sendKeys(usuario);
    }

    public void typePassword(String clave) {
        this.driver.findElement(MyStorePage.password).sendKeys(clave);
    }

    public void login() {
        this.driver.findElement(MyStorePage.submitLogin).click();
    }

    public void navegarCategoria(String clothes) {
        this.driver.findElement(MyStorePage.clotes).click();
    }

    public void navegarSubCategoria( ) {
        this.driver.findElement(MyStorePage.men).click();
    }

    public void seleccionarProducto() {
        this.driver.findElement(MyStorePage.firstItem).click();
    }

    public void agregarCantidad(int cantidad) {
        this.driver.findElement(MyStorePage.cantidad).click();
    }

    public void agregarCarrito() {
        this.driver.findElement(MyStorePage.btnAgregarCarrito).click();
    }

    public void validarPopup() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
       String textPop = wait.until(ExpectedConditions.visibilityOfElementLocated(MyStorePage.textPopup)).getText();
        this.driver.findElement(MyStorePage.textPopup);

        //Eliminando caracter innecesarios
        String textoLimpio = textPop.replace("", "").trim();
        Assert.assertEquals("Producto añadido correctamente a su carrito de compra",textoLimpio);
    }

    public void calcularMontoCorrecto() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        //capturando valores del modal
        String precioProducto = wait.until(ExpectedConditions.visibilityOfElementLocated(MyStorePage.precioModal)).getText();
        String cantidadProducto = wait.until(ExpectedConditions.visibilityOfElementLocated(MyStorePage.cantidadModal)).getText();
        String montoTotal = wait.until(ExpectedConditions.visibilityOfElementLocated(MyStorePage.totalModal)).getText();

        // Limpiar y convertir a valores numéricos
        double dPrecio = Double.parseDouble(precioProducto.replace("PEN", "").replace("20% DE DESCUENTO", "").trim().replace(",", "."));
        int iCantidad = Integer.parseInt(cantidadProducto.trim());
        double dTotal = Double.parseDouble(montoTotal.replace("PEN", "").trim().replace(",", "."));

        //calculando el total esperado y validando
        double dTotalCalculado = dPrecio * iCantidad;
        Assert.assertEquals(dTotal,dTotalCalculado, 0.1);
    }

    public void finalizarCompra() {
        this.driver.findElement(MyStorePage.finalizarModal).click();
    }


    public void validarTituloCarrito() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        String carrito = wait.until(ExpectedConditions.visibilityOfElementLocated(MyStorePage.textCarrito)).getText();
        Assert.assertEquals("CARRITO",carrito);
    }

    public void calcularTotalCorrectoCarrito() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        //capturando valores del modal
        String precioProductoCarrito = wait.until(ExpectedConditions.visibilityOfElementLocated(MyStorePage.precioCarrito)).getText();
        String cantidadProductoCarrito = wait.until(ExpectedConditions.visibilityOfElementLocated(MyStorePage.cantidadCarrito)).getText();
        String montoTotalCarrito = wait.until(ExpectedConditions.visibilityOfElementLocated(MyStorePage.totalCarrito)).getText();

        // Limpiar y convertir a valores numéricos
        double dPrecio = Double.parseDouble(precioProductoCarrito.replace("PEN", "").trim().replace(",", "."));
        int iCantidad = Integer.parseInt(cantidadProductoCarrito.replace("artículos","").trim());
        double dTotal = Double.parseDouble(montoTotalCarrito.replace("PEN", "").trim().replace(",", "."));

        //calculando el total esperado y validando
        double dTotalCalculado = dPrecio * iCantidad;
        Assert.assertEquals(dTotal,dTotalCalculado, 0.1);

    }

}

