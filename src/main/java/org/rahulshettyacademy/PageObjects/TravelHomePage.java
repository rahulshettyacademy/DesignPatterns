package org.rahulshettyacademy.PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.rahulshettyacademy.AbstractComponents.SearchFlightAvail;
import org.rahulshettyacademy.AbstractComponents.StrategyFactor;
import org.rahulshettyacademy.PageComponents.FooterNav;
import org.rahulshettyacademy.PageComponents.NavigationBar;

import java.util.HashMap;

public class TravelHomePage {
    By sectionElement = By.id("traveller-home");
    By footerNavSectionElement = By.id("buttons");
    WebDriver driver;
    SearchFlightAvail searchFlightAvail;

    public TravelHomePage(WebDriver driver) {

        this.driver=driver;

    }

    public void goTo()
    {

        driver.get("https://rahulshettyacademy.com/dropdownsPractise/");
    }

    public NavigationBar getNavigationBar()
    {

        return new NavigationBar(driver,footerNavSectionElement);
    }

    public FooterNav getFooterNav()
    {
        return new FooterNav(driver,sectionElement);
    }

    public void setBookingStrategy(String strategyType)
    {
        StrategyFactor strategyFactor = new StrategyFactor(driver);
        searchFlightAvail = strategyFactor.createStrategy(strategyType);

        this.searchFlightAvail  = searchFlightAvail;
    }

    public void checkAvail(HashMap<String,String> reservationDetails)
    {

        searchFlightAvail.checkAvail(reservationDetails);
    }
    public String getTitle()
    {
        return driver.getTitle();
    }





}
