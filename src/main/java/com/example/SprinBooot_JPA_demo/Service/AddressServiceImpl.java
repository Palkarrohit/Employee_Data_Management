package com.example.SprinBooot_JPA_demo.Service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.example.SprinBooot_JPA_demo.DTO.AddressRequestDTO;
import com.example.SprinBooot_JPA_demo.DTO.AddressResponseDTO;
import com.example.SprinBooot_JPA_demo.Entity.AddressEntity;
import com.example.SprinBooot_JPA_demo.Repo.AddressRepo;

public class AddressServiceImpl implements AddressService {

	@Autowired
	AddressRepo addressRepo;
	
    @Override
    public List<AddressResponseDTO> getListOfAddress() {
	
    	List<AddressResponseDTO> responseList= new ArrayList<>();
	for(AddressEntity address: addressRepo.findAll())
	{
		AddressResponseDTO response= new AddressResponseDTO();
		
		response.setRes_city(address.getCity());
		response.setRes_state(address.getState());
		response.setRes_pincode(address.getPincode());
		
		responseList.add(response);
		
	}
	
	
	return responseList;
    }
    
    
    
    @Override
	public String saveAddress(AddressRequestDTO addressReq) {
	
    	AddressEntity addressEntity=new AddressEntity();
    	addressEntity.setCity(addressReq.getReq_city());
    	addressEntity.setState(addressReq.getReq_state());
    	addressEntity.setPincode(addressReq.getReq_pincode());
    	
    	addressRepo.save(addressEntity);
    	
		return "Address Saved";
	}

}
