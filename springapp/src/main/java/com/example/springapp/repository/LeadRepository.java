package com.example.springapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.springapp.model.Leads;

public interface LeadRepository extends JpaRepository<Leads,Long>{

}
    