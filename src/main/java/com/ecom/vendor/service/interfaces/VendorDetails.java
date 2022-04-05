package com.ecom.vendor.service.interfaces;

import java.util.List;
import com.ecom.vendor.model.Vendor;

public interface VendorDetails { 
	public List<Vendor> getAllVendors();
	Vendor findVendorByVendorName(String vendorName);
}

