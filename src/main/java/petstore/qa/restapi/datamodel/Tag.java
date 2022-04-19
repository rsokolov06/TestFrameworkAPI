package petstore.qa.restapi.datamodel;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Tag {

	@SerializedName("id")
    @Expose
	public Long id;
	
	@SerializedName("name")
    @Expose
	public String name;
	
	public Tag(Long id, String name) {
		this.id = id;
		this.name = name;
	}
}
