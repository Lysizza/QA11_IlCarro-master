package manager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class HelperSearch extends HelperBase {
    public HelperSearch(WebDriver wd) {
        super(wd);
    }

    public void fillSearchFormCurrentMonth(String city, String dateFrom, String dateTo) {
        fillInputCity(city);
        selectPeriodCurrentMonth(dateFrom, dateTo);
    }

    public void selectPeriodCurrentMonth(String dateFrom, String dateTo) {
        //2/25/2022 - 2/28/2022 ----------> 25 - 28
        click(By.id("dates"));

        String []dataF = dateFrom.split("/"); // --------------->[2],[25],[2022]---get[1]
        String []dataT = dateTo.split("/"); //-------------->[2],[28],[2022]----get[1]

        String locator= "//div[text()=' " +dataF[1] +" ']"; //--------//div[text()=' 25 ']
        String loc =String.format("//div[text()=' %s ']",dataF[1]); // -----//div[text()=' 25 ']
        click(By.xpath(locator)); //25

        String locator2 = "//div[text()=' " + dataT[1] + " ']";
        click(By.xpath(locator2));
        pause(5000);


        //click(By.xpath("//div[text()=' 25 ']"));
        //click(By.xpath("//div[text()=' 28 ']"));
        //pause(5000);



    }

    private void fillInputCity(String city) {
        type(By.id("city"), city); //for formSearch id=city
        click(By.cssSelector(".pac-item"));
        pause(500);
    }

    public boolean isListOfCarsAppeared() {
        return isElementPresent(By.cssSelector(".search-results"));
    }

    public void returnToHome() {
        click(By.cssSelector(".header a[href='/']"));
    }

    public void fillSearchFormInFuture(String city, String from, String to) {
        fillInputCity(city);
        selectAnyData(from,to);
    }

    private void selectAnyData(String dataFrom, String dataTo) {
        //"3/30/2022", "6/25/2022"
        //"3/30/2022", "2/22/2023"
        //"1/10/2023", "2/22/2023"

        LocalDate from = LocalDate.parse(dataFrom, DateTimeFormatter.ofPattern("MM/dd/yyyy"));
        LocalDate to = LocalDate.parse(dataTo, DateTimeFormatter.ofPattern("MM/dd/yyyy"));
        LocalDate now = LocalDate.now();

        click(By.id("dates"));
        int monthDiff = from.getYear() - now.getYear()
                ==0 ? from.getMonthValue() - now.getMonthValue() : 12- now.getMonthValue() + from.getMonthValue();


        clickNextMonth(monthDiff);
        String dataLocator = String.format("//div[text()=' %s ']",from.getDayOfMonth());
        click(By.xpath(dataLocator));

        monthDiff = to.getYear() - from.getYear()
                ==0? to.getMonthValue()-from.getMonthValue() :12- from.getMonthValue()+to.getMonthValue();
        clickNextMonth(monthDiff);

        dataLocator = String.format("//div[text()=' %s ']",to.getDayOfMonth());
        click(By.xpath(dataLocator));
    }
    private void clickNextMonth (int count){
        for (int i = 0; i < count; i++){
    click(By.cssSelector("button[aria-label='Next month']"));
        }
    }

}
