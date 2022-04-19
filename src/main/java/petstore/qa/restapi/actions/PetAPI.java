package petstore.qa.restapi.actions;

import static io.restassured.RestAssured.given;
import static org.testng.Assert.assertEquals;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import petstore.qa.restapi.datamodel.Pet;

public class PetAPI {
	
	private static final String SWAGGER_PET_URL = "https://petstore.swagger.io/v2/pet"; 
	
	public static Pet createPet() {
		
		// Add new pet to store
		Pet newPet = new Pet().generatePet();		
		Response rspCreatePet = PetAPI.createPet(newPet);

		assertEquals(rspCreatePet.getStatusCode(), 200);

		// Check pet is created
		Pet createdPet = rspCreatePet.getBody().as(Pet.class);		

		assertEquals(newPet.name, createdPet.name);
		
		return newPet;
	}

	public static Response createPet(Pet pet) {
		
		return 
			given()
				.contentType(ContentType.JSON)
				.body(pet)
			.when()
				.post(SWAGGER_PET_URL);
	}
	
	public static Response deletePet(Pet pet) {
		
		return 
				given()
					.contentType(ContentType.JSON)
					.pathParam("petId", pet.id)
				.when()
					.delete(SWAGGER_PET_URL + "/{petId}");
	}
	
	public static Response findPetByID(Pet pet) {
		
		return 
				given()
					.contentType(ContentType.JSON)
					.pathParam("petId", pet.id)
				.when()
					.get(SWAGGER_PET_URL + "/{petId}");
	}
}
