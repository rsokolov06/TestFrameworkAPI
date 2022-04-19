package petstore.qa.restapi;

import static org.testng.Assert.*;
import org.testng.annotations.Test;

import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.restassured.response.Response;
import petstore.qa.restapi.actions.PetAPI;
import petstore.qa.restapi.datamodel.Pet;
import petstore.qa.restapi.listeners.RetryAnalyzer;

public class TC1_PetDeleteTest {

	@Test (retryAnalyzer = RetryAnalyzer.class)
	@Description("Test goal: Try to create and delete pet, check that pet no longer exists.")
	@Severity(SeverityLevel.NORMAL)	
	public void testDelete() {

		// Add new pet to store
		Pet newPet = PetAPI.createPet();
		
		// Delete created pet
		assertEquals(PetAPI.deletePet(newPet).getStatusCode(), 200);
		
		// Try to retrieve that pet
		assertEquals(PetAPI.findPetByID(newPet).getStatusCode(), 404);
	}
}
