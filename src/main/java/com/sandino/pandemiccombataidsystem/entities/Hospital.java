package com.sandino.pandemiccombataidsystem.entities;

import java.time.LocalDateTime;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.UpdateTimestamp;

@Entity
public class Hospital {

    @Id
    @GeneratedValue(generator = "uuid2")
    @GenericGenerator(name = "uuid2", strategy = "org.hibernate.id.UUIDGenerator")
    @Column(columnDefinition = "VARCHAR(255)")
    private String id;

    @Column
    private String name;

    @Column
    private String address;

    @Column
    private String cnpj;

    @Column
    private double latitude;

    @Column
    private double longitude;

    @Column
    private double occupationPercentage;

    @Column
    private LocalDateTime occupationUpdatedAt;

    @OneToMany(mappedBy = "hospital")
    @JsonManagedReference
    private List<Resource> resources;

    @CreationTimestamp
    private LocalDateTime createdAt;

    @UpdateTimestamp
    private LocalDateTime updatedAt;

    public Hospital() {
    }

    public Hospital(String name, String address, String cnpj, double latitude, double longitude,
            double occupationPercentage, LocalDateTime occupationUpdatedAt) {
        this.name = name;
        this.address = address;
        this.cnpj = cnpj;
        this.latitude = latitude;
        this.longitude = longitude;
        this.occupationPercentage = occupationPercentage;
        this.occupationUpdatedAt = occupationUpdatedAt;
    }

    public Hospital(String id, String name, String address, String cnpj, double latitude, double longitude,
            double occupationPercentage, LocalDateTime occupationUpdatedAt, List<Resource> resources,
            LocalDateTime createdAt, LocalDateTime updatedAt) {
        this.id = id;
        this.name = name;
        this.address = address;
        this.cnpj = cnpj;
        this.latitude = latitude;
        this.longitude = longitude;
        this.occupationPercentage = occupationPercentage;
        this.occupationUpdatedAt = occupationUpdatedAt;
        this.resources = resources;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }

    public double getLatitude() {
        return latitude;
    }

    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    public double getLongitude() {
        return longitude;
    }

    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }

    public double getOccupationPercentage() {
        return occupationPercentage;
    }

    public void setOccupationPercentage(double occupationPercentage) {
        this.occupationPercentage = occupationPercentage;
    }

    public LocalDateTime getOccupationUpdatedAt() {
        return occupationUpdatedAt;
    }

    public void setOccupationUpdatedAt(LocalDateTime occupationUpdatedAt) {
        this.occupationUpdatedAt = occupationUpdatedAt;
    }

    public List<Resource> getResources() {
        return resources;
    }

    public void setResources(List<Resource> resources) {
        this.resources = resources;
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
        return "Hospital [address=" + address + ", cnpj=" + cnpj + ", createdAt=" + createdAt + ", id=" + id
                + ", latitude=" + latitude + ", longitude=" + longitude + ", name=" + name + ", occupationPercentage="
                + occupationPercentage + ", occupationUpdatedAt=" + occupationUpdatedAt + ", resources=" + resources
                + ", updatedAt=" + updatedAt + "]";
    }
}
