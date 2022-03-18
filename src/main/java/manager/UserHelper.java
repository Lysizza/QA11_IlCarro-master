package manager;

import models.User;
import org.openqa.selenium.By;
import org.openqa.selenium.Rectangle;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class UserHelper extends HelperBase {

    public UserHelper(WebDriver wd) {
        super(wd);
    }

    public void openLoginForm() {

//        WebElement log=wd.findElement(By.linkText("Log in"));
//        log.click();
        click(By.xpath("//a[@href='/login?url=%2Fsearch']"));
    }


    public void fillLoginForm(String eMail, String password) {
        type(By.id("email"), eMail);
        type(By.id("password"), password);

    }
    public void fillLoginForm(User user) {
        type(By.id("email"), user.getEmail());
        type(By.id("password"), user.getPassword());

    }

    public void submitLogin() {
        //pause(2000);
        new WebDriverWait(wd,10).until(ExpectedConditions.elementToBeClickable(By.xpath("//button[@type='submit']")));
        click(By.xpath("//button[@type='submit']"));
    }


    public void okSubmit() {
        wd.findElement(By.xpath("//*[text()='Ok']")).click();
    }

    public void openRegistrationForm() {
        click(By.cssSelector("[href$='/registration?url=%2Fsearch']"));
    }


    public void fillRegForm(String name, String lastName, String eMail, String password) {
        type(By.id("name"), name);
        type(By.id("lastName"), lastName);
        type(By.id("email"), eMail);
        type(By.id("password"), password);
    }
    public void fillRegForm(User user) {
        type(By.id("name"), user.getName());
        type(By.id("lastName"), user.getLastname());
        type(By.id("email"), user.getEmail());
        type(By.id("password"), user.getPassword());
    }

    public void submitRegForm() {
        click(By.xpath("//button[@type='submit']"));
    }

    public void submitCheckBox() {
        click(By.xpath("//label[@for = 'terms-of-use']"));
        //   click(By.cssSelector("label.checkbox-label.terms-label::before"));
    }
    //if navigate to "term-of-use" is working
    public void submitCheckBoxXY() {
        WebElement label = wd.findElement(By.xpath("//label[@for = 'terms-of-use']"));
        Rectangle rectangle = label.getRect();
        Actions actions = new Actions(wd);
        actions.moveToElement(label).release().build().perform();

        int offSetX = rectangle.getWidth() / 2;
        int offSetY = rectangle.getHeight() / 2;

        actions.moveByOffset(-offSetX,-offSetY).click().release().build().perform();


        //   click(By.cssSelector("label.checkbox-label.terms-label::before"));
    }


    public boolean isLogged() {
        return isElementPresent(By.xpath("//a[contains(.,'Delete account')]"));
    }

    public void logOut() {
        click(By.xpath("//a[text()=' Logout ']")); //17.02.2022
    }

    public void clickOkButton(){
        if(isElementPresent(By.xpath("//button[text() ='Ok']"))){
            click(By.xpath("//button[text() ='Ok']"));
        }
        //wd.findElement(By.xpath("//*[text()='Ok']")).click();

    }


    public void login(User user) {
        openLoginForm();
        fillLoginForm(user);
        submitLogin();
        clickOkButton();
        pause(1000);

    }
}


