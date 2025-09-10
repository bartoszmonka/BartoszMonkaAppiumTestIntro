package tests;

import org.junit.jupiter.api.Test;
import screen.*;

public class CompleteOrderProcessTests extends TestBase {


    @Test

    public void verifyCompleteCheckoutProcess() {
        ProductsScreen productsScreen = new ProductsScreen(driver);
        productsScreen.checkScreenTitle();
        productsScreen.clickOnProduct();

        ProductDetailsScreen productDetailsScreen = new ProductDetailsScreen(driver, productsScreen);
        productDetailsScreen.checkProductNameInHeader();
        productDetailsScreen.tapButtonAddToCart();

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

        EnterPaymentMethodScreen enterPaymentMethodScreen = new EnterPaymentMethodScreen(driver);
        enterPaymentMethodScreen.checkScreenTitle();
        enterPaymentMethodScreen.fillPaymentMethod();
        enterPaymentMethodScreen.tapReviewOrderButton();

        ReviewYourOrderScreen reviewYourOrderScreen = new ReviewYourOrderScreen(driver, productsScreen);
        reviewYourOrderScreen.checkScreenTitle();
        reviewYourOrderScreen.verifyProductName();
        reviewYourOrderScreen.tapPlaceOrderButton();

        CheckoutCompleteScreen checkoutCompleteScreen = new CheckoutCompleteScreen(driver);
        checkoutCompleteScreen.checkScreenTitle();
        checkoutCompleteScreen.tapContinueShoppingButton();

        productsScreen.checkScreenTitle();

    }
}
