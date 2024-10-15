package com.previnci.stepdefinitions;

import com.previnci.core.PageManager;
import com.previnci.pages.CommonCode;
//import com.previnci.pages.GroupSignUp;
import com.previnci.pages.TPAAddGroup;
import com.previnci.pages.UtilityMethods;
import io.cucumber.java.en.*;

public class TPAAddGroupDef {

    private final PageManager pageManager = PageManager.getInstance();
    private final TPAAddGroup tpaAddGroup = this.pageManager.getPageGenerator().getInstance(TPAAddGroup.class);
    private final UtilityMethods utilityMethods = this.pageManager.getPageGenerator().getInstance(UtilityMethods.class);
    private final CommonCode common = this.pageManager.getPageGenerator().getInstance(CommonCode.class);
//    private final GroupSignUp groupSignUp = this.pageManager.getPageGenerator().getInstance(GroupSignUp.class);

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
        utilityMethods.assertTrueWithMessage(isAdded, "The group '" + generatedGroupName + "' with number '" + generatedGroupNumber + "' was not added to the list.");
    }

    @When("the user leaves all fields blank: {string}, {string}, {string}, and {string}")
    public void the_user_leaves_all_fields_blank_and(String string, String string2, String string3, String string4) {
        tpaAddGroup.fillGroupDetails(string, string2, string3, string4);
    }

    @When("the user leaves the Primary Plan Sponsor Details blank: {string}, {string}, and {string}")
    public void the_user_leaves_the_primary_plan_sponsor_details_blank_and(String string, String string2, String string3) {
        tpaAddGroup.fillPlanSponserDetails(string, string2, string3);
    }

    @When("the user provides the Group Details: {string}, {string}, {string}, and {string}")
    public void the_user_provides_the_group_details_and(String string, String string2, String string3, String string4) {
        tpaAddGroup.fillGroupDetails(string, string2, string3, string4);
    }

    @When("the user provides the Primary Plan Sponsor Details: {string}, {string}, and an invalid email {string}")
    public void the_user_provides_the_primary_plan_sponsor_details_and_an_invalid_email(String string, String string2, String string3) {
        tpaAddGroup.fillPlanSponserDetails(string, string2, string3);
    }

    @Then("the validation should appear on the input fields")
    public void the_validation_should_appear_on_the_input_fields() {
        String result = tpaAddGroup.getErrorMessage() ? "Error message is displayed as expected." : "Error message is NOT displayed.";
         utilityMethods.assertTrueWithMessage(tpaAddGroup.getErrorMessage(), result);
    }

    @And("the user logs out successfully from the application")
    public void the_user_logs_out_successfully_from_the_application() {
        common.userLoggedOut();
    }

    @And("the user opens the Mailosaur app, logs in successfully, and navigates to the Inbox")
    public void the_user_opens_the_mailosaur_app_logs_in_successfully_and_navigates_to_the_inbox() {
        tpaAddGroup.openAppAndLogin();
        tpaAddGroup.navigateToInbox();
    }

    @And("the user verifies the content of the received email and clicks on it")
    public void the_user_verifies_the_content_of_the_received_email_and_clicks_on_it() {
        String actual = tpaAddGroup.verifyEmailContent();
        String expected = tpaAddGroup.getGeneratedGroupName();
        System.out.println(actual);
       utilityMethods.assertEqualsString(actual, expected);
    }

    @And("the user opens the received email")
    public void the_user_opens_the_received_email() {
        tpaAddGroup.openReceivedEmail();
    }

    @And("the user clicks on the Complete Registration link")
    public void the_user_clicks_on_the_complete_registration_link() {
        tpaAddGroup.clickCompleteRegistrationLink();

    }

    @When("the user fills in the organization details with {string},{string} Street {string},city {string},State {string}, zip code {string}, phone {string}, and TIN")
    public void the_user_fills_in_the_organization_details_with_street_city_state_zip_code_phone_and_tin(String legalName, String dbaNames, String street, String city, String state, String zip, String phone) {
        String companyName = tpaAddGroup.getGeneratedGroupName()+legalName;
        String dbaName = tpaAddGroup.getGeneratedGroupName() +" "+dbaNames;
        tpaAddGroup.enterCompanyLegalName(companyName);
        tpaAddGroup.enterCompanyDBAName(dbaName);
        tpaAddGroup.enterStreetAddress(street);
        tpaAddGroup.enterCity(city);
        tpaAddGroup.enterState(state);
        tpaAddGroup.enterZipCode(zip);
        tpaAddGroup.enterPhone(phone);
        tpaAddGroup.enterEINorTIN();
    }

    @And("the user clicks the Next button")
    public void the_user_clicks_the_next_button() {
        tpaAddGroup.clickNextButton();
    }

    @And("the user enters first name, last name, last four digits SSN, username, password, and confirm password")
    public void the_user_enters_first_name_last_name_last_four_digits_ssn_username_password_and_confirm_password() {
        tpaAddGroup.enterFirstName();
        tpaAddGroup.enterLastName();
        tpaAddGroup.enterLastFour();
        tpaAddGroup.enterUsername();
        tpaAddGroup.enterPassword();
        tpaAddGroup.enterConfirmPassword();
    }

    @And("the user clicks the Review button and then clicks Submit")
    public void the_user_clicks_the_review_button_and_then_clicks_submit() {
        tpaAddGroup.clickReviewButton();
        tpaAddGroup.clickSubmitButton();

    }

    @Then("the user navigates to the Login page")
    public void the_user_navigates_to_the_login_page() {
           String expected = "https://dev.previnci.app/login";
           utilityMethods.assertUrlEquals(expected);
    }
}