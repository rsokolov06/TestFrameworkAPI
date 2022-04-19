package petstore.qa.restapi.datamodel;

import java.util.Date;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class User {
	
	@SerializedName("id")
    @Expose
	public Long id;
	
	@SerializedName("username")
    @Expose
	public String userName;
	
	@SerializedName("firstName")
    @Expose
	public String firstName;
	
	@SerializedName("lastName")
    @Expose
	public String lastName;
	
	@SerializedName("email")
    @Expose
	public String email;
	
	@SerializedName("password")
    @Expose
	public String password;
	
	@SerializedName("phone")
    @Expose
	public String phone;
	
	@SerializedName("userStatus")
    @Expose
	public Integer userStatus;
		
	public User() {		
	}
	
	public User(User user) {
		this.id = user.id;
    	this.userName = user.userName;
    	this.firstName = user.firstName;
    	this.lastName = user.lastName;
    	this.email = user.email;
    	this.password = user.password;
    	this.phone = user.phone;
    	this.userStatus = user.userStatus;
	}
	
	public User generateUser() {
		
		this.id = (new Date()).getTime();
    	this.userName = "username-" + id;
    	this.firstName = "firstname-" + id;
    	this.lastName = "lastname-" + id;
    	this.email = id + "@testmail.com";
    	this.password = "password-" + id;
    	this.phone = "phone-" + id;
    	this.userStatus = 0;
    	
    	return this;		
	}
}
