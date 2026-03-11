package com.example.SprinBooot_JPA_demo.Service;

import java.util.List;

import com.example.SprinBooot_JPA_demo.DTO.AddressRequestDTO;
import com.example.SprinBooot_JPA_demo.DTO.AddressResponseDTO;

public interface AddressService {
	
	String saveAddress(AddressRequestDTO addressReq);
	
	List<AddressResponseDTO> getListOfAddress();

}
