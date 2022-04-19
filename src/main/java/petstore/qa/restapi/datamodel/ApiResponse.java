package petstore.qa.restapi.datamodel;


import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class ApiResponse {
	
	@SerializedName("code")
    @Expose
	public Integer code;
	
	@SerializedName("type")
    @Expose
	public String type;
	
	@SerializedName("message")
    @Expose
	public String message;
		
	public ApiResponse() {
		this.code = 0;
		this.type = "";
		this.message = "";
	}
}
