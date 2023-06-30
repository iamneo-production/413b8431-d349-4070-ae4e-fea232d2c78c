package main.java.com.example.springapp.controller;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.springapp.model.Ticket;
import com.example.springapp.repository.TicketRepository;
import com.example.springapp.service.TicketService;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/api/v1/")
public class TicketController {

	@Autowired
	private TicketRepository ticketRepository;
	
	// get all tickets
	@GetMapping("/tickets")
	public List<Ticket> getAllTickets(){
		return ticketRepository.findAll();
	}		
	
	// create ticket rest api
	@PostMapping("/tickets")
	public Ticket createTicket(@RequestBody Ticket ticket) {
		return ticketRepository.save(ticket);
	}
	
	// get ticket by id rest api
	@GetMapping("/tickets/{id}")
	public ResponseEntity<Ticket> getTicketById(@PathVariable Long id) {
		Ticket ticket = ticketRepository.findById(id)
				.orElseThrow(() -> new TicketService("Ticket not exist with id :" + id));
		return ResponseEntity.ok(ticket);
	}
	
	// update ticket rest api
	
	@PutMapping("/tickets/{id}")
	public ResponseEntity<Ticket> updateTicket(@PathVariable Long id, @RequestBody Ticket ticketDetails){
		Ticket ticket = ticketRepository.findById(id)
				.orElseThrow(() -> new TicketService("Ticket not exist with id :" + id));
		
		ticket.setCustomerId(ticketDetails.getCustomerId());
		ticket.setSubject(ticketDetails.getSubject());
		ticket.setDescription(ticketDetails.getDescription());
		ticket.setStatus(ticketDetails.getStatus());
		ticket.setAssignedTo(ticketDetails.getAssignedTo());
		ticket.setCreatedAt(ticketDetails.getCreatedAt());
		ticket.setUpdatedAt(ticketDetails.getUpdatedAt());

		Ticket updatedTicket = ticketRepository.save(ticket);
		return ResponseEntity.ok(updatedTicket);
	}
	
	// delete ticket rest api
	@DeleteMapping("/tickets/{id}")
	public ResponseEntity<Map<String, Boolean>> deleteTicket(@PathVariable Long id){
		Ticket ticket = ticketRepository.findById(id)
				.orElseThrow(() -> new TicketService("ticket not exist with id :" + id));
		
		ticketRepository.delete(ticket);
		Map<String, Boolean> response = new HashMap<>();
		response.put("deleted", Boolean.TRUE);
		return ResponseEntity.ok(response);
	}
	
	
}
