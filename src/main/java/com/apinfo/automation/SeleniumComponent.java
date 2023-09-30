package com.apinfo.automation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;
//@Component
@Service
public class SeleniumComponent {

    private final WebDriver driver;
    Action builder;
    WebDriverWait wait;
    WebElement element;

    JavascriptExecutor js;
    int cnt =0;

    @Autowired
    public SeleniumComponent(WebDriver webDriver) {
        this.driver = webDriver;
    }


    @Bean
    public void performSeleniumOperations() {
        System.out.println("In the performSeleniumOperations ");
//        this.doit();
    }

//    @Bean
    public void doit(){
        System.out.println("In the doit ");
        driver.get("https://fids.airport.ir/");

        // Close the browser
//        webDriver.quit();

    }
    public void onlyLog(){
        System.out.println("This is onlyLog");
    }

    public void google(){

        driver.get("https://www.google.com");

        // Get the page title
        String pageTitle = driver.getTitle();

        WebElement searchInput = driver.findElement(By.name("q"));

        // Type the keywords to search for
        searchInput.sendKeys("Selenium WebDriver");

        // Press Enter to perform the search
        searchInput.sendKeys(Keys.ENTER);

        // Wait for the search results to load
        // You may need to add an explicit wait here to ensure the results are loaded

        // Extract the search results
        WebElement searchResults = driver.findElement(By.name("btnK"));

        // Print the search results to the console
        System.out.println(searchResults.getText());
    }

    ////////////////////////////////////////////////////////////

    public void filghtStatus() {
        driver.get("https://fids.airport.ir/");
        wait = new WebDriverWait(driver, Duration.ofSeconds(5L));

        driver.findElement(By.xpath("/html[1]/body[1]/div[2]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/nav[1]/ul[1]/li[1]/a[1]")).sendKeys(Keys.RETURN);
        wait = new WebDriverWait(driver, Duration.ofSeconds(5L));

        List<WebElement> listAirports = driver.findElements(By.xpath("/html[1]/body[1]/div[2]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/nav[1]/ul[1]/li"));
        System.out.println("-listAirports --> "+listAirports.size());

        String airportName = "";
        long startTime = System.nanoTime();
//		for(int i =0 ; i < listAirports.size(); i++){
            int i=0;
            try {

                driver.findElement(By.xpath("/html[1]/body[1]/div[2]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/nav[1]/ul[1]/li[" + (i + 1) + "]/a[1]")).sendKeys(Keys.RETURN);
                wait = new WebDriverWait(driver, Duration.ofSeconds(5L));
                airportName = driver.findElement(By.xpath("/html[1]/body[1]/div[2]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/nav[1]/ul[1]/li[" + (i + 1) + "]/a[1]")).getText();
                System.out.println("*** " + (i + 1) + " - " + airportName);

                domesticArrivals();
                //		domesticDepartures();
                //
                //			internationlArrivals();
                //			internationlDepartures();
            }catch (StaleElementReferenceException e) {
                System.out.println("try *** StaleElementReferenceException");
                try {
                    // Delay the execution for 3 seconds
                    Thread.sleep(3000);
                } catch (InterruptedException ex) {
                    e.printStackTrace();
                }
                i--;
            }catch (NoSuchElementException e) {
                System.out.println("try *** NoSuchElementException ");
                try {
                    // Delay the execution for 3 seconds
                    Thread.sleep(3000);
                } catch (InterruptedException ex) {
                    e.printStackTrace();
                }
                i--;
            }catch (StringIndexOutOfBoundsException e) {
                System.out.println("try *** StringIndexOutOfBoundsException ");
                try {
                    // Delay the execution for 3 seconds
                    Thread.sleep(3000);
                } catch (InterruptedException ex) {
                    e.printStackTrace();
                }
                i--;
            }
//		}
        long endTime = System.nanoTime();
        long duration = (endTime - startTime);  //divide by 1000000 to get milliseconds.
        System.out.println("++ time "+(duration/1000000) + " ms");
//		domesticArrivals();
//		domesticDepartures();
//		internationlArrivals();
//		internationlDepartures();

        System.out.println("###### total "+cnt);
    }

    private void internationlDepartures(){
        if(driver.findElements(By.xpath(Constant.INTERNATIONAL_DEPARTURES)).size()>0){
            driver.findElement(By.xpath(Constant.INTERNATIONAL_DEPARTURES)).sendKeys(Keys.RETURN);
            wait = new WebDriverWait(driver, Duration.ofSeconds(5L));
            departuresBoard();
        }
    }

    private void internationlArrivals(){
        if(driver.findElements(By.xpath(Constant.INTERNATIONAL_ARRIVALS)).size()>0){
            driver.findElement(By.xpath(Constant.INTERNATIONAL_ARRIVALS)).sendKeys(Keys.RETURN);
            wait = new WebDriverWait(driver, Duration.ofSeconds(5L));
            arrivalsBoard();
        }
    }

