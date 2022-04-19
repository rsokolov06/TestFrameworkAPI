package petstore.qa.restapi;

import static org.testng.Assert.assertEquals;

import org.testng.annotations.Test;

import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.restassured.response.Response;
import petstore.qa.restapi.actions.UserAPI;
import petstore.qa.restapi.datamodel.ApiResponse;
import petstore.qa.restapi.datamodel.User;
import petstore.qa.restapi.listeners.RetryAnalyzer;

public class TC2_UserPasswordUpdateTest {

	private final String PASSWORD_UPDATE = "newpassword";
	
	@Test (retryAnalyzer = RetryAnalyzer.class)
	@Description("Test goal: Check that password is updated correctly.")
	@Severity(SeverityLevel.NORMAL)	
	public void testUserPasswordUpdate() {

		// Create new user
		User newUser = UserAPI.createUser();

		// Login user
		assertEquals(UserAPI.loginUser(newUser).getStatusCode(), 200);
		
		// Logout user
		assertEquals(UserAPI.logoutUser().getStatusCode(), 200);

		
		// Update user password
		User updatedUser = new User(newUser);
		updatedUser.password = PASSWORD_UPDATE;
		
		assertEquals(UserAPI.updateUser(updatedUser).getStatusCode(), 200);
		
		// Get user and check for new password
		assertEquals(UserAPI
						.getUserByUsername(newUser)
						.getBody()
						.as(User.class).password, PASSWORD_UPDATE);
	}
}
