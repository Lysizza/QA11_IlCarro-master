package manager;

import models.Car;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CarHelper extends HelperBase {
    public CarHelper(WebDriver wd) {
        super(wd);
    }

    public void openCarForm() {
        click(By.id("1"));
    }

    public void fillCarForm(Car car) {
        if (isCarCreationFormPresent()) {
//typeLocation(By.id("pickUpPlace"),car.getAddress());
            typeLocation(car.getAddress());
            type(By.id("make"), car.getMake());
            type(By.id("model"), car.getModel());
            type(By.id("year"), car.getYear());
            type(By.id("engine"), car.getEngine());

            select(By.id("fuel"), car.getFuel());
            select(By.id("gear"), car.getGear());
            select(By.id("wheelsDrive"), car.getWD());

            type(By.id("doors"), car.getDoors());
            type(By.id("seats"), car.getSeats());
            type(By.id("class"), car.getClasS());
            type(By.id("fuelConsumption"), car.getFuelConsumption());
            type(By.id("serialNumber"), car.getCarRegNumber());
            type(By.id("price"), car.getPrice());
            type(By.id("distance"), car.getDistanceIncluded());
            // type(By.xpath("//input[@class='feature-input']"),car.getTypeFeature());
            type(By.cssSelector(".feature-input"), car.getTypeFeature());
            type(By.id("about"), car.getAbout());


        }
    }

    public void select(By locator, String option) {
        new Select(wd.findElement(locator)).selectByValue(option);
        // new Select(wd.findElement(locator)).selectByIndex(2);
        // new Select(wd.findElement(locator)).selectByVisibleText(" Petrol ");

    }

    private void typeLocation(String address) {
        type(By.id("pickUpPlace"), address); //for formSearch id=city
        click(By.cssSelector("div.pac-item"));
        pause(500);
    }

    boolean isCarCreationFormPresent() {
        Boolean isForm = new WebDriverWait(wd, 10)
                .until(ExpectedConditions
                        .textToBePresentInElement(wd.findElement(By.cssSelector("h2")), "Write some details about your car to rent it out"));
        System.out.println(wd.findElement(By.cssSelector("h2")).getText());
        return isForm;
    }

    public void attachedPhoto() {
        wd.findElement(By.id("photos")).sendKeys("D:\\Alisa AUTO\\pictures\\car2_audi.jpg");
    }

    public boolean isCarAdded() {
        //pause(2000);
        new WebDriverWait(wd, 10).until(ExpectedConditions.visibilityOf(wd.findElement(By.cssSelector(".dialog-container"))));
        return wd.findElement(By.cssSelector(".dialog-container h1")).getText().equals("Car added");
    }

    public void clickSearch() {
        click(By.xpath("//button[text()='Search cars']"));
    }


//    public int countOfCars() {
//        return wd.findElements(By.cssSelector(".cars-container")).size();//not count
//    }
//
//    public void providerOfCars() {
//        if (countOfCars() < 3) {
//            int index = (int) (System.currentTimeMillis() / 1000) % 3600;
//            for (int i = 0; i < 3; i++) {
//
//                Car car = new Car().withAddress("Haifa")
//                        .withMake("Audi")
//                        .withModel("4T")
//                        .withYear("2019")
//                        .withEngine("2000")
//                        .withFuel("Petrol")
//                        .withGear("AT")
//                        .withWD("RWD")
//                        .withDoors("5")
//                        .withSeats("5")
//                        .withClasS("Luxury")
//                        .withFuelConsumption("10")
//                        .withCarRegNumber("12210101" + i)
//                        .withPrice("350")
//                        .withDistanceIncluded("500")
//                        .withTypeFeature("feature")
//                        .withAbout("very nice");
//                openCarForm();
//                fillCarForm(car);
//                isCarAdded();
//                pause(1000);
//            }
//        }
//    }
}





