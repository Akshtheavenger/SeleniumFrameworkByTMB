package com.tmb.pages;

import com.tmb.driver.DriverManager;
import com.tmb.pages.pagecomponenets.FooterMenuComponent;
import com.tmb.pages.pagecomponenets.TopMenuComponent;

public class HomePage {

    //HomePage has top menu composition
    //HomePageTest IS-A TEST --> Inheritance
    //This concept is called composition in Page Object Model.
    //Creating different components of a page and composing them into a single page.
    //The more granularity we give, the more clearer will be the perspective.
    //The Home Page HAS-A list of other sub menus.
    // This object relationship is called Composition. In simpler terms, something is composed of another thing.

    public String getHomePageTitle() {
        return DriverManager.getDriver().getTitle();
    }

    private final TopMenuComponent topMenuComponent;
    private final FooterMenuComponent footerMenuComponent;

    public HomePage() {
        //Usage of Constructors to initialize the class variables
        topMenuComponent = new TopMenuComponent();
        footerMenuComponent = new FooterMenuComponent();
    }

    public void clickOnAdmin() {
        topMenuComponent.clickAdmin();
    }

    public String getFooterText() {
        return footerMenuComponent.getFooterLabel();
    }
}
