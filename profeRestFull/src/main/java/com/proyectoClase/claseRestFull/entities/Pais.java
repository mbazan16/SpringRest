package com.proyectoClase.claseRestFull.entities;



import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "COUNTRIES")
public class Pais {

    @Id
    @Column(name="COUNTRY_ID")
    private String id;
    @Column(name="COUNTRY_NAME")
    private String nombre;

    @ManyToOne
    @JoinColumn(name = "REGION_ID")
    private Region region;
}
