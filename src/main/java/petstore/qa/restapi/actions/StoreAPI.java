package petstore.qa.restapi.actions;

import static io.restassured.RestAssured.given;
import static org.testng.Assert.assertEquals;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import petstore.qa.restapi.datamodel.Order;
import petstore.qa.restapi.datamodel.Pet;

public class StoreAPI {

	private static final String SWAGGER_ORDER_URL = "https://petstore.swagger.io/v2/store/order";
	
	public static Order createOrder(Pet pet, Integer quantity) {
		
		Order order = new Order().generateOrder(pet, quantity);
		Response rspCreateOrder = StoreAPI.createOrder(order);

		assertEquals(rspCreateOrder.getStatusCode(), 200);
		
		return order;
	}

	public static Response createOrder(Order order) {
		
		return 
			given()
				.contentType(ContentType.JSON)
				.body(order)
			.when()
				.post(SWAGGER_ORDER_URL);
	}
	
	public static Response getOrder(Order order) {
		
		return 
				given()
					.contentType(ContentType.JSON)
					.pathParam("orderId", order.id)
				.when()
					.get(SWAGGER_ORDER_URL + "/{orderId}");
	}
}
