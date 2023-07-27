package com.examly.springapp.service;

import com.examly.springapp.Exception.ResourceNotFoundException;
import com.examly.springapp.model.Lead;

import java.util.List;

public interface LeadService {

    List<Lead> getAllLeads();

    Lead getLeadById(Long leadId) throws ResourceNotFoundException;

    Lead createLead(Lead lead);

    Lead updateLead(Long leadId, Lead leadDetails) throws ResourceNotFoundException;

    void deleteLead(Long leadId) throws ResourceNotFoundException;

    void deleteAllLeads();
}