package com.example.SprinBooot_JPA_demo.DTO;

public class AddressResponseDTO {
	private String Res_city;
	private String Res_state;
	private Long Res_pincode;
	
	//-----------------------------------------------------------
	// Below are setter getters
	//-----------------------------------------------------------

	public String getRes_city() {
		return Res_city;
	}
	public void setRes_city(String res_city) {
		Res_city = res_city;
	}
	public String getRes_state() {
		return Res_state;
	}
	public void setRes_state(String res_state) {
		Res_state = res_state;
	}
	public Long getRes_pincode() {
		return Res_pincode;
	}
	public void setRes_pincode(Long res_pincode) {
		Res_pincode = res_pincode;
	}
	
	

}
