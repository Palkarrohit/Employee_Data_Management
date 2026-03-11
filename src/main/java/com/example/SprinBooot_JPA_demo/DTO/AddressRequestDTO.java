package com.example.SprinBooot_JPA_demo.DTO;


public class AddressRequestDTO {

	private String Req_city;
	private String Req_state;
	private Long Req_pincode;
	
	//-----------------------------------------------------------
	// Below are setter getters
	//-----------------------------------------------------------

	public String getReq_city() {
		return Req_city;
	}
	public void setReq_city(String req_city) {
		Req_city = req_city;
	}
	public String getReq_state() {
		return Req_state;
	}
	public void setReq_state(String req_state) {
		Req_state = req_state;
	}
	public Long getReq_pincode() {
		return Req_pincode;
	}
	public void setReq_pincode(Long req_pincode) {
		Req_pincode = req_pincode;
	}
	
	
	
}
