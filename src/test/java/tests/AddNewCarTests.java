package tests;

import manager.MyDataProvider;
import models.Car;
import models.User;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class AddNewCarTests extends TestBase {

    //is logged?--------------> precondition
    //open form
    //fill form + model Car
    //attach photo
    //submit

    @BeforeMethod
    public void precondition(){
        if(!app.getUserHelper().isLogged()){
            app.getUserHelper().login(new User().withEmail("od26il27@gmail.com").withPassword("Aa7166735"));
            app.getUserHelper().pause(5000);
            //logger.info("Car was added for user" + user.toString);
        }

    }
    @Test (invocationCount = 3)
    public void addNewCarPositive(){

        int countStart = app.getCar().countOfCars();
        logger.info("The test 'Add new contact starts with count of contact---->"+countStart );

        int i= (int)(System.currentTimeMillis()/1000)%3600;
//Car car = new Car().
        //Car car =Car.builder()
//             .address("Tel Aviv")
//             .build();
        Car car = new Car().withAddress("Tel-Aviv")
                .withMake("Audi")
                .withModel("Forester")
                .withYear("2019")
                .withEngine("2000")
                .withFuel("Petrol")
                .withGear("AT")
                .withWD("RWD")
                .withDoors("5")
                .withSeats("5")
                .withClasS("Luxury")
                .withFuelConsumption("10")
                .withCarRegNumber("1221025"+i)
                .withPrice("350")
                .withDistanceIncluded("500")
                .withTypeFeature("feature")
                .withAbout("very red");

        logger.info("Car was added" + car.toString());
        app.getCar().openCarForm();
        app.getCar().fillCarForm(car);
        app.getCar().attachedPhoto();
        app.getUserHelper().submitLogin();
        Assert.assertTrue(app.getCar().isCarAdded());
        app.getCar().clickSearch();


    }
}
