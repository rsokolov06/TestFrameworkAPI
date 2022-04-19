package petstore.qa.restapi.datamodel;

import java.time.LocalDateTime;

import java.util.Date;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Order {

	@SerializedName("id")
    @Expose
	public Long id;
	
	@SerializedName("petId")
    @Expose
    public Long petId;
	
	@SerializedName("quantity")
    @Expose
    public Integer quantity;
	
	@SerializedName("shipDate")
    @Expose
    public String shipDate;
	
	@SerializedName("status")
    @Expose
    public OrderStatus status;
	
	@SerializedName("complete")
    @Expose
    public boolean complete;

	public Order() {
		
	}
    
    public Order generateOrder(Pet pet, Integer quantity) {
    	
    	this.id = (new Date()).getTime() % 10;
    	if(this.id == 0) this.id++;
    	this.petId = pet.id;
    	this.quantity = quantity;
    	this.shipDate = LocalDateTime.now().plusWeeks(2).toString();
    	this.status = OrderStatus.placed;
    	this.complete = true;
    	
    	return this;
    }
}
