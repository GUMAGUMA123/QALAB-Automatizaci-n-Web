package com.nttdata.page;

import org.openqa.selenium.By;

public class MyStorePage {
    public static By inicioSeion = By.xpath("//a[@href='https://qalab.bensg.com/store/es/iniciar-sesion?back=https%3A%2F%2Fqalab.bensg.com%2Fstore%2Fes%2F']");
    public static By submitLogin = By.id("submit-login");
    public static By password = By.id("field-password");
    public static By email = By.id("field-email");
    public static By clotes = By.xpath("//a[@href='https://qalab.bensg.com/store/es/3-clothes']");
    public static By men = By.xpath("//*[@id=\"left-column\"]/div[1]/ul/li[2]/ul/li[1]/a");
    public static By firstItem = By.xpath("//*[@id=\"js-product-list\"]/div[1]/div/article/div/div[1]/a/picture/img");
    public static By cantidad = By.xpath("//*[@id=\"add-to-cart-or-refresh\"]/div[2]/div/div[1]/div/span[3]/button[1]");
    public static By btnAgregarCarrito = By.xpath("//*[@id=\"add-to-cart-or-refresh\"]/div[2]/div/div[2]/button");
    public static By textPopup = By.xpath("//*[@id=\"myModalLabel\"]");
    public static By precioModal = By.className("product-price");
    public static By cantidadModal = By.xpath("//*[@id=\"blockcart-modal\"]/div/div/div[2]/div/div[1]/div/div[2]/span[3]/strong");
    public static By totalModal =By.xpath("//*[@id=\"blockcart-modal\"]/div/div/div[2]/div/div[2]/div/p[4]/span[2]");
    public static By finalizarModal =By.xpath("//*[@id=\"blockcart-modal\"]/div/div/div[2]/div/div[2]/div/div/a");
    public static By textCarrito = By.xpath("//*[@id=\"main\"]/div/div[1]/div/div[1]/h1");
    public static By precioCarrito = By.xpath("//*[@id=\"main\"]/div/div[1]/div/div[2]/ul/li/div/div[2]/div[2]/div[2]/span");
    public static By cantidadCarrito = By.xpath("//*[@id=\"cart-subtotal-products\"]/span[1]");
    public static By totalCarrito = By.xpath("//*[@id=\"main\"]/div/div[2]/div[1]/div[1]/div[2]/div[2]/span[2]");
    public static By errorAutentificacion = By.xpath("//*[@id=\"content\"]/section/div/ul/li");
}