    private void domesticDepartures(){
        driver.findElement(By.xpath(Constant.DOMESTIC_DEPARTURES)).sendKeys(Keys.RETURN);
        wait = new WebDriverWait(driver, Duration.ofSeconds(5L));
        departuresBoard();
    }

    private void domesticArrivals(){
        driver.findElement(By.xpath(Constant.DOMESTIC_ARRIVALS)).sendKeys(Keys.RETURN);
        wait = new WebDriverWait(driver, Duration.ofSeconds(5L));
        arrivalsBoard();
    }

    private void departuresBoard(){
        try {
            // Delay the execution for 3 seconds
            Thread.sleep(3000);
        } catch (InterruptedException ex) {
            ex.printStackTrace();
        }
        List<WebElement> listDepartures = driver.findElements(By.xpath("//div[@class='tabcontent' and @style='display: block;']/table[1]/tbody[1]/tr"));
        System.out.println("listDeparture size is --- > "+listDepartures.size());
        String dateTime,counter,day,airline,fno,dest,status,aircraft,date;
        for(int i =0 ; i < listDepartures.size(); i++){
            try {
                cnt++;
                System.out.println("========================== " + (i + 1));
                day = "";
                airline = "";
                fno = "";
                status = "";
                aircraft = "";
                date = "";
                dateTime = "";
                counter = "";
                day = driver.findElement(By.xpath("//div[@class='tabcontent' and @style='display: block;']/table[1]/tbody[1]/tr[" + (i + 1) + "]/td[@class='cell-day']")).getText();
                airline = driver.findElement(By.xpath("//div[@class='tabcontent' and @style='display: block;']/table[1]/tbody[1]/tr[" + (i + 1) + "]/td[@class='cell-airline']")).getText();
                fno = driver.findElement(By.xpath("//div[@class='tabcontent' and @style='display: block;']/table[1]/tbody[1]/tr[" + (i + 1) + "]/td[@class='cell-fno']")).getText();
                dest = "";// driver.findElement(By.xpath("//div[@class='tabcontent' and @style='display: block;']/table[1]/tbody[1]/tr[" + (i + 1) + "]/td[@class='cell-dest']")).getText();
                status = driver.findElement(By.xpath("//div[@class='tabcontent' and @style='display: block;']/table[1]/tbody[1]/tr[" + (i + 1) + "]/td[@class='cell-status']")).getText();
                if (driver.findElements(By.xpath("//div[@class='tabcontent' and @style='display: block;']/table[1]/tbody[1]/tr[" + (i + 1) + "]/td[@class='cell-counter']")).size() > 0)
                    counter = driver.findElement(By.xpath("//div[@class='tabcontent' and @style='display: block;']/table[1]/tbody[1]/tr[" + (i + 1) + "]/td[@class='cell-counter']")).getText();

                if (driver.findElements(By.xpath("//div[@class='tabcontent' and @style='display: block;']/table[1]/tbody[1]/tr[" + (i + 1) + "]/td[@class='cell-dateTime2']")).size() > 0)
                    dateTime = driver.findElement(By.xpath("//div[@class='tabcontent' and @style='display: block;']/table[1]/tbody[1]/tr[" + (i + 1) + "]/td[@class='cell-dateTime2']")).getText();

                if (driver.findElements(By.xpath("//div[@class='tabcontent' and @style='display: block;']/table[1]/tbody[1]/tr[" + (i + 1) + "]/td[@class='cell-dateTime3']")).size() > 0)
                    dateTime = driver.findElement(By.xpath("//div[@class='tabcontent' and @style='display: block;']/table[1]/tbody[1]/tr[" + (i + 1) + "]/td[@class='cell-dateTime3']")).getText();

                aircraft = driver.findElement(By.xpath("//div[@class='tabcontent' and @style='display: block;']/table[1]/tbody[1]/tr[" + (i + 1) + "]/td[@class='cell-aircraft']")).getText();
                date = driver.findElement(By.xpath("//div[@class='tabcontent' and @style='display: block;']/table[1]/tbody[1]/tr[" + (i + 1) + "]/td[@class='cell-date']")).getText();
                System.out.println("day --> " + day);
                System.out.println("airline --> " + airline);
                System.out.println("fno --> " + fno);
                System.out.println("dest --> " + dest);
                System.out.println("status --> " + status);
                System.out.println("counter --> " + counter);
                System.out.println("dateTime --> " + dateTime);
                System.out.println("aircraft --> " + aircraft);
                System.out.println("date --> " + date);
            }catch (StaleElementReferenceException e) {
                System.out.println("try agein *** StaleElementReferenceException");
                try {
                    // Delay the execution for 3 seconds
                    Thread.sleep(3000);
                } catch (InterruptedException ex) {
                    e.printStackTrace();
                }
                i--;
            }catch (NoSuchElementException e) {
                System.out.println("try agein *** NoSuchElementException ");
                try {
                    // Delay the execution for 3 seconds
                    Thread.sleep(3000);
                } catch (InterruptedException ex) {
                    e.printStackTrace();
                }
                i--;
            }catch (StringIndexOutOfBoundsException e) {
                System.out.println("try agein *** StringIndexOutOfBoundsException ");
                try {
                    // Delay the execution for 3 seconds
                    Thread.sleep(3000);
                } catch (InterruptedException ex) {
                    e.printStackTrace();
                }
                i--;
            }

        }

    }
    private void arrivalsBoard(){
        try {
            // Delay the execution for 3 seconds
            Thread.sleep(3000);
        } catch (InterruptedException ex) {
            ex.printStackTrace();
        }
        List<WebElement> listArrivals = driver.findElements(By.xpath("//div[@class='tabcontent' and @style='display: block;']/table[1]/tbody[1]/tr"));
        System.out.println("listArrivals size is --- > "+listArrivals.size());
        String day,airline,fno,origin,status,aircraft,aircraft2,aircraft3;
        String arDayEn,arDayFa,arTime;

//		for(int i =0 ; i < listArrivals.size(); i++){
            int i =0 ;
            try {
                cnt++;
                System.out.println("========================== " + (i + 1));
                day = "";
                airline = "";
                origin = "";
                status = "";
                aircraft = "";
                aircraft2 = "";
                aircraft3 = "";
                day = driver.findElement(By.xpath("//div[@class='tabcontent' and @style='display: block;']/table[1]/tbody[1]/tr[" + (i + 1) + "]/td[@class='cell-day']")).getText();
                airline = driver.findElement(By.xpath("//div[@class='tabcontent' and @style='display: block;']/table[1]/tbody[1]/tr[" + (i + 1) + "]/td[@class='cell-airline']")).getText();
                fno = driver.findElement(By.xpath("//div[@class='tabcontent' and @style='display: block;']/table[1]/tbody[1]/tr[" + (i + 1) + "]/td[@class='cell-fno']")).getText();
                origin = driver.findElement(By.xpath("//div[@class='tabcontent' and @style='display: block;']/table[1]/tbody[1]/tr[" + (i + 1) + "]/td[@class='cell-orig']")).getText();
                status = driver.findElement(By.xpath("//div[@class='tabcontent' and @style='display: block;']/table[1]/tbody[1]/tr[" + (i + 1) + "]/td[@class='cell-status']")).getText();
                aircraft = driver.findElement(By.xpath("//div[@class='tabcontent' and @style='display: block;']/table[1]/tbody[1]/tr[" + (i + 1) + "]/td[@class='cell-aircraft']")).getText();
                aircraft2 = driver.findElement(By.xpath("//div[@class='tabcontent' and @style='display: block;']/table[1]/tbody[1]/tr[" + (i + 1) + "]/td[@class='cell-aircraft2']")).getText();
                aircraft3 = driver.findElement(By.xpath("//div[@class='tabcontent' and @style='display: block;']/table[1]/tbody[1]/tr[" + (i + 1) + "]/td[@class='cell-aircraft3']")).getText();

                arDayEn = Constant.DAY_EN.get(day.substring(0, day.length() - 6).trim());
                arDayFa = day.substring(0, day.length() - 6);
                arTime = day.substring(day.length() - 4, day.length());
                airline = Constant.AIRLINE.get(airline);
                origin = Constant.AIRPORT.get(origin);
                status = Constant.STATUS.get(status);

                System.out.println("day --> " + day);
                System.out.println("day split--> " + day.substring(day.length() - 4, day.length()));
                System.out.println("day split--> " + day.substring(0, day.length() - 6));
                System.out.println("day split--> " + Constant.DAY_EN.get(day.substring(0, day.length() - 6).trim()));
                System.out.println("airline --> " + airline);
                System.out.println("fno --> " + fno);
                System.out.println("origin --> " + origin);
                System.out.println("status --> " + status);
                System.out.println("aircraft --> " + aircraft);
                System.out.println("aircraft2 --> " + aircraft2);
                System.out.println("aircraft3 --> " + aircraft3);
            }catch (StaleElementReferenceException e) {
                System.out.println("try *** StaleElementReferenceException");
                try {
                    // Delay the execution for 3 seconds
                    Thread.sleep(3000);
                } catch (InterruptedException ex) {
                    e.printStackTrace();
                }
                i--;
            }catch (NoSuchElementException e) {
                System.out.println("try *** NoSuchElementException ");
                try {
                    // Delay the execution for 3 seconds
                    Thread.sleep(3000);
                } catch (InterruptedException ex) {
                    e.printStackTrace();
                }
                i--;
            }catch (StringIndexOutOfBoundsException e) {
                System.out.println("try *** StringIndexOutOfBoundsException ");
                try {
                    // Delay the execution for 3 seconds
                    Thread.sleep(3000);
                } catch (InterruptedException ex) {
                    e.printStackTrace();
                }
                i--;
            }
//		}  //end of FOR

    }



}
