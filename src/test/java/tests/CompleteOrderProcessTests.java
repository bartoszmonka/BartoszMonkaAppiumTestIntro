package tests;

import io.qameta.allure.*;
import org.junit.jupiter.api.Test;
import screen.*;

public class CompleteOrderProcessTests extends TestBase {
    ProductsScreen productsScreen;

    @TmsLink("TC ID-1")
    @Severity(SeverityLevel.BLOCKER)
    @Test
    @Description("End-to-end test validating complete e-commerce checkout process from product selection to order completion")
    public void verifyCompleteCheckoutProcess() {
        productsScreen = new ProductsScreen(driver);
        addProductToCart();
        proceedToCheckoutAndFillShippingInfo();
        fillPaymentInfoAndProceedToReview();
        verifyOrderDetailsAndPlaceOrder();
        completeOrderAndReturnToProducts();
    }

    @Step("1. Add the product to the shopping cart. Confirm that the added product is displayed.")
    public void addProductToCart() {
        productsScreen.checkScreenTitle();
        productsScreen.tapOnProduct();

        ProductDetailsScreen productDetailsScreen = new ProductDetailsScreen(driver, productsScreen);
        productDetailsScreen.checkProductNameInHeader();
        productDetailsScreen.tapButtonAddToCart();
    }

    @Step("2. Open the shopping cart and continue. Fill in all required information fields.")
    public void proceedToCheckoutAndFillShippingInfo() {
        HeaderVidget headerVidget = new HeaderVidget(driver);
        headerVidget.tapOnCart();

        MyCartScreen myCartScreen = new MyCartScreen(driver, productsScreen);
        myCartScreen.checkScreenTitle();
        myCartScreen.checkProductName();
        myCartScreen.verifyProductQuantity();
        myCartScreen.tapButtonProceedToCheckout();

        LoginScreen loginScreen = new LoginScreen(driver);
        loginScreen.authenticateUserWhenRequired();

        EnterShippingAddressScreen enterShippingAddressScreen = new EnterShippingAddressScreen(driver);
        enterShippingAddressScreen.checkScreenTitle();
        enterShippingAddressScreen.fillShippingAddress();
        enterShippingAddressScreen.tapToPaymentButton();
    }

    @Step("3. Navigate to the payment screen. Enter payment information and proceed to order overview.")
    public void fillPaymentInfoAndProceedToReview() {
        EnterPaymentMethodScreen enterPaymentMethodScreen = new EnterPaymentMethodScreen(driver);
        enterPaymentMethodScreen.checkScreenTitle();
        enterPaymentMethodScreen.fillPaymentMethod();
        enterPaymentMethodScreen.tapReviewOrderButton();
    }

    @Step("4. Ensure the Checkout screen displays the correct order details.")
    public void verifyOrderDetailsAndPlaceOrder() {
        ReviewYourOrderScreen reviewYourOrderScreen = new ReviewYourOrderScreen(driver, productsScreen);
        reviewYourOrderScreen.checkScreenTitle();
        reviewYourOrderScreen.verifyProductName();
        reviewYourOrderScreen.tapPlaceOrderButton();
    }

    @Step("5. Place the Order and complete the purchase process.")
    public void completeOrderAndReturnToProducts() {
        CheckoutCompleteScreen checkoutCompleteScreen = new CheckoutCompleteScreen(driver);
        checkoutCompleteScreen.checkScreenTitle();
        checkoutCompleteScreen.tapContinueShoppingButton();
        productsScreen.checkScreenTitle();
    }
}
