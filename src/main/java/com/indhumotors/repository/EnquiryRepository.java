package com.indhumotors.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.indhumotors.entity.Enquiry;

public interface EnquiryRepository extends JpaRepository<Enquiry, Long> {

}