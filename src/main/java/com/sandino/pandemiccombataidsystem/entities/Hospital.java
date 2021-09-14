package com.sandino.pandemiccombataidsystem.entities;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import org.hibernate.annotations.GenericGenerator;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
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
}
