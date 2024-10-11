package com.previnci.stepdefinitions;

import com.previnci.core.PageManager;
import com.previnci.pages.CommonCode;
import com.previnci.pages.TPAAddGroup;
import com.previnci.pages.UtilityMethods;
import io.cucumber.java.en.*;
import org.testng.Assert;

public class TPAAddGroupDef {

    private final PageManager pageManager = PageManager.getInstance();
    private final TPAAddGroup tpaAddGroup = this.pageManager.getPageGenerator().getInstance(TPAAddGroup.class);
    private final UtilityMethods utilityMethods = this.pageManager.getPageGenerator().getInstance(UtilityMethods.class);
    private final CommonCode common = this.pageManager.getPageGenerator().getInstance(CommonCode.class);

    @Given("the user navigates to the Groups page")
    public void the_user_navigates_to_the_groups_page() {
        common.clickGroupsMenu();
    }

    @Given("the user clicks the Add New button")
    public void the_user_clicks_the_add_new_button() {
        common.addNewButton();
    }

    @When("the user clicks the Save button")
    public void the_user_clicks_the_save_button() {
        common.saveButton();
//        common.cancelButton();
    }

    @When("the user enters the Group Details: {string}, {string}, {string}, and {string}")
    public void the_user_enters_the_group_details_and(String string, String string2, String string3, String string4) {
        tpaAddGroup.enterGroupDetails(string, string2, string3, string4);

    }

    @When("the user enters the Primary Plan Sponsor Details: {string}, {string}, and {string}")
    public void the_user_enters_the_primary_plan_sponsor_details_and(String string, String string2, String string3) {
        tpaAddGroup.enterPrimaryPlanSponsorDetails(string, string2, string3);
    }

    @Then("the group should be successfully created, and a confirmation message should be displayed {string}")
    public void the_group_should_be_successfully_created_and_a_confirmation_message_should_be_displayed(String expectedMessage) {
        String actualMessage = tpaAddGroup.getConfirmationMessage();
        utilityMethods.assertEqualsString(actualMessage, expectedMessage);
    }

    @Then("the newly added group should appear in the group list")
    public void the_newly_added_group_should_appear_in_the_group_list() {
        String generatedGroupName = tpaAddGroup.getGeneratedGroupName();
        String generatedGroupNumber = tpaAddGroup.getGeneratedGroupNumber();
        boolean isAdded = tpaAddGroup.isGroupAddedInList(generatedGroupName, generatedGroupNumber);
        Assert.assertTrue(isAdded, "The group '" + generatedGroupName + "' with number '" + generatedGroupNumber + "' was not added to the list.");
    }

    @When("the user leaves all fields blank: {string}, {string}, {string}, and {string}")
    public void the_user_leaves_all_fields_blank_and(String string, String string2, String string3, String string4) {

    }

    @When("the user leaves the Primary Plan Sponsor Details blank: {string}, {string}, and {string}")
    public void the_user_leaves_the_primary_plan_sponsor_details_blank_and(String string, String string2, String string3) {

    }

    @Then("the system should display an error message indicating that all mandatory fields must be completed")
    public void the_system_should_display_an_error_message_indicating_that_all_mandatory_fields_must_be_completed() {

    }

    @When("the user provides the Group Details: {string}, {string}, {string}, and {string}")
    public void the_user_provides_the_group_details_and(String string, String string2, String string3, String string4) {

    }

    @When("the user provides the Primary Plan Sponsor Details: {string}, {string}, and an invalid email {string}")
    public void the_user_provides_the_primary_plan_sponsor_details_and_an_invalid_email(String string, String string2, String string3) {

    }

    @Then("the system should display an error message indicating that the entered email address format is invalid")
    public void the_system_should_display_an_error_message_indicating_that_the_entered_email_address_format_is_invalid() {

    }

}