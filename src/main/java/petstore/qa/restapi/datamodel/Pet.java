package petstore.qa.restapi.datamodel;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Pet {
	
	@SerializedName("id")
    @Expose
	public Long id;
	
	@SerializedName("category")
    @Expose
    public Category category;
	
	@SerializedName("name")
    @Expose
    public String name;
	
	@SerializedName("photoUrls")
    @Expose
    public List<String> photoUrls = new ArrayList<>();
	
	@SerializedName("tags")
    @Expose
    public List<Tag> tags = new ArrayList<>();
	
	@SerializedName("status")
    @Expose
    public PetStatus status;

	public Pet() {
		
	}
    
    public Pet generatePet() {
    	
    	this.id = (new Date()).getTime();
    	this.category = new Category();
    	this.name = "name-" + id;
    	this.photoUrls = Collections.singletonList("www.pet.com/pet-" + id +".jpg");
    	this.tags = Collections.singletonList(new Tag(1L, "tagname"));
    	this.status = PetStatus.available;
    	
    	return this;
    }
}
