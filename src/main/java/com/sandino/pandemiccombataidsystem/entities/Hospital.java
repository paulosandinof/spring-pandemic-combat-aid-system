package com.sandino.pandemiccombataidsystem.entities;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import org.hibernate.annotations.GenericGenerator;

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

    @OneToMany
    private List<Resource> resources;

    public Hospital() {
    }

    public Hospital(String name, String address, String cnpj, double latitude, double longitude,
            double occupationPercentage, List<Resource> resources) {
        this.name = name;
        this.address = address;
        this.cnpj = cnpj;
        this.latitude = latitude;
        this.longitude = longitude;
        this.occupationPercentage = occupationPercentage;
        this.resources = resources;
    }

    public Hospital(String id, String name, String address, String cnpj, double latitude, double longitude,
            double occupationPercentage, List<Resource> resources) {
        this.id = id;
        this.name = name;
        this.address = address;
        this.cnpj = cnpj;
        this.latitude = latitude;
        this.longitude = longitude;
        this.occupationPercentage = occupationPercentage;
        this.resources = resources;
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

    public List<Resource> getResources() {
        return resources;
    }

    public void setResources(List<Resource> resources) {
        this.resources = resources;
    }

    @Override
    public String toString() {
        return "Hospital [address=" + address + ", cnpj=" + cnpj + ", id=" + id + ", latitude=" + latitude
                + ", longitude=" + longitude + ", name=" + name + ", occupationPercentage=" + occupationPercentage
                + ", resources=" + resources + "]";
    }
}
