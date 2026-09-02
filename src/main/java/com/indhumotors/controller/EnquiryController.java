package com.indhumotors.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.indhumotors.entity.Enquiry;
import com.indhumotors.service.EnquiryService;

@RestController
@RequestMapping("/api/enquiries")
@CrossOrigin(origins = "http://localhost:5173")
public class EnquiryController {

    private final EnquiryService enquiryService;

    public EnquiryController(EnquiryService enquiryService) {
        this.enquiryService = enquiryService;
    }

    @PostMapping
    public ResponseEntity<Enquiry> createEnquiry(@RequestBody Enquiry enquiry) {
        Enquiry savedEnquiry = enquiryService.createEnquiry(enquiry);
        return ResponseEntity.ok(savedEnquiry);
    }

    @GetMapping
    public ResponseEntity<List<Enquiry>> getAllEnquiries() {
        return ResponseEntity.ok(enquiryService.getAllEnquiries());
    }
}