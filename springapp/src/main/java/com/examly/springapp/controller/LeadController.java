package com.examly.springapp.controller;

import com.examly.springapp.Exception.ResourceNotFoundException;
import com.examly.springapp.model.Lead;
import com.examly.springapp.service.LeadService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/lead")
@CrossOrigin()
public class LeadController {

    @Autowired
    private LeadService leadService;

    @GetMapping
    public List<Lead> getAllLeads() {
        return leadService.getAllLeads();
    }

    @PostMapping
    public ResponseEntity<Boolean> createLead(@RequestBody Lead lead) {
        Lead createdLead = leadService.createLead(lead);
        if (createdLead != null) {
            return ResponseEntity.status(HttpStatus.OK).body(true);
        } else {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(false);
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<Lead> getLeadById(@PathVariable(value = "id") Long leadId)
            throws ResourceNotFoundException {
        Lead lead = leadService.getLeadById(leadId);
        return ResponseEntity.ok().body(lead);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Lead> updateLead(
            @PathVariable(value = "id") Long leadId,
            @RequestBody Lead leadDetails) throws ResourceNotFoundException {
        Lead updatedLead = leadService.updateLead(leadId, leadDetails);
        return ResponseEntity.ok(updatedLead);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Map<String, Boolean>> deleteLead(@PathVariable(value = "id") Long leadId) {
        try {
            leadService.deleteLead(leadId);
            Map<String, Boolean> response = new HashMap<>();
            response.put("deleted", Boolean.TRUE);
            return ResponseEntity.ok(response);
        } catch (ResourceNotFoundException ex) {
            return ResponseEntity.status(HttpStatus.OK).body(new HashMap<>());
        }
    }
}