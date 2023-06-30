package com.example.springapp.service;

import com.example.springapp.repository.LeadRepository;
import com.example.springapp.model.Leads;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class LeadService implements LeadServiceInterface{

    @Autowired
    private LeadRepository LeadRepository;

    public LeadService() {   }
    @Override
    public Leads addLead(Leads leads){
        return this.LeadRepository.save(leads);
    }
    @Override
    public List<Leads> getLeads(){
        return this.LeadRepository.findAll();
    }
    @Override
    public Leads getLeadById(long id){
        return this.LeadRepository.findById(id).orElseThrow(()->new RuntimeException("Lead not found"));
    }
    @Override
    public Leads updateLead(long id, Leads leads){
        Leads updateLeads=LeadRepository.findById(id).orElseThrow(()->new RuntimeException("Lead not found"));
        updateLeads.setName(leads.getName());
        updateLeads.setEmail(leads.getEmail());
        updateLeads.setPhone(leads.getPhone());
        updateLeads.setNotes(leads.getNotes());
        updateLeads.setSource(leads.getSource());
        updateLeads.setStatus(leads.getStatus());

        return this.LeadRepository.save(updateLeads);
    }
    @Override
    public void deleteLead(long id){
        Leads delLeads = LeadRepository.findById(id).orElseThrow(()->new RuntimeException("Lead not found"));
        this.LeadRepository.delete(delLeads);
    }
}
