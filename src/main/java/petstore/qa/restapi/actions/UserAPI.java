package petstore.qa.restapi.actions;

import static io.restassured.RestAssured.given;
import static org.testng.Assert.assertEquals;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import petstore.qa.restapi.datamodel.ApiResponse;
import petstore.qa.restapi.datamodel.User;

public class UserAPI {
	
	private static final String SWAGGER_USER_URL = "https://petstore.swagger.io/v2/user";
	
	public static User createUser() {
		
		User newUser = new User().generateUser();		
		Response rspCreateUser = UserAPI.createUser(newUser);
		
		assertEquals(rspCreateUser.getStatusCode(), 200);
		
		// Check user creation response
		ApiResponse rspApi = rspCreateUser.getBody().as(ApiResponse.class);
		
		assertEquals(newUser.id, Long.parseLong(rspApi.message));
		
		return newUser;
	}

	public static Response createUser(User user) {

		return 
				given()
					.contentType(ContentType.JSON)
					.body(user)
				.when()
					.post(SWAGGER_USER_URL);
	}

	public static Response loginUser(User user) {

		return 
				given()
					.contentType(ContentType.JSON)
					.param("username", user.userName)
					.param("password", user.password)
				.when()
					.get(SWAGGER_USER_URL + "/login");
	}

	public static Response logoutUser() {

		return 
				given()
					.contentType(ContentType.JSON)
				.when()
					.get(SWAGGER_USER_URL + "/logout");
	}

	public static Response updateUser(User user) {

		return 
				given()
					.contentType(ContentType.JSON)
					.pathParam("username", user.userName)
					.body(user)
				.when()
					.put(SWAGGER_USER_URL + "/{username}");
	}
	
	public static Response getUserByUsername(User user) {

		return 
				given()
					.contentType(ContentType.JSON)
					.pathParam("username", user.userName)
				.when()
					.get(SWAGGER_USER_URL + "/{username}");
	}
}
