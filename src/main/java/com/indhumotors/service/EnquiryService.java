package com.indhumotors.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.indhumotors.entity.Enquiry;
import com.indhumotors.repository.EnquiryRepository;

@Service
public class EnquiryService {

    private final EnquiryRepository enquiryRepository;

    public EnquiryService(EnquiryRepository enquiryRepository) {
        this.enquiryRepository = enquiryRepository;
    }

    public Enquiry createEnquiry(Enquiry enquiry) {
        return enquiryRepository.save(enquiry);
    }

    public List<Enquiry> getAllEnquiries() {
        return enquiryRepository.findAll();
    }
}