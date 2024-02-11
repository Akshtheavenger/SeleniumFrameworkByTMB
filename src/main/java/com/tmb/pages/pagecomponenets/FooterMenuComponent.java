package com.tmb.pages.pagecomponenets;

import org.openqa.selenium.By;

import static com.tmb.utils.SeleniumUtils.getText;

public class FooterMenuComponent {

    private static final By LABEL_FOOTER_MESSAGE = By.xpath("//a[contains(text(),'OrangeHRM, Inc')]");

    public String getFooterLabel() {
        return getText(LABEL_FOOTER_MESSAGE);
    }
}
