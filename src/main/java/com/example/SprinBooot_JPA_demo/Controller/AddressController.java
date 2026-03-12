package com.example.SprinBooot_JPA_demo.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.SprinBooot_JPA_demo.DTO.AddressResponseDTO;
import com.example.SprinBooot_JPA_demo.Service.AddressService;

@RestController
@RequestMapping("/address")
public class AddressController {
	@Autowired
   private AddressService addressService;
	
    @GetMapping
	public ResponseEntity<List<AddressResponseDTO>> getAddressList()
	{
		return ResponseEntity.ok(addressService.getListOfAddress());
	}

}
