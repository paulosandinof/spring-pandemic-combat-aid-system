package com.sandino.pandemiccombataidsystem.dtos;

public class ResourceDTO {

    private String name;

    private String type;

    public ResourceDTO() {
    }

    public ResourceDTO(String name, String type) {
        this.name = name;
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return "ResourceDTO [name=" + name + ", type=" + type + "]";
    }
}
