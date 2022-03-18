package tests;

import manager.MyDataProvider;
import org.slf4j.LoggerFactory;
import org.slf4j.Logger;
import models.User;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;



public class LoginTests extends TestBase{
    @BeforeMethod (alwaysRun = true)
    public void preConditionMethod(){
        if (app.getUserHelper().isLogged()){
            app.getUserHelper().logOut();
        }
    }
    @Test (dataProvider = "loginValidData",dataProviderClass = MyDataProvider.class,enabled = false)
    public void LoginPositiveTest(){
        logger.info("LoginPositiveTest");
        User user = new User().withEmail("od26il27@gmail.com").withPassword("Aa7166735");
        logger.info("LoginPositiveTest");

        //app.getUserHelper().fillLoginForm("noa@gmail.com", "Nnoa12345$");
        app.getUserHelper().openLoginForm();
        app.getUserHelper().fillLoginForm(user);
        app.getUserHelper().submitLogin();
        //find OK button
        //app.getUserHelper().okSubmit();
        // Assert.assertTrue(wd.findElement(By.xpath("//*[@href='/logout?url=%2Fsearch']")).isDisplayed());
        Assert.assertTrue(app.getUserHelper().isLogged());

    }

    @Test (dataProvider = "loginValidData",dataProviderClass = MyDataProvider.class,enabled = false)
    public void LoginPositiveTest2(){

        String eMail="od26il27@gmail.com";
        String password="Aa7166735";

        app.getUserHelper().openLoginForm();
        app.getUserHelper().fillLoginForm(eMail,password);
        app.getUserHelper().submitLogin();

        //app.getUserHelper().okSubmit();

        //Assert.assertTrue(isElementPresent(By.xpath("//*[@href='/logout?url=%2Fsearch']")));
        Assert.assertTrue(app.getUserHelper().isLogged());

    }


    @Test (enabled = false)
    public void LoginWrongPasswordTest(){
        String eMail="od26il27@gmail.com";
        String password="Aa71667";

        app.getUserHelper().openLoginForm();
        app.getUserHelper().fillLoginForm(eMail,password);
        app.getUserHelper().submitLogin();


        Assert.assertFalse(app.getUserHelper().isLogged());

    }
    @AfterMethod
    public void postCondition(){

        app.getUserHelper().okSubmit();
    }


}
