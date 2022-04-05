package com.ecom.vendor.repository;

import java.util.List;



import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.stereotype.Repository;

import com.ecom.vendor.model.Product;


@Repository
public interface ProductRepository extends JpaRepository<Product,Long>{
//	List<Product> findByName(String modelname );

}
