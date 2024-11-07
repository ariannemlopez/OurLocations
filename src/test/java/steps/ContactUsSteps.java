package steps;

import com.datacom.common.PageObject;
import com.datacom.component.ContactUsMethods;
import com.datacom.model.LocationDetails;
import com.datacom.model.OurLocations;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;
import java.io.File;
import java.io.IOException;
import java.util.List;

public class ContactUsSteps {

    @Given("I visit contact us page")
    public static void visitContactUsPage() {
        PageObject.goTo(ContactUsMethods.url);

        Assert.assertEquals(PageObject.getTitlePage(), ContactUsMethods.titlePage,
                "There is an error encountered when visiting Contact Us page");
    }

    @When("I visit {string} tab and {string} dropdown")
    public void clickOnCityDropdown(String region, String city) {
        PageObject.click(ContactUsMethods.region(region));
        if (PageObject.getAttribute(ContactUsMethods.cityName(region, city), "class").contains(ContactUsMethods.openDropdownLocator)) {
            System.out.println("Dropdown is open");
        } else {
            //Flaky locator
            //Close the open dropdown first
            PageObject.click(ContactUsMethods.openedCityDropdown(region));
            int retry = 0;
            while (retry < 3) {
                if (PageObject.getAttribute(ContactUsMethods.cityName(region, city), "class").contains(ContactUsMethods.openDropdownLocator)) {
                    break;
                }
                PageObject.click(ContactUsMethods.cityName(region, city));
                retry++;
            }

        }
//        PageObject.waitFor(ContactUsMethods.OPEN_DROPDOWN);
    }

    @Then("I see the correct office location details for {string} {string}")
    public void verifyOfficeLocationDetails(String city, String region) throws IOException {
        OurLocations ourLocations = new ObjectMapper().readValue(new File(ContactUsMethods.jsonPath), OurLocations.class);
        List<LocationDetails> locationDetails;
        if (region.equalsIgnoreCase("New Zealand")) {
            locationDetails = ourLocations.getNew_Zealand();
        } else if (region.equalsIgnoreCase("Australia")) {
            locationDetails = ourLocations.getAustralia();
        } else if (region.equalsIgnoreCase("Asia")) {
            locationDetails = ourLocations.getAsia();
        } else {
            throw new RuntimeException(String.format("%s is not found", region));
        }

        for (LocationDetails details : locationDetails) {
            if (details.getCity().contains(city)) {
                Assert.assertEquals(details.getAddress(), PageObject.getText(ContactUsMethods.locationAddress(region)));
                Assert.assertTrue(details.getLink().contains(PageObject.getAttribute(ContactUsMethods.locationDirection(region), "href")));
                Assert.assertEquals(details.getPhone(), PageObject.getText(ContactUsMethods.locationPhone(region)));
                Assert.assertEquals(details.getEmail(), PageObject.getText(ContactUsMethods.locationEmail(region)));
            }
        }
    }
}
