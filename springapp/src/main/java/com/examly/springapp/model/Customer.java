package com.examly.springapp.model;

import javax.persistence.*;
import java.util.List;

@Entity
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String email;
    private String phone;
    private String address;

    @ElementCollection
    @CollectionTable(name = "communication_history_list", joinColumns = @JoinColumn(name = "communication_id"))
    @Column(name = "communication")
    private List<String> communicationHistory;

    @ElementCollection
    @CollectionTable(name = "purchase_history_list", joinColumns = @JoinColumn(name = "purchase_id"))
    @Column(name = "purchase")
    private List<String> purchaseHistory;
    public Customer() {
    }
    public Customer(String name, String email, String phone, String address,
                    List<String> communicationHistory, List<String> purchaseHistory) {
        this.name = name;
        this.email = email;
        this.phone = phone;
        this.address = address;
        this.communicationHistory = communicationHistory;
        this.purchaseHistory = purchaseHistory;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public List<String> getCommunicationHistory() {
        return communicationHistory;
    }

    public void setCommunicationHistory(List<String> communicationHistory) {
        this.communicationHistory = communicationHistory;
    }

    public List<String> getPurchaseHistory() {
        return purchaseHistory;
    }

    public void setPurchaseHistory(List<String> purchaseHistory) {
        this.purchaseHistory = purchaseHistory;
    }
}