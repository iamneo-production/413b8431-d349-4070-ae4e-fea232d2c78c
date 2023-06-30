package com.example.springapp.service;

import java.util.List;

import com.example.springapp.model.Leads;

public interface LeadServiceInterface {
     public Leads addLead(Leads leads);
    public List<Leads> getLeads();
    public Leads getLeadById(long id);
    public Leads updateLead(long id, Leads leads);
    public void deleteLead(long id);
}
