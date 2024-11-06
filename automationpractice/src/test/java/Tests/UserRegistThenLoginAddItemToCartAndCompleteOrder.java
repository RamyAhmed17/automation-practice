package Tests;

import Pages.*;
import org.testng.Assert;
import org.testng.annotations.Test;


public class UserRegistThenLoginAddItemToCartAndCompleteOrder extends TestBase {
    HomePage homePage;
    CreateNewAccount createNewAccount;
    RegisterPage setTheData;
    SignInPage signInPage;
    ProductPage product;
    ShoppingCartPage order;
    MyAccountPage myAccountPage;
    OrderHistoryPage ordersHistory;


    @Test( dataProvider = "valid-user-credentials", dataProviderClass = dataProvider.DataProviders.class )
    public void userRegistAndBuyAProduct(String email, String fname, String lname, String passwd,
                                         String addres, String city, String state, String zip,
                                         String mobile) throws InterruptedException {
        homePage = new HomePage(driver);
        signInPage = new SignInPage(driver);
        product = new ProductPage(driver);
        order = new ShoppingCartPage(driver);
        ordersHistory = new OrderHistoryPage(driver);
        myAccountPage = new MyAccountPage(driver);
        createNewAccount = new CreateNewAccount(driver);
        setTheData = new RegisterPage(driver);
        signInPage = new SignInPage(driver);

        //userCreateAnewAccountAndLogin
        createNewAccount.create(email);
        System.out.println(createNewAccount.rigesteredBeforeOrNot());
        Assert.assertTrue(createNewAccount.rigesteredBeforeOrNot().contains("INFORMATION"), "This Email is used before");
        setTheData.userregister(fname, lname, passwd, addres, city, state, zip, mobile);
        System.out.println(signInPage.accountInformation());
        Assert.assertTrue(signInPage.accountInformation().contains(signInPage.logoutText()));
        signInPage.userCanlogout();
        homePage.clickSignIn();
        signInPage.userSignIn(email, passwd);
        Assert.assertTrue(signInPage.accountInformation().contains(signInPage.logoutText()));

        //userSelectBlousesAndAddProductToCart
        homePage.selectBlousesByHoverWomenMenu();
        Assert.assertTrue(product.checkYouInBlousesPage().contains("Blouses"));
        product.addToCart();
        product.proceedToCheckOut();
        Assert.assertTrue(order.checkBlouseIsAddedToCart().contains("Blouse"), "your product Not in Cart");

        //userCheckoutAndConfirmOrderBySelectingBankWireOption
        order.userFinalCheckout();
        Assert.assertTrue(order.typeOfPayment.contains("BANK-WIRE"), "Type of payment not a Bank Wire");
        order.userFinalConfirmation();

        //orderPlacedAndDisplayedInOrderHistoryPage
        homePage.clickMyAccount();
        myAccountPage.openOrderPage();
        Assert.assertTrue(order.detailsOfMyOrder().contains(ordersHistory.lastOrderReference())
                , "Your Order Didn't complete correctly");
        signInPage.userCanlogout();
    }
}