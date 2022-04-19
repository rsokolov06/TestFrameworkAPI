package petstore.qa.restapi.datamodel;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Category {

	@SerializedName("id")
    @Expose
	public Long id;
	
	@SerializedName("name")
    @Expose
	public String name;
		
	public Category() {
		this.id = 0L;
		this.name = "dummy_category";
	}
	
	public Category(Long id, String name) {
		this.id = id;
		this.name = name;
	}
}
