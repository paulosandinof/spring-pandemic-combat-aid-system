package com.sandino.pandemiccombataidsystem.dtos;

import java.util.List;

public class HospitalDTO {

    private String name;

    private String address;

    private String cnpj;

    private double latitude;

    private double longitude;

    private double occupationPercentage;

    private List<ResourceDTO> resources;

    public HospitalDTO(String name, String address, String cnpj, double latitude, double longitude,
            double occupationPercentage, List<ResourceDTO> resources) {
        this.name = name;
        this.address = address;
        this.cnpj = cnpj;
        this.latitude = latitude;
        this.longitude = longitude;
        this.occupationPercentage = occupationPercentage;
        this.resources = resources;
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

    public List<ResourceDTO> getResources() {
        return resources;
    }

    public void setResources(List<ResourceDTO> resources) {
        this.resources = resources;
    }
}
