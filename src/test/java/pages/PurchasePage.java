package pages;

import net.serenitybdd.core.Serenity;
import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.support.ui.ExpectedConditions;
import java.time.Duration;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.Assert.fail;

public class PurchasePage extends PageObject {

    public static String art;

    @FindBy(id = "user-name")
    WebElementFacade txtUser;

    @FindBy(id = "password")
    WebElementFacade txtPass;

    @FindBy(id = "login-button")
    WebElementFacade btnLogin;

    @FindBy(xpath = "//button[text()='Add to cart']")
    WebElementFacade btnAddCart;

    @FindBy(className = "shopping_cart_link")
    WebElementFacade btnCart;

    @FindBy(id = "checkout")
    WebElementFacade btnCheckout;

    @FindBy(id = "first-name")
    WebElementFacade txtFirstName;

    @FindBy(id = "last-name")
    WebElementFacade txtLastName;

    @FindBy(id = "postal-code")
    WebElementFacade txtPostalCode;

    @FindBy(id = "continue")
    WebElementFacade btnContinue;

    @FindBy(xpath = "//div[text()='Payment Information']")
    WebElementFacade lblPaymentInformation;

    @FindBy(xpath = "//div[text()='Shipping Information']")
    WebElementFacade lblShippingInformation;

    @FindBy(xpath = "//div[text()='Price Total']")
    WebElementFacade lblPriceTotal;

    @FindBy(xpath = "//div[text()='Total: $']")
    WebElementFacade lblTotal;

    @FindBy(id = "finish")
    WebElementFacade btnFinish;

    @FindBy(xpath = "//*[@class='complete-header']")
    WebElementFacade lblThankOrder;


    public void heLoginWithAccount(String user, String pass) {
        waitFor(ExpectedConditions.titleIs("Swag Labs"));
        txtUser.typeAndTab(user);
        txtPass.typeAndTab(pass);
        btnLogin.click();
    }

    public void heSelectAnArticle(String article) {
        waitFor(ExpectedConditions.titleIs("Swag Labs"));
        try{
            art = article;
            WebElementFacade btnArticle = find(By.xpath("//div[text()='" + article + "']"));
            if(!btnArticle.isPresent()){
                posicionarObjeto(btnArticle);
            }
            btnArticle.click();
        }catch (Exception e){
            e.printStackTrace();
            fail("no existe el producto a comprar");
        }
        withTimeoutOf(Duration.ofSeconds(5)).waitFor(btnAddCart);
        btnAddCart.click();
    }

    public void heConfirmOrderOnShoppingCart() {
        btnCart.click();
        waitFor(ExpectedConditions.titleIs("Swag Labs"));
        if(find(By.xpath("//div[text()='"+art+"']")).isPresent()){
            System.out.println("articulo presente en el carrito");
        }else{
            fail("fallo en agregar el articulo al carrito");
        }
        btnCheckout.click();
    }

    public void heEnterThePurchaseInformation(String firstName, String lastName, String postalCode){
        withTimeoutOf(Duration.ofSeconds(5)).waitFor(txtFirstName);
        txtFirstName.typeAndTab(firstName);
        txtLastName.typeAndTab(lastName);
        txtPostalCode.typeAndTab(postalCode);
        btnContinue.click();
    }

    public void heVerifiesTheTotalOfThePurchase(){
        if(!lblPaymentInformation.isPresent() && !lblShippingInformation.isPresent() &&
                !lblPriceTotal.isPresent() && !lblTotal.isPresent()){
            fail("los datos de la confirmacion de compra no estan completos");
        }
        posicionarObjeto(btnFinish);
        btnFinish.click();
    }

    public void heShouldBeToSeeConfirmPurchaseMessage() {
        waitFor(ExpectedConditions.titleIs("Swag Labs"));
        assertThat("Error al completar la orden ",
                lblThankOrder.getText().equals("Thank you for your order!"));
        Serenity.recordReportData().withTitle("Orden completada con exito")
                .andContents(lblThankOrder.getText());
    }

    public void posicionarObjeto(WebElementFacade element){
        JavascriptExecutor js = (JavascriptExecutor) getDriver();
        WebElementFacade elementFacade =
                (WebElementFacade) js.executeScript("arguments[0].scrollIntoView(true);", element);
    }

}
