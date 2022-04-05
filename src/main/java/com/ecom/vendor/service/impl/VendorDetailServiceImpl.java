package com.ecom.vendor.service.impl;

import java.util.List;

import javax.persistence.EntityManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ecom.vendor.model.Vendor;
import com.ecom.vendor.repository.VendorRepository;
import com.ecom.vendor.service.interfaces.VendorDetails;

@Service
public class VendorDetailServiceImpl implements VendorDetails{
	
	private VendorRepository vendorRepository;
	
	@Autowired
	private EntityManager em;
	
	@Override
	public List<Vendor> getAllVendors() {
		return vendorRepository.findAll();
	}
	
	@Override
	public Vendor findVendorByVendorName(String vendorName) {
		Vendor result = null;
		
		String s = "select * from Vendor where V_NAME='"+vendorName+"';";
		try {
			result = (Vendor) em.createNativeQuery(s).getSingleResult();
		}
		catch(Exception e)
		{
			
		}
		return result;
	}
	
			
}

