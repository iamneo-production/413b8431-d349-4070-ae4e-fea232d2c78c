package com.example.springapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.springapp.model.Ticket;

public interface TicketRepository extends JpaRepository<Ticket, Long>{

}
