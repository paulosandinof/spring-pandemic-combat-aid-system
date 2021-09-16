package com.sandino.pandemiccombataidsystem.dtos;

import com.sandino.pandemiccombataidsystem.entities.ResourceType;

public class AverageResourceTypeDTO {

    private ResourceType resourceType;
    private double averageQuantity;

    public AverageResourceTypeDTO() {
    }

    public AverageResourceTypeDTO(ResourceType resourceType, double averageQuantity) {
        this.resourceType = resourceType;
        this.averageQuantity = averageQuantity;
    }

    public ResourceType getResourceType() {
        return resourceType;
    }

    public void setResourceType(ResourceType resourceType) {
        this.resourceType = resourceType;
    }

    public double getAverageQuantity() {
        return averageQuantity;
    }

    public void setAverageQuantity(double averageQuantity) {
        this.averageQuantity = averageQuantity;
    }

    @Override
    public String toString() {
        return "AverageResourceTypeDTO [averageQuantity=" + averageQuantity + ", resourceType=" + resourceType + "]";
    }
}
