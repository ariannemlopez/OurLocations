package com.datacom.component;

import org.openqa.selenium.By;

public class ContactUsMethods {

    public static String url = "https://datacom.com/nz/en/contact-us";
    public static String titlePage = "Contact Us — Get In Touch";
    public static String jsonPath = "src/test/resources/testdata/office_locations.json";
    public static String openDropdownLocator = "cmp-location__location__name open";

    /**
     * Our Locations
     * */

    public static By region(String region) {
        return By.xpath(String.format("//li[normalize-space()='%s']", region));
    }
    public static By cityName(String region, String city) {
        return By.xpath(String.format("//div[@region='%s']//div[contains(text(), '%s')]", region, city));
    }

    public static By openedCityDropdown(String region) {
        return By.xpath(String.format("//div[@region='%s']//div[@class='%s']", region, openDropdownLocator));
    }

    public static By locationAddress(String region) {
        return By.xpath(String.format("//div[@region='%s']//div[@class='cmp-location__location__name open']/following-sibling::div//p[@class='cmp-location__location__address']", region));
    }
    public static By locationDirection(String region) {
        return By.xpath(String.format("//div[@region='%s']//div[@class='cmp-location__location__name open']/following-sibling::div//p[@class='cmp-location__location__direction ']/a", region));
    }
    public static By locationPhone(String region) {
        return By.xpath(String.format("//div[@region='%s']//div[@class='cmp-location__location__name open']/following-sibling::div//p[@class='cmp-location__location__phone ']", region));
    }
    public static By locationEmail(String region) {
        return By.xpath(String.format("//div[@region='%s']//div[@class='cmp-location__location__name open']/following-sibling::div//p[@class='cmp-location__location__email']", region));
    }

    /**
     * Contact Us
     * */
    public static By CONTACT_US_BUTTON = By.cssSelector(".cmp-cta-button__text");
    public static By CONTACT_US_MODAL = By.cssSelector(".cmp-mrkto-modal__content__grid");
    public static By CONTACT_US_FORM = By.cssSelector("#mktoForm_1846");
}
