package com.sandino.pandemiccombataidsystem.dtos;

import java.util.List;

public class ExchangeDTO {

    private String hospitalId;
    private List<String> resources;

    public ExchangeDTO() {
    }

    public ExchangeDTO(String hospitalId, List<String> resources) {
        this.hospitalId = hospitalId;
        this.resources = resources;
    }

    public String getHospitalId() {
        return hospitalId;
    }

    public void setHospitalId(String hospitalId) {
        this.hospitalId = hospitalId;
    }

    public List<String> getResources() {
        return resources;
    }

    public void setResources(List<String> resources) {
        this.resources = resources;
    }

    @Override
    public String toString() {
        return "ExchangeDTO [hospitalId=" + hospitalId + ", resources=" + resources + "]";
    }
}
