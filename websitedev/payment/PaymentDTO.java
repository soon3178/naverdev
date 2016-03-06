package payment;

import java.util.Date;

public class PaymentDTO {
	private String paymentID;
	private String serviceID;
	private String memberID;
	private Date payday;
	
	public PaymentDTO(){
		super();
	}
	
	public PaymentDTO(String serviceID, String memberID) {
		super();
		this.serviceID = serviceID;
		this.memberID = memberID;
	}
	
	public PaymentDTO(String serviceID, String memberID, Date payday) {
		super();
		this.serviceID = serviceID;
		this.memberID = memberID;
		this.payday = payday;
	}
	
	public PaymentDTO(String paymentID, String serviceID, String memberID,	Date payday) {
		super();
		this.paymentID = paymentID;
		this.serviceID = serviceID;
		this.memberID = memberID;
		this.payday = payday;
	}

	public String getPaymentID() {
		return paymentID;
	}

	public void setPaymentID(String paymentID) {
		this.paymentID = paymentID;
	}

	public String getServiceID() {
		return serviceID;
	}

	public void setServiceID(String serviceID) {
		this.serviceID = serviceID;
	}

	public String getMemberID() {
		return memberID;
	}

	public void setMemberID(String memberID) {
		this.memberID = memberID;
	}

	public Date getPayday() {
		return payday;
	}

	public void setPayday(Date payday) {
		this.payday = payday;
	}
}
