package petstore.qa.restapi;

import static org.testng.Assert.assertEquals;

import org.testng.annotations.Test;

import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.restassured.response.Response;
import petstore.qa.restapi.actions.PetAPI;
import petstore.qa.restapi.actions.StoreAPI;
import petstore.qa.restapi.datamodel.Order;
import petstore.qa.restapi.datamodel.Pet;
import petstore.qa.restapi.listeners.RetryAnalyzer;

public class TC3_PetOrderTest {
	
	@Test (retryAnalyzer = RetryAnalyzer.class)
	@Description("Test goal: Check that pet order flow.")
	@Severity(SeverityLevel.NORMAL)	
	public void testOrderCreation() {

		Pet newPet = PetAPI.createPet();
		
		// Create order
		Order order = StoreAPI.createOrder(newPet, 1);
		
		// Try to retrieve order
		Response rspGetOrderPlaced = StoreAPI.getOrder(order);
		
		assertEquals(rspGetOrderPlaced.getStatusCode(), 200);
		assertEquals(rspGetOrderPlaced.body().as(Order.class).id, order.id);
	}
}
