package com.example.esAPI_CustomQuery2.enums;

public enum FlightStatusEnum {
    ONTIME(1, "The flight is on time"),
    DELAYED(2, "The flight has been delayed"),
    CANCELED(3, "The flight has been canceled");

    // Meglio passare l'id piuttosto che l'enumerato se si ha a che fare con un database
    private Integer id;
    private String descrizione;

    FlightStatusEnum(Integer id, String descrizione) {
        this.id = id;
        this.descrizione = descrizione;
    }

    public Integer getId() {
        return id;
    }

    public String getDescrizione() {
        return descrizione;
    }
}