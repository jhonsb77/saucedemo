package stepsdefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.PurchasePage;

public class PurchaseDefinitions {

    PurchasePage purchasePage;

    @Given("that an user is on login page")
    public void thatAnUserIsOnLoginPage() {
        purchasePage.open();
    }

    @When("he login with account {string} {string}")
    public void heLoginWithAccount(String user, String pass) {
        purchasePage.heLoginWithAccount(user,pass);
    }

    @When("he select an article {string}")
    public void heSelectAnArticle(String article) {
        purchasePage.heSelectAnArticle(article);
    }

    @When("he confirm order on shopping cart")
    public void heConfirmOrderOnShoppingCart() {
        purchasePage.heConfirmOrderOnShoppingCart();
    }

    @When("he enter the purchase information {string} {string} {string}")
    public void heEnterThePurchaseInformation(String firstName, String lastName, String postalCode){
        purchasePage.heEnterThePurchaseInformation(firstName,lastName,postalCode);
    }

    @When("He verifies the total of the purchase")
    public void heVerifiesTheTotalOfThePurchase(){
        purchasePage.heVerifiesTheTotalOfThePurchase();
    }

    @Then("he should be to see confirm purchase message")
    public void heShouldBeToSeeConfirmPurchaseMessage() {
        purchasePage.heShouldBeToSeeConfirmPurchaseMessage();
    }

}
