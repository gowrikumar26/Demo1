Feature: login functionality

	Background:
	Given User open Salesforce application
	
	Scenario: trying to login without password 
	
	When user on "login"
	When enter valid "valid.username"
	And click the login button
	Then validate the "expected.loginErrorMessage"

Scenario: login with valid crdentials
	
	When user on "login"
	When enter valid "valid.username" and "valid.password"
	When click the login button
	When user on "home" 
	Then validate the home page "validate.homepage"
	
	Scenario: test the remember username

	When user on "login"
	When enter valid "valid.username" and "valid.password"
	And click the Remember me check box 
	And click the login button
	When user on "home" 
	And select logout and click it
	Then validate the loginPage with username "valid.username"
	
	Scenario: checking forgot password
	
	When user on "login"
	When click on forgot password
	And  provide "valid.username" in the username field
	Then validate the password reset message "forgot.password.message"
	
Scenario: login with invalid crdentials

	When user on "login"
	When enter invalid "invalid.username" and "invalid.password"
	And click the login button
	Then validate the error message "validate.invalidCredentials.errormessage"

