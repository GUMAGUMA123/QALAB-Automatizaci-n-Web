package com.nttdata.stepsdefinitions;

import com.nttdata.steps.MyStoreSteps;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;

import static com.nttdata.core.DriverManager.getDriver;
import static com.nttdata.core.DriverManager.screenShot;

public class MyStoreStepdefs {
    WebDriver driver;
    MyStoreSteps myStore;

    @Given("estoy en la página de la tienda")
    public void estoyEnLaPáginaDeLaTienda() {
        driver = getDriver();
        driver.get("https://qalab.bensg.com/store");
        screenShot();
        myStore = new MyStoreSteps(driver);
        myStore.iniciarSesion();
    }

    @And("me logueo con mi usuario {string} y clave {string}")
    public void meLogueoConMiUsuarioYClave(String usuario, String clave) {
        myStore = new MyStoreSteps(driver);
        myStore.typeUser(usuario);
        myStore.typePassword(clave);
        screenShot();
        myStore.login();
        screenShot();
    }

    @When("navego a la categoria {string} y subcategoria {string}")
    public void navegoALaCategoriaYSubcategoria(String clothes,String men) {
        myStore = new MyStoreSteps(driver);
        myStore.navegarCategoria(clothes);
        myStore.navegarSubCategoria();
        screenShot();
    }

    @And("agrego {int} unidades del primer producto al carrito")
    public void agregoUnidadesDelPrimerProductoAlCarrito(int cantidad) {
        myStore = new MyStoreSteps(driver);
        myStore.seleccionarProducto();
        screenShot();
        myStore.agregarCantidad(cantidad);
        screenShot();
        myStore.agregarCarrito();
        screenShot();
    }

    @Then("valido en el popup la confirmación del producto agregado")
    public void validoEnElPopupLaConfirmaciónDelProductoAgregado() {
        myStore = new MyStoreSteps(driver);
        myStore.validarPopup();
    }

    @And("valido en el popup que el monto total sea calculado correctamente")
    public void validoEnElPopupQueElMontoTotalSeaCalculadoCorrectamente() {
        myStore = new MyStoreSteps(driver);
        myStore.calcularMontoCorrecto();
    }

    @When("finalizo la compra")
    public void finalizoLaCompra() {
        myStore = new MyStoreSteps(driver);
        myStore.finalizarCompra();
        screenShot();
    }

    @Then("valido el titulo de la pagina del carrito")
    public void validoElTituloDeLaPaginaDelCarrito() {
        myStore = new MyStoreSteps(driver);
        myStore.validarTituloCarrito();
    }

    @And("vuelvo a validar el calculo de precios en el carrito")
    public void vuelvoAValidarElCalculoDePreciosEnElCarrito() {
        myStore = new MyStoreSteps(driver);
        myStore.calcularTotalCorrectoCarrito();
    }
}
