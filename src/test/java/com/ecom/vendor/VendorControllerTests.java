package com.ecom.vendor;





import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;


//import java.util.List;

import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.ecom.vendor.model.Vendor;
import com.ecom.vendor.repository.VendorRepository;


@SpringBootTest
@TestMethodOrder(OrderAnnotation.class)
class VendorControllerTests {
  @Autowired
	private VendorRepository vendorRepository;
	
	@Test
	@Order(1)
	public void testCreate () {
		Vendor vendor=new Vendor();
		vendor.setId(1);
		vendor.setVendorname("Dell");
		vendor.setAddress("Bangalore");
		vendor.setRating(4.5F);
		vendor.setContact(8151099203L);
		assertNotNull(vendorRepository.findById(1L).get());
	}
	
	@Test
	@Order(2)
	public void testReadAll () {
		List list = vendorRepository.findAll();
		assertThat(list).size().isGreaterThan(0);
	}
	
	@Test
	@Order(3)
	public void testDelete () {
		vendorRepository.deleteById(38L);
		assertThat(vendorRepository.existsById(38L)).isFalse();
	}
}