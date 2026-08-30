package com.indhumotors.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.indhumotors.entity.Product;

public interface ProductRepository extends JpaRepository<Product, Long> {
}