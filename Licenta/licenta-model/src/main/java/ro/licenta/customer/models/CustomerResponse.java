package ro.licenta.customer.models;

public class CustomerResponse {
	
	private String clientName;
	private String clientRole;
	
	public CustomerResponse() {
		
	}

	public String getClientName() {
		return clientName;
	}

	public void setClientName(String clientName) {
		this.clientName = clientName;
	}

	public String getClientRole() {
		return clientRole;
	}

	public void setClientRole(String clientRole) {
		this.clientRole = clientRole;
	}

}
