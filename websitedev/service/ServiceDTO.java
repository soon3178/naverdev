package service;

public class ServiceDTO {
	private String serviceID;
	private String serviceName;
	private int price;
	private int period;
	private int download;
	
	
	public ServiceDTO(String serviceID, String serviceName, int price,
			int period, int download) {
		super();
		this.serviceID = serviceID;
		this.serviceName = serviceName;
		this.price = price;
		this.period = period;
		this.download = download;
	}


	public String getServiceID() {
		return serviceID;
	}


	public void setServiceID(String serviceID) {
		this.serviceID = serviceID;
	}


	public String getServiceName() {
		return serviceName;
	}


	public void setServiceName(String serviceName) {
		this.serviceName = serviceName;
	}


	public int getPrice() {
		return price;
	}


	public void setPrice(int price) {
		this.price = price;
	}


	public int getPeriod() {
		return period;
	}


	public void setPeriod(int period) {
		this.period = period;
	}


	public int getDownload() {
		return download;
	}


	public void setDownload(int download) {
		this.download = download;
	}


	@Override
	public String toString() {
		return "ServiceDTO [serviceID=" + serviceID + ", serviceName="
				+ serviceName + ", price=" + price + ", period=" + period
				+ ", download=" + download + "]";
	}
	
	
	
}
