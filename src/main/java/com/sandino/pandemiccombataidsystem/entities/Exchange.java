package com.sandino.pandemiccombataidsystem.entities;

import java.time.LocalDateTime;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.UpdateTimestamp;

@Entity
public class Exchange {

    @Id
    @GeneratedValue(generator = "uuid2")
    @GenericGenerator(name = "uuid2", strategy = "org.hibernate.id.UUIDGenerator")
    @Column(columnDefinition = "VARCHAR(255)")
    private String id;

    @ManyToOne
    private Hospital sender;

    @ManyToOne
    private Hospital receiver;

    @OneToMany(mappedBy = "exchange")
    @JsonManagedReference
    private List<ExchangeResource> exchangeResources;

    @CreationTimestamp
    private LocalDateTime createdAt;

    @UpdateTimestamp
    private LocalDateTime updatedAt;

    public Exchange() {
    }

    public Exchange(Hospital sender, Hospital receiver) {
        this.sender = sender;
        this.receiver = receiver;
    }

    public Exchange(String id, Hospital sender, Hospital receiver, List<ExchangeResource> exchangeResources,
            LocalDateTime createdAt, LocalDateTime updatedAt) {
        this.id = id;
        this.sender = sender;
        this.receiver = receiver;
        this.exchangeResources = exchangeResources;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Hospital getSender() {
        return sender;
    }

    public void setSender(Hospital sender) {
        this.sender = sender;
    }

    public Hospital getReceiver() {
        return receiver;
    }

    public void setReceiver(Hospital receiver) {
        this.receiver = receiver;
    }

    public List<ExchangeResource> getExchangeResources() {
        return exchangeResources;
    }

    public void setExchangeResources(List<ExchangeResource> exchangeResources) {
        this.exchangeResources = exchangeResources;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public LocalDateTime getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(LocalDateTime updatedAt) {
        this.updatedAt = updatedAt;
    }

    @Override
    public String toString() {
        return "Exchange [createdAt=" + createdAt + ", exchangeResources=" + exchangeResources + ", id=" + id
                + ", receiver=" + receiver + ", sender=" + sender + ", updatedAt=" + updatedAt + "]";
    }
}
