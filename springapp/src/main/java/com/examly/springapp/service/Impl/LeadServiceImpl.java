package com.examly.springapp.service.Impl;

import com.examly.springapp.Exception.ResourceNotFoundException;
import com.examly.springapp.model.Lead;
import com.examly.springapp.repository.LeadRepository;
import com.examly.springapp.service.LeadService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class LeadServiceImpl implements LeadService {

    @Autowired
    private LeadRepository leadRepository;

    @Override
    public List<Lead> getAllLeads() {
        return leadRepository.findAll();
    }

    @Override
    public Lead getLeadById(Long leadId) throws ResourceNotFoundException {
        Optional<Lead> lead = leadRepository.findById(leadId);
        if (lead.isPresent()) {
            return lead.get();
        } else {
            throw new ResourceNotFoundException("Lead not found with ID: " + leadId);
        }
    }

    @Override
    public Lead createLead(Lead lead) {
        return leadRepository.save(lead);
    }

    @Override
    public Lead updateLead(Long leadId, Lead leadDetails) throws ResourceNotFoundException {
        Lead lead = getLeadById(leadId);
        lead.setName(leadDetails.getName());
        lead.setEmail(leadDetails.getEmail());
        lead.setPhone(leadDetails.getPhone());
        lead.setSource(leadDetails.getSource());
        lead.setStatus(leadDetails.getStatus());
        lead.setNotes(leadDetails.getNotes());
        return leadRepository.save(lead);
    }

    @Override
    public void deleteLead(Long leadId) throws ResourceNotFoundException {
        Lead lead = getLeadById(leadId);
        leadRepository.delete(lead);
    }
    
    @Override
    public void deleteAllLeads() {
        leadRepository.deleteAll();
    }
}