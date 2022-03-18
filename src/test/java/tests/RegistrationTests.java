package tests;

import models.User;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class RegistrationTests extends TestBase{

    @BeforeMethod (alwaysRun = true)
    public void preConditionMethod(){
        if (app.getUserHelper().isLogged()){
            app.getUserHelper().logOut();
        }
    }

    @Test(groups = {"web"})
    public void registrationPositiveTest() {
        int i = (int) (System.currentTimeMillis() / 1000) % 3600;
       // User user = new User().withName("Lis").withLastname("Snow").withEmail("snow" + i + "gmail.com").withPassword("Ss12345$");
       String eMail = "od26il27" + i + "@gmail.com";
       String password = "Aa7166735";
       String name = "Lysizza";
       String lastName = "BlackSilver";
       System.out.println("Email: " + eMail);


        app.getUserHelper().openRegistrationForm();
        app.getUserHelper().fillRegForm(name,lastName,eMail,password);
        //app.getUserHelper().fillRegForm(user);
        app.getUserHelper().submitCheckBoxXY();
        app.getUserHelper().submitRegForm();
        app.getUserHelper().pause(3000);

    }
    @Test
    public void registrationPositiveTestModel() {
        int i = (int) (System.currentTimeMillis() / 1000) % 3600;
        User user = new User().withName("Fox").withLastname("RedFire").withEmail("fox" + i + "gmail.com").withPassword("Ff12345");
        // String eMail = "noa" + i + "@gmail.com";
        // String password = "Nnoa12345$";
        // String name = "Galina";
        // String lastName = "Petrovna";
        //System.out.println("Email: " + eMail);


        app.getUserHelper().openRegistrationForm();
        //app.getUserHelper().fillRegForm(name,lastName,eMail,password);
        app.getUserHelper().fillRegForm(user);
        app.getUserHelper().submitCheckBoxXY();
        app.getUserHelper().submitRegForm();

    }
    @AfterMethod
    public void postCondition(){
        app.getUserHelper().clickOkButton();
    }

}

