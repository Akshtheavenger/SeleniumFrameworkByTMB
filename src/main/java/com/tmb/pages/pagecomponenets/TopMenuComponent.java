package com.tmb.pages.pagecomponenets;

import org.openqa.selenium.By;

import static com.tmb.utils.SeleniumUtils.click;

public class TopMenuComponent {

    private static final By LINK_ADMIN = By.xpath("//span[text()='Admin']//parent::a");

    public void clickAdmin(){
        click(LINK_ADMIN, "Admin Link");
    }

}
