package com.example.esAPI_CustomQuery2.entities;


import jakarta.persistence.*;

@Entity
@Table(name = "flights")
public class Flight {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String description;
    private String fromAirport;
    private String toAirport;
    private Integer statusEnumId;

    public Flight() {
    }

    public Flight(Long id, String description, String fromAirport, String toAirport, Integer statusEnumId) {
        this.id = id;
        this.description = description;
        this.fromAirport = fromAirport;
        this.toAirport = toAirport;
        this.statusEnumId = statusEnumId;
    }

    public Long getId() {
        return id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getFromAirport() {
        return fromAirport;
    }

    public void setFromAirport(String fromAirport) {
        this.fromAirport = fromAirport;
    }

    public String getToAirport() {
        return toAirport;
    }

    public void setToAirport(String toAirport) {
        this.toAirport = toAirport;
    }

    public Integer getStatusEnumId() {
        return statusEnumId;
    }

    public void setStatusEnumId(Integer statusEnumId) {
        this.statusEnumId = statusEnumId;
    }
}