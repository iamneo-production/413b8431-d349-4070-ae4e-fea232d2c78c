package com.example.springapp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.springapp.model.Leads;
import com.example.springapp.service.LeadServiceInterface;

@RestController
public class LeadController {

    @Autowired
    private LeadServiceInterface leadService;

    // Leads - GET,PUT,POST,DELETE operations

    @PostMapping("/lead")
    public ResponseEntity<Boolean> createLead(@RequestBody Leads leads){
        try{
             this.leadService.addLead(leads);
             return ResponseEntity.status(HttpStatus.OK).body(true);
        }catch(Exception e){
            // return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(false);
        }
    }
    //GET-Displaying leads
    @GetMapping("/lead")
    public ResponseEntity<List<Leads>> retrieveLeads(){

            return ResponseEntity.ok(this.leadService.getLeads());
    }
    //GET-one customer based on ID
    @GetMapping("/lead/{id}")
    public ResponseEntity<Leads> getLeadById(@PathVariable("id") long id){
        if((this.leadService.getLeadById(id))!=null){
            return ResponseEntity.ok(this.leadService.getLeadById(id));
        }else {
            return ResponseEntity.notFound().build();
        }
    }
    //PUT-updating lead details
    @PutMapping("/lead/{id}")
    public ResponseEntity<Void> updateLead(@PathVariable long id, @RequestBody Leads leads){
        this.leadService.updateLead(id,leads);
        return ResponseEntity.ok().build();
    }
    //DELETE - removes specific lead
    @DeleteMapping("/lead/{id}")
    public ResponseEntity<Void> deleteLead(@PathVariable long id){
        this.leadService.deleteLead(id);
        return ResponseEntity.ok().build();
    }
}
